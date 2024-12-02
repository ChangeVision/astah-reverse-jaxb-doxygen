package com.change_vision.astah.extension.plugin.reverser;

import static com.change_vision.astah.extension.plugin.reverser.DoxygenUtil.bool;
import static java.lang.String.format;

import java.io.File;
import java.io.FileInputStream;
import java.io.Serializable;
import java.util.List;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Node;

import com.change_vision.astah.extension.plugin.common.AstahModelUtil;
import com.change_vision.astah.extension.plugin.common.NamespaceClass;
import com.change_vision.astah.extension.plugin.doxygen._1_8_4.compound.CompoundRefType;
import com.change_vision.astah.extension.plugin.doxygen._1_8_4.compound.CompounddefType;
import com.change_vision.astah.extension.plugin.doxygen._1_8_4.compound.DoxCompoundKind;
import com.change_vision.astah.extension.plugin.doxygen._1_8_4.compound.DoxygenType;
import com.change_vision.astah.extension.plugin.doxygen._1_8_4.compound.EnumvalueType;
import com.change_vision.astah.extension.plugin.doxygen._1_8_4.compound.LinkedTextType;
import com.change_vision.astah.extension.plugin.doxygen._1_8_4.compound.MemberdefType;
import com.change_vision.astah.extension.plugin.doxygen._1_8_4.compound.ParamType;
import com.change_vision.astah.extension.plugin.doxygen._1_8_4.compound.RefTextType;

import jakarta.inject.Inject;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.Unmarshaller;

public class TypeUtil {
	class RawtypeAndRef {
		String rawtype;
		String refId;
	}

	private static final Logger LOG = LoggerFactory.getLogger(TypeUtil.class);

	private static final String CONST = "const ";
	private static final String FRIEND = "friend ";
	private static final String VOLATILE = "volatile ";
	private static final String TEMPLATE_BEGIN = "<";
	private static final String TEMPLATE_END = ">";

	private static final String POINTER = "*";
	private static final String REF = "&";

	private static final String ANONYMOUS_PARAM = "p_";

	private AstahModelUtil astahModelUtil;
	private File xmlDir;

	private long globalCount;

	public TypeUtil() {
	}

	protected Type parseType(String typeStr) {
		StringBuilder sb = new StringBuilder(typeStr);
		Type type = new Type();
		int constIndex = sb.indexOf(CONST);
		if (constIndex >= 0) {
			sb.delete(0, CONST.length());
			type.setConst(true);
			LOG.trace(sb.toString());
		}
		int friendIndex = sb.indexOf(FRIEND);
		if (friendIndex >= 0) {
			sb.delete(0, FRIEND.length());
			type.setFriend(true);
			LOG.trace(sb.toString());
		}
		int templateBegin = sb.indexOf(TEMPLATE_BEGIN);
		int templateEnd = sb.lastIndexOf(TEMPLATE_END);
		if (templateBegin == 0 && templateEnd == sb.length() - 1) {
			sb.delete(templateEnd, templateEnd + 1);
			sb.delete(templateBegin, templateBegin + 1);
		} else if (templateBegin >= 0 && templateBegin <= templateEnd && templateEnd <= sb.length()) {
			type.setTemplates(sb.substring(templateBegin + 1, templateEnd).trim());
			sb.delete(templateBegin, templateEnd + 1);
			LOG.trace(sb.toString());
		}
		int pIndex = sb.indexOf(POINTER);
		int rIndex = sb.indexOf(REF);
		int beginIndex = pIndex > rIndex ? pIndex : rIndex;
		if (beginIndex >= 0) {
			type.setTypeModifier(sb.substring(beginIndex).trim());
			sb.delete(beginIndex, sb.length());
		}
		type.setNamespaceClass(this.astahModelUtil.getParentNamespace(sb.toString().trim()));

		return type;
	}

	private String eraseWhitespace(String str) {
		return str.replace("\r\n", "").replace("\r", "").replace("\n", "").replace("\t", "").trim();
	}

	private String toStringMultiplicity(Object mp) {
		if (mp instanceof Node) {
			Node n = (Node) mp;
			return n.getTextContent().replace("[", "").replace("]", "").trim();
		}
		return "";
	}

	public Type createType(CompoundRefType compoundRefType) {
		NamespaceClass parentNamespace = this.astahModelUtil.getParentNamespace(compoundRefType.getValue());
		Type type = this.parseType(parentNamespace.clazz);
		CompounddefType compounddef = this.getCompounddefByLoadXml(compoundRefType.getRefid());
		if (compounddef != null) {
			type.setNamespaceClass(this.astahModelUtil.getParentNamespace(compounddef.getCompoundname()));
			type.setVisiblity(compoundRefType.getProt().value());
			type.setRefId(compoundRefType.getRefid());
		}
		return type;
	}

	public Type createType(ParamType param) {
		Type type = new Type();
		{
			if (param.getDefval() != null) {
				List<Serializable> contents = param.getDefval().getContent();
				StringBuilder sb = new StringBuilder();
				for (Serializable content : contents) {
					if (content instanceof JAXBElement) {
						@SuppressWarnings("unchecked")
						RefTextType refTextType = ((JAXBElement<RefTextType>) content).getValue();
						CompounddefType compounddefType = this.getCompounddefByLoadXml(refTextType.getRefid());
						if (compounddefType != null) {
							sb.append(this.eraseWhitespace(compounddefType.getCompoundname()));
							sb.append(" ");
						}
					} else {
						sb.append(this.eraseWhitespace(content.toString()));
						sb.append(" ");
					}
				}
				type.setNamespaceClass(this.astahModelUtil.getParentNamespace(sb.toString().trim()));
			}
		}
		{
			Object o = param.getDefname();
			if (o == null) {
				o = param.getDeclname();
			}
			if (o != null && o instanceof Node) {
				Node n = (Node) o;
				type.setName(n.getTextContent().trim());
			} else {
				StringBuilder sb = new StringBuilder();
				LinkedTextType linkedText = param.getType();
				List<Serializable> contents = linkedText.getContent();
				for (Serializable content : contents) {
					sb.append(content.toString());
					sb.append(" ");
				}
				type.setName(sb.toString().replace("class", "").trim());
			}
		}
		return type;
	}

	public Type createType(MemberdefType memberdefType) {
		LinkedTextType linkedTextType = memberdefType.getType();
		RawtypeAndRef raw = this.toRawtypeByLinkedTextType(linkedTextType);
		Type type = this.parseType(raw.rawtype);
		type.setRefId(raw.refId);
		type.setStatic(bool(memberdefType.getStatic()));
		if (memberdefType.getArgsstring() != null) {
			type.setMultiplicity(this.toStringMultiplicity(memberdefType.getArgsstring()));
		}
		type.setVisiblity(memberdefType.getProt().value());
		if (memberdefType.getConst() != null) {
			type.setConst(bool(memberdefType.getConst()));
		}
		type.setExplicit(bool(memberdefType.getExplicit()));
		type.setInline(bool(memberdefType.getInline()));
		if (memberdefType.getVirt() != null) {
			type.setVirt(memberdefType.getVirt().value());
		}
		type.setMutable(bool(memberdefType.getMutable()));
		if (memberdefType.getDefinition() instanceof Node) {
			Node n = (Node) memberdefType.getDefinition();
			String definition = n.getTextContent();
			if (definition.startsWith(VOLATILE)) {
				type.setVolatile(true);
			}
		}
		if (memberdefType.getName() instanceof Node) {
			Node n = (Node) memberdefType.getName();
			type.setName(n.getTextContent());
		}
		if (StringUtils.isEmpty(type.getName())) {
			type.setName(format("%s%d", ANONYMOUS_PARAM, this.nextCount()));
		}
		return type;
	}

	public Type createMemberParamType(ParamType param) {
		RawtypeAndRef raw = toRawtypeByLinkedTextType(param.getType());
		Type type = this.parseType(raw.rawtype);
		type.setRefId(raw.refId);
		if (param.getDeclname() != null && param.getDeclname() instanceof Node) {
			Node n = (Node) param.getDeclname();
			type.setName(n.getTextContent());
		} else {
			type.setName(format("%s%d", ANONYMOUS_PARAM, this.nextCount()));
		}
		return type;
	}

	public Type createEnumType(MemberdefType memberdefType) {
		Type type = new Type();
		if (memberdefType.getName() instanceof Node) {
			Node n = (Node) memberdefType.getName();
			type.setName(n.getTextContent());
		}
		type.setVisiblity(memberdefType.getProt().value());
		return type;
	}

	public Type createEnumType(EnumvalueType enumvalueType) {
		Type type = new Type();
		StringBuilder sb = new StringBuilder();
		List<Serializable> contents = enumvalueType.getContent();
		for (Serializable content : contents) {
			if (content instanceof JAXBElement) {
				Object o = ((JAXBElement<?>) content).getValue();
				if (o instanceof Node) {
					sb.append(this.eraseWhitespace(((Node) o).getTextContent()));
				} else if (o instanceof LinkedTextType) {
					type.setInitialValue(toRawtypeByLinkedTextType((LinkedTextType) o).rawtype.replace('=', ' ').trim());
					// } else if (o instanceof DescriptionType) {
					// DescriptionType descriptionType = (DescriptionType) o;
					// descriptionType.getContent();
				}
			} else {
				sb.append(this.eraseWhitespace(content.toString()));
			}
			sb.append(" ");
		}
		type.setName(sb.toString().trim());
		type.setVisiblity(enumvalueType.getProt().value());
		return type;
	}

	public Type createEnumType(CompounddefType compounddefType) {
		NamespaceClass namespaceClass = new NamespaceClass();
		if (compounddefType.getKind() == DoxCompoundKind.NAMESPACE) {
			namespaceClass.namespace = compounddefType.getCompoundname();
		} else if (compounddefType.getKind() == DoxCompoundKind.FILE) {
			namespaceClass = this.astahModelUtil.getParentNamespace(compounddefType.getCompoundname());
		}
		namespaceClass.clazz = "GLOBAL";
		Type type = new Type();
		type.setNamespaceClass(namespaceClass);
		return type;
	}

	protected RawtypeAndRef toRawtypeByLinkedTextType(LinkedTextType linkedTextType) {
		RawtypeAndRef raw = new RawtypeAndRef();
		StringBuilder sb = new StringBuilder();
		List<Serializable> contents = linkedTextType.getContent();
		for (Serializable content : contents) {
			if (content instanceof JAXBElement) {
				@SuppressWarnings("unchecked")
				RefTextType refTextType = ((JAXBElement<RefTextType>) content).getValue();
				CompounddefType compounddefType = this.getCompounddefByLoadXml(refTextType.getRefid());
				raw.refId = refTextType.getRefid();
				if (compounddefType != null) {
					sb.append(this.eraseWhitespace(compounddefType.getCompoundname()));
				} else {
					sb.append(this.eraseWhitespace(refTextType.getValue()));
				}
			} else {
				sb.append(this.eraseWhitespace(content.toString()));
			}
			sb.append(" ");
		}
		raw.rawtype = sb.toString().trim();
		return raw;
	}

	/*
	 * TODO ここでよい？
	 */
	protected CompounddefType getCompounddefByLoadXml(String ref) {
		XMLStreamReader r = null;
		try {
			XMLInputFactory factory = XMLInputFactory.newInstance();
			File file = new File(format("%s/%s.xml", this.xmlDir.getAbsoluteFile(), ref));
			if (!file.exists()) {
				return null;
			}
			r = factory.createXMLStreamReader(new FileInputStream(file));
			ClassLoader classLoader = com.change_vision.astah.extension.plugin.doxygen._1_8_4.compound.ObjectFactory.class.getClassLoader();
			JAXBContext context = JAXBContext.newInstance("com.change_vision.astah.extension.plugin.doxygen._1_8_4.compound", classLoader);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			JAXBElement<DoxygenType> element = unmarshaller.unmarshal(r, DoxygenType.class);
			DoxygenType doxygenType = element.getValue();
			return doxygenType.getCompounddef().get(0);
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
			return null;
		} finally {
			if (r != null) {
				try {
					r.close();
				} catch (XMLStreamException e) {
					LOG.error(e.getMessage(), e);
				}
			}
		}
	}

	public long nextCount() {
		return globalCount++;
	}

	@Inject
	public void setAstahModelUtil(AstahModelUtil astahModelUtil) {
		this.astahModelUtil = astahModelUtil;
	}

	@Inject
	public void setXmlDir(File xmlDir) {
		this.xmlDir = xmlDir;
	}

}

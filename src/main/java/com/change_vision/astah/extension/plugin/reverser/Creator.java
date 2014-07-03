package com.change_vision.astah.extension.plugin.reverser;

import static java.lang.String.format;
import static org.apache.commons.lang3.StringUtils.isEmpty;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;
import javax.xml.bind.JAXBElement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.change_vision.astah.extension.plugin.common.AstahModelUtil;
import com.change_vision.astah.extension.plugin.common.NamespaceClass;
import com.change_vision.astah.extension.plugin.doxygen._1_8_4.compound.CompoundRefType;
import com.change_vision.astah.extension.plugin.doxygen._1_8_4.compound.CompounddefType;
import com.change_vision.astah.extension.plugin.doxygen._1_8_4.compound.DescriptionType;
import com.change_vision.astah.extension.plugin.doxygen._1_8_4.compound.DocParaType;
import com.change_vision.astah.extension.plugin.doxygen._1_8_4.compound.DocParamListItem;
import com.change_vision.astah.extension.plugin.doxygen._1_8_4.compound.DocParamListType;
import com.change_vision.astah.extension.plugin.doxygen._1_8_4.compound.DocParamName;
import com.change_vision.astah.extension.plugin.doxygen._1_8_4.compound.DocParamNameList;
import com.change_vision.astah.extension.plugin.doxygen._1_8_4.compound.DocParamType;
import com.change_vision.astah.extension.plugin.doxygen._1_8_4.compound.DocSimpleSectType;
import com.change_vision.astah.extension.plugin.doxygen._1_8_4.compound.DoxCompoundKind;
import com.change_vision.astah.extension.plugin.doxygen._1_8_4.compound.DoxMemberKind;
import com.change_vision.astah.extension.plugin.doxygen._1_8_4.compound.DoxSectionKind;
import com.change_vision.astah.extension.plugin.doxygen._1_8_4.compound.DoxVirtualKind;
import com.change_vision.astah.extension.plugin.doxygen._1_8_4.compound.EnumvalueType;
import com.change_vision.astah.extension.plugin.doxygen._1_8_4.compound.MemberdefType;
import com.change_vision.astah.extension.plugin.doxygen._1_8_4.compound.ParamType;
import com.change_vision.astah.extension.plugin.doxygen._1_8_4.compound.SectiondefType;
import com.change_vision.astah.extension.plugin.doxygen._1_8_4.compound.TemplateparamlistType;
import com.change_vision.jude.api.inf.editor.BasicModelEditor;
import com.change_vision.jude.api.inf.exception.InvalidEditingException;
import com.change_vision.jude.api.inf.exception.ProjectNotFoundException;
import com.change_vision.jude.api.inf.model.IAssociation;
import com.change_vision.jude.api.inf.model.IAttribute;
import com.change_vision.jude.api.inf.model.IClass;
import com.change_vision.jude.api.inf.model.IElement;
import com.change_vision.jude.api.inf.model.IGeneralization;
import com.change_vision.jude.api.inf.model.IModel;
import com.change_vision.jude.api.inf.model.INamedElement;
import com.change_vision.jude.api.inf.model.IOperation;
import com.change_vision.jude.api.inf.model.IPackage;
import com.change_vision.jude.api.inf.model.IParameter;
import com.change_vision.jude.api.inf.model.ITaggedValue;
import com.change_vision.jude.api.inf.project.ProjectAccessor;

public class Creator {
	private static final Logger LOG = LoggerFactory.getLogger(Creator.class);

	private static final String CPLUS_CLASS = "C++ Class";
	private static final String CPLUS_ATTRIBUTE = "C++ Attribute";
	private static final String CPLUS_OPERATION = "C++ Method";
	private static final String CPLUS_PARAMETER = "C++ Parameter";

	private static final String STEREOTYPE_ENUM = "enum";

	private IModel project;
	private AstahModelUtil astahModelUtil;
	private ProjectAccessor projectAccessor;
	private BasicModelEditor basicModelEditor;
	private TypeUtil typeUtil;

	public Creator() {
		this.astahModelUtil = new AstahModelUtil();
	}

	public void createNamespace(IModel model, CompounddefType compounddefType) throws InvalidEditingException {
		if (compounddefType.getKind() == DoxCompoundKind.NAMESPACE) {
			String[] namespaces = compounddefType.getCompoundname().split("::");
			IPackage parentModel = model;
			for (String namespace : namespaces) {
				IPackage pkg;
				if ((pkg = this.getNamespace(parentModel, namespace)) == null) {
					// 無名名前空間で、doxygenの設定で表示しない場合(@から始まるパッケージ)は作成しない。
					if (!namespace.startsWith("@")) {
						parentModel = this.basicModelEditor.createPackage(parentModel, namespace);
						LOG.trace(format("create model : %s", parentModel.getFullName("::")));
						// パッケージ内のenumを作成する
						this.createEnum(compounddefType, parentModel);
					}
				} else {
					LOG.debug(String.format("%s is exits.", pkg.getFullName("::")));
					parentModel = pkg;
				}
			}
		}
	}

	protected IPackage getNamespace(IPackage pkg, String name) {
		INamedElement[] ownedElements = pkg.getOwnedElements();
		for (INamedElement namedElement : ownedElements) {
			if (name.equals(namedElement.getName()) && namedElement instanceof IPackage) {
				return (IPackage) namedElement;
			}
		}
		return null;
	}

	public INamedElement createClass(CompounddefType compounddefType) throws InvalidEditingException, ProjectNotFoundException {
		IModel project = initProject();
		if (compounddefType == null || compounddefType.getKind() == null) {
			return null;
		}
		INamedElement namedElement = this.astahModelUtil.getModelWithPath(IClass.class, project, compounddefType.getCompoundname());
		if (namedElement != null) {
			return namedElement;
		}
		switch (compounddefType.getKind()) {
		case CLASS:
			namedElement = this.createModel(IClass.class, compounddefType.getCompoundname(), compounddefType);
			break;
		case STRUCT:
			namedElement = this.createModel(IClass.class, compounddefType.getCompoundname(), compounddefType);
			break;
		case UNION:
			namedElement = this.createModel(IClass.class, compounddefType.getCompoundname(), compounddefType);
			break;
		case NAMESPACE:
			namedElement = this.createModel(IPackage.class, compounddefType.getCompoundname(), compounddefType);
			break;
		case CATEGORY:
		case DIR:
		case EXAMPLE:
		case EXCEPTION:
		case FILE:
		case GROUP:
		case INTERFACE:
		case PAGE:
		case PROTOCOL:
		default:
			LOG.trace(format("現在使っていないDoxCompoundKind : %s", compounddefType.getKind().toString()));
			break;
		}
		return namedElement;
	}

	protected <M extends INamedElement> M createModel(Class<M> clazz, String namespace, CompounddefType compounddefType)
			throws InvalidEditingException, ProjectNotFoundException {
		NamespaceClass parent = this.astahModelUtil.getParentNamespace(namespace);
		INamedElement parentElement = this.astahModelUtil.getParentModel(project, parent.namespace);
		if (parentElement == null) {
			// インナークラスの場合、親クラスを作る
			return this.createModel(clazz, parent.namespace, compounddefType);
		}
		INamedElement element = this.astahModelUtil.getParentModel(project, parent.getFullName());
		if (element != null) {
			@SuppressWarnings("unchecked")
			M m = (M) element;
			return m;
		}
		if (parentElement instanceof IPackage) {
			element = this.basicModelEditor.createClass((IPackage) parentElement, parent.clazz);
		} else if (parentElement instanceof IClass) {
			element = this.basicModelEditor.createClass((IClass) parentElement, parent.clazz);
		}
		LOG.trace(format("create model : %s", parent.getFullName()));
		this.setLanguage(CPLUS_CLASS, element);
		element.setDefinition(this.parseDescription(compounddefType.getDetaileddescription()));
		// クラス内のenumを作成する
		this.createEnum(compounddefType, element);

		@SuppressWarnings("unchecked")
		M m = (M) element;
		return m;
	}

	private String parseDescription(DescriptionType detaileddescription) {
		return this.parseContents(detaileddescription.getContent());
	}

	private String parseContents(List<Serializable> contents) {
		StringBuilder sb = new StringBuilder();
		for (Serializable content : contents) {
			if (content instanceof JAXBElement) {
				@SuppressWarnings("unchecked")
				Object o = ((JAXBElement<Object>) content).getValue();
				if (o instanceof DocParaType) {
					DocParaType para = (DocParaType) o;
					sb.append(parseContents(para.getContent())).append("\n");
				} else if (o instanceof DocSimpleSectType) {
					DocSimpleSectType simpleSect = (DocSimpleSectType) o;
					sb.append("\n@").append(simpleSect.getKind().value()).append(" ");
					List<Object> paraAndSimplesectseps = simpleSect.getParaAndSimplesectsep();
					for (Object o2 : paraAndSimplesectseps) {
						if (o2 instanceof DocParaType) {
							DocParaType para = (DocParaType) o2;
							sb.append(parseContents(para.getContent())).append("\n");
						} else {
							sb.append(" ");
						}
					}
				} else if (o instanceof DocParamListType) {
					DocParamListType paramlist = (DocParamListType) o;
					sb.append("\n@").append(paramlist.getKind().value());
					List<DocParamListItem> parameteritem = paramlist.getParameteritem();
					for (DocParamListItem listItem : parameteritem) {
						DescriptionType parameterdescription = listItem.getParameterdescription();
						if (parameterdescription != null) {
							sb.append(this.parseDescription(parameterdescription)).append("\n");
						}
						List<DocParamNameList> parameternamelist = listItem.getParameternamelist();
						for (DocParamNameList nameList : parameternamelist) {
							List<DocParamName> parametername = nameList.getParametername();
							for (DocParamName paramName : parametername) {
								sb.append(this.parseContents(paramName.getContent())).append("\n");
							}
							List<DocParamType> parametertype = nameList.getParametertype();
							for (DocParamType paramType : parametertype) {
								sb.append(this.parseContents(paramType.getContent())).append("\n");
							}
						}
					}
				} else if (o instanceof String) {
					sb.append(o.toString()).append("\n");
				}
			} else if (content instanceof String) {
				sb.append(content.toString()).append("\n");
			}
		}
		return sb.toString().trim();
	}

	protected void createEnum(CompounddefType compounddefType, INamedElement element) throws InvalidEditingException {
		List<SectiondefType> sectiondefTypes = compounddefType.getSectiondef();
		for (SectiondefType sectiondefType : sectiondefTypes) {
			List<MemberdefType> memberdefTypes = sectiondefType.getMemberdef();
			for (MemberdefType memberdefType : memberdefTypes) {
				if (memberdefType.getKind() != DoxMemberKind.ENUM) {
					continue;
				}
				Type type = this.typeUtil.createEnumType(memberdefType);
				IClass enumClass = null;
				try {
					if (element instanceof IPackage) {
						enumClass = this.basicModelEditor.createClass((IPackage) element, type.getName());
					} else if (element instanceof IClass) {
						enumClass = this.basicModelEditor.createClass((IClass) element, type.getName());
					}
				} catch (InvalidEditingException e) {
					// グローバルで同名は存在するので無視する
					if (!e.getKey().equals(InvalidEditingException.NAME_DOUBLE_ERROR_KEY)) {
						throw e;
					}
				}
				if (enumClass == null) {
					break;
				}
				enumClass.addStereotype(STEREOTYPE_ENUM);
				enumClass.setVisibility(type.getVisiblity());
				List<EnumvalueType> enumvalues = memberdefType.getEnumvalue();
				if (enumvalues == null) {
					break;
				}
				for (EnumvalueType enumvalue : enumvalues) {
					Type enumtype = this.typeUtil.createEnumType(enumvalue);
					IAttribute enumAttribute = this.basicModelEditor.createAttribute(enumClass, enumtype.getName(), enumClass);
					enumAttribute.setVisibility(enumtype.getVisiblity());
					enumAttribute.setInitialValue(enumtype.getInitialValue());
					// enum なので static とする
					enumAttribute.setStatic(true);
				}
			}
		}
	}

	public void modifyClass(CompounddefType compounddefType) throws ProjectNotFoundException, InvalidEditingException {
		// class, struct, union だけ処理する
		switch (compounddefType.getKind()) {
		case CLASS:
		case STRUCT:
		case UNION:
			break;
		case NAMESPACE:
		case CATEGORY:
		case DIR:
		case EXAMPLE:
		case EXCEPTION:
		case FILE:
		case GROUP:
		case INTERFACE:
		case PAGE:
		case PROTOCOL:
		default:
			LOG.trace(format("ここでは使用しないDoxCompoundKind : %s", compounddefType.getKind().toString()));
			return;
		}
		// IClass を 取得して、属性、操作等をセットする
		IClass clazz = this.astahModelUtil.getModelWithPath(IClass.class, project, compounddefType.getCompoundname());
		if (clazz == null) {
			LOG.debug(format("class is null. Compoundname : %s, id : %s", compounddefType.getCompoundname(), compounddefType.getId()));
			return;
		}
		addStereotypeFromCompounddefTypeKind(compounddefType, clazz);
		// テンプレートパラメーター
		createTemplateParamterFromTemprateparamlist(compounddefType, clazz);
		// 継承
		createInheritanceFromBaseCompoundDef(compounddefType, clazz);
		// 属性、操作
		createOperationOrAttributeFromSectionDefTypes(compounddefType, clazz);
	}

	private void createTemplateParamterFromTemprateparamlist(
			CompounddefType compounddefType, IClass clazz)
			throws ProjectNotFoundException, InvalidEditingException {
		TemplateparamlistType templateparamlist = compounddefType.getTemplateparamlist();
		if (templateparamlist != null) {
			List<ParamType> params = templateparamlist.getParam();
			for (ParamType param : params) {
				Type type = this.typeUtil.createType(param);
				try {
					IClass findClass = this.findClass(type);
					if (findClass == null) {
						this.basicModelEditor.createTemplateParameter(clazz, type.getName(), (IClass) null, null);
					} else {
						this.basicModelEditor.createTemplateParameter(clazz, type.getName(), (IClass) null, findClass);
					}
				} catch (InvalidEditingException e) {
					if (!e.getKey().equals(InvalidEditingException.NAME_DOUBLE_ERROR_KEY)) {
						throw e;
					}
					LOG.info("invalid editing {},{}",clazz.getName(),type.getName());
				}
			}
		}
	}

	private void createInheritanceFromBaseCompoundDef(
			CompounddefType compounddefType, IClass clazz)
			throws ProjectNotFoundException, InvalidEditingException {
		List<CompoundRefType> basecompoundrefs = compounddefType.getBasecompoundref();
		// 2つ同名の親が設定されているxmlがあるので、同じものは親としないためのチェック用。
		Set<String> generalizations = new HashSet<>();
		for (CompoundRefType basecompoundref : basecompoundrefs) {
			Type type = this.typeUtil.createType(basecompoundref);
			IGeneralization generalization = null;
			try {
				IClass baseClass = this.findClass(type);
				if (baseClass == null) {
					if (type.getNamespaceClass() != null || !isEmpty(type.getNamespaceClass().clazz)) {
						IClass generalizationClass = this.basicModelEditor.createClass(createPackage(type), type.getNamespaceClass().clazz);
						generalization = this.basicModelEditor.createGeneralization(clazz, generalizationClass, "");
						generalizations.add(type.getNamespaceClass().getFullName());
					}
				} else {
					if (!generalizations.contains(type.getNamespaceClass().getFullName())) {
						generalization = this.basicModelEditor.createGeneralization(clazz, baseClass, "");
						generalizations.add(type.getNamespaceClass().getFullName());
					}
				}
				if (!isEmpty(type.getVisiblity())) {
					generalization.setVisibility(type.getVisiblity());
				}
			} catch (InvalidEditingException e) {
				if (!e.getKey().equals(InvalidEditingException.NAME_DOUBLE_ERROR_KEY)) {
					throw e;
				}
				LOG.info("invalid editing {},{}",clazz.getName(),type.getName());
			}
		}
	}

	private void createOperationOrAttributeFromSectionDefTypes(
			CompounddefType compounddefType, IClass clazz)
			throws ProjectNotFoundException, InvalidEditingException {
		List<SectiondefType> sectiondefTypes = compounddefType.getSectiondef();
		for (SectiondefType sectiondefType : sectiondefTypes) {
			List<MemberdefType> memberdefTypes = sectiondefType.getMemberdef();
			for (MemberdefType memberdefType : memberdefTypes) {
				if (!(memberdefType.getKind() == DoxMemberKind.FUNCTION || memberdefType.getKind() == DoxMemberKind.VARIABLE || memberdefType.getKind() == DoxMemberKind.PROPERTY)) {
					continue;
				}
				Type type = this.typeUtil.createType(memberdefType);
				try {
					IClass findClass = this.findClass(type);
					if (memberdefType.getKind() == DoxMemberKind.FUNCTION) {
						this.createOperation(clazz, type, memberdefType, findClass);
					} else if (memberdefType.getKind() == DoxMemberKind.VARIABLE || memberdefType.getKind() == DoxMemberKind.PROPERTY) {
						this.createAttribute(clazz, type, memberdefType, findClass);
					} else {
						LOG.trace(format("ここでは使用しないDoxMemberKind : %s", memberdefType.getKind().toString()));
					}
				} catch (InvalidEditingException e) {
					if (!e.getKey().equals(InvalidEditingException.NAME_DOUBLE_ERROR_KEY)) {
						throw e;
					}
					LOG.info("invalid editing {},{}",clazz.getName(),type.getName());
				}
			}
		}
	}

	private void addStereotypeFromCompounddefTypeKind(
			CompounddefType compounddefType, IClass clazz) throws InvalidEditingException
			{
		try {
			switch (compounddefType.getKind()) {
			case STRUCT:
				clazz.addStereotype(DoxCompoundKind.STRUCT.value());
				break;
			case UNION:
				clazz.addStereotype(DoxCompoundKind.UNION.value());
				break;
			default:
				break;
			}
		} catch (InvalidEditingException e) {
			if (!e.getKey().equals(InvalidEditingException.NAME_DOUBLE_ERROR_KEY)) {
				throw e;
			}
			LOG.info("invalid editing {},{}",clazz.getName(),compounddefType.getKind());
		}
	}

	protected void createOperation(IClass clazz, Type type, MemberdefType memberdefType, IClass findClass) throws InvalidEditingException,
			ProjectNotFoundException {
		IOperation operation = null;
		if (LanguageManager.PRIMITIVE_TYPE.contains(type.getNamespaceClass().clazz)) {
			operation = this.basicModelEditor.createOperation(clazz, type.getName(), type.getNamespaceClass().clazz);
		} else {
			if (findClass == null) {
				if (clazz.getName().equals(type.getName()) || format("~%s", clazz.getName()).equals(type.getName())) {
					operation = this.basicModelEditor.createOperation(clazz, type.getName(), "");
				} else if (type.getNamespaceClass() != null && !isEmpty(type.getNamespaceClass().clazz)) {
					operation = this.basicModelEditor.createOperation(clazz, type.getName(), type.getNamespaceClass().clazz);
				}
			} else {
				operation = this.basicModelEditor.createOperation(clazz, type.getName(), (IClass) findClass);
			}
		}
		if (operation == null) {
			return;
		}
		// 操作のその他属性を作成
		this.setLanguage(CPLUS_OPERATION, operation);
		this.createParameter(operation, memberdefType.getParam());
		operation.setDefinition(this.parseDescription(memberdefType.getDetaileddescription()));
		operation.setVisibility(type.getVisiblity());
		if (type.isConst()) {
			this.createTaggedValue(operation, "jude.c_plus.const", "true");
		}
		if (type.getVirt().equals(DoxVirtualKind.VIRTUAL.value()) || type.getVirt().equals(DoxVirtualKind.PURE_VIRTUAL.value())) {
			this.createTaggedValue(operation, "jude.c_plus.virtual", "true");
		}
		if (type.isExplicit()) {
			this.createTaggedValue(operation, "jude.c_plus.explicit", "true");
		}
		if (type.isInline()) {
			this.createTaggedValue(operation, "jude.c_plus.inline", "true");
		}
		if (type.isFriend()) {
			this.createTaggedValue(operation, "jude.c_plus.friend", "true");
		}
	}

	protected void createParameter(IOperation operation, List<ParamType> params) throws InvalidEditingException, ProjectNotFoundException {
		for (ParamType param : params) {
			IParameter parameter = null;
			Type type = this.typeUtil.createMemberParamType(param);
			if (LanguageManager.PRIMITIVE_TYPE.contains(type.getNamespaceClass().clazz)) {
				parameter = this.basicModelEditor.createParameter(operation, type.getName(), type.getNamespaceClass().clazz);
			} else if (!isEmpty(type.getTemplates())) {
				parameter = this.basicModelEditor.createParameter(operation, type.getName(),
						astahModelUtil.clearNamespace(type.getTemplateParameter()));
			} else {
				IClass findClass = this.findClass(type);
				if (findClass == null) {
					if (type.getNamespaceClass() != null && !isEmpty(type.getNamespaceClass().clazz)) {
						parameter = this.basicModelEditor.createParameter(operation, type.getName(), type.getNamespaceClass().clazz);
					}
				} else {
					parameter = this.basicModelEditor.createParameter(operation, type.getName(), findClass);
				}
			}
			if (parameter != null) {
				this.setLanguage(CPLUS_PARAMETER, parameter);
				parameter.setTypeModifier(type.getTypeModifier());
			}
		}
	}

	protected void createAttribute(IClass clazz, Type type, MemberdefType memberdefType, IClass findClass) throws InvalidEditingException {
		this.createAttribute(clazz, type, memberdefType, findClass, true);
	}

	protected void createAttribute(IClass clazz, Type type, MemberdefType memberdefType, IClass findClass, boolean isAssociation)
			throws InvalidEditingException {
		IAttribute attribute = null;
		boolean memberEnd = false;
		if (LanguageManager.PRIMITIVE_TYPE.contains(type.getNamespaceClass().clazz)) {
			attribute = this.basicModelEditor.createAttribute(clazz, type.getName(), type.getNamespaceClass().clazz);
		} else if (!isEmpty(type.getTemplates())) {
			attribute = this.basicModelEditor.createAttribute(clazz, type.getName(), astahModelUtil.clearNamespace(type.getTemplateParameter()));
		} else {
			if (findClass == null) {
				if (type.getNamespaceClass() != null && !isEmpty(type.getNamespaceClass().clazz)) {
					attribute = this.basicModelEditor.createAttribute(clazz, type.getName(), type.getNamespaceClass().clazz);
				}
			} else {
				if (isAssociation) {
					IAssociation association = this.basicModelEditor.createAssociation(clazz, findClass, "", "", type.getName());
					IAttribute[] memberEnds = association.getMemberEnds();
					attribute = memberEnds[0];
					memberEnds[1].setNavigability("Navigable");
					attribute.setNavigability("Non_Navigable");
					memberEnd = true;
				} else {
					attribute = this.basicModelEditor.createAttribute(clazz, type.getName(), findClass);
				}
			}
		}
		if (attribute == null) {
			return;
		}
		this.setLanguage(CPLUS_ATTRIBUTE, attribute);
		// 属性のその他属性を作成
		attribute.setStatic(type.isStatic());
		attribute.setVisibility(type.getVisiblity());
		attribute.setDefinition(this.parseDescription(memberdefType.getDetaileddescription()));
		if (!isEmpty(type.getTypeModifier())) {
			attribute.setTypeModifier(type.getTypeModifier());
		}
		if (!memberEnd && type.isConst()) {
			this.createTaggedValue(attribute, "jude.c_plus.const", "true");
		}
		if (!memberEnd && type.isVolatile()) {
			this.createTaggedValue(attribute, "jude.c_plus.volatile", "true");
		}
		if (!memberEnd && type.isMutable()) {
			this.createTaggedValue(attribute, "jude.c_plus.mutable", "true");
		}
	}

	public void createGlobalClass(CompounddefType compounddefType) throws InvalidEditingException, ProjectNotFoundException {
		initProject();
		if (!isCreateGlobalClass(compounddefType)) {
			return;
		}
		Type type = this.typeUtil.createEnumType(compounddefType);
		if (isEmpty(type.getNamespaceClass().clazz)) {
			return;
		}
		if (this.findClass(type) != null) {
			return;
		}
		IPackage pkg = project;
		if (compounddefType.getKind() == DoxCompoundKind.NAMESPACE) {
			pkg = this.astahModelUtil.getModelWithPath(IPackage.class, project, compounddefType.getCompoundname());
		}
		IClass clazz = this.basicModelEditor.createClass(pkg, type.getNamespaceClass().clazz);
		this.setLanguage(CPLUS_CLASS, clazz);
		// グローバルな enum を作成
		this.createEnum(compounddefType, pkg);
	}

	public void modifyGlobalClass(CompounddefType compounddefType) throws InvalidEditingException, ProjectNotFoundException {
		if (!isCreateGlobalClass(compounddefType)) {
			return;
		}
		Type type = this.typeUtil.createEnumType(compounddefType);
		IClass findClass = this.findClass(type);
		if (findClass == null) {
			return;
		}
		// グローバルな属性・関数を作成
		List<SectiondefType> sectiondefTypes = compounddefType.getSectiondef();
		for (SectiondefType sectiondefType : sectiondefTypes) {
			if (!isCreateGlobalSectiondefType(sectiondefType)) {
				continue;
			}
			List<MemberdefType> memberdefTypes = sectiondefType.getMemberdef();
			for (MemberdefType memberdefType : memberdefTypes) {
				if (!isCreateGlobalMemberdefType(memberdefType)) {
					continue;
				}
				Type memberType = this.typeUtil.createType(memberdefType);
				IClass memberdefClass = this.findClass(memberType);
				if (memberdefType.getKind() == DoxMemberKind.FUNCTION) {
					this.createOperation(findClass, memberType, memberdefType, memberdefClass);
				} else if (memberdefType.getKind() == DoxMemberKind.VARIABLE) {
					try {
						this.createAttribute(findClass, memberType, memberdefType, memberdefClass, false);
					} catch (InvalidEditingException e) {
						// グローバルで同名は存在するので無視する
						if (!e.getKey().equals(InvalidEditingException.NAME_DOUBLE_ERROR_KEY)) {
							throw e;
						}
					}
				}
			}
		}
	}

	protected boolean isCreateGlobalClass(CompounddefType compounddefType) {
		if (!(compounddefType.getKind() == DoxCompoundKind.FILE || compounddefType.getKind() == DoxCompoundKind.NAMESPACE)) {
			return false;
		}
		List<SectiondefType> sectiondefTypes = compounddefType.getSectiondef();
		if (compounddefType.getSectiondef() == null || compounddefType.getSectiondef().isEmpty()) {
			return false;
		}
		for (SectiondefType sectiondefType : sectiondefTypes) {
			if (!isCreateGlobalSectiondefType(sectiondefType)) {
				continue;
			}
			List<MemberdefType> memberdefTypes = sectiondefType.getMemberdef();
			for (MemberdefType memberdefType : memberdefTypes) {
				if (!isCreateGlobalMemberdefType(memberdefType)) {
					continue;
				}
				return true;
			}
		}
		return false;
	}

	protected boolean isCreateGlobalSectiondefType(SectiondefType sectiondefType) {
		return sectiondefType.getKind() == DoxSectionKind.FUNC || sectiondefType.getKind() == DoxSectionKind.VAR;
	}

	protected boolean isCreateGlobalMemberdefType(MemberdefType memberdefType) {
		return memberdefType.getKind() == DoxMemberKind.FUNCTION || memberdefType.getKind() == DoxMemberKind.VARIABLE;
	}

	private void setLanguage(String stereotype, IElement el) throws InvalidEditingException {
		String[] stereotypes = el.getStereotypes();
		for (String st : stereotypes) {
			if (stereotype.equals(st)) {
				return;
			}
		}
		el.addStereotype(stereotype);
	}

	private IClass findClass(Type type) throws ProjectNotFoundException, InvalidEditingException {
		if (type.getNamespaceClass() == null || isEmpty(type.getNamespaceClass().clazz)) {
			return null;
		}
		IClass findClass = this.astahModelUtil.getModelWithPath(IClass.class, project, type.getNamespaceClass().getFullName());
		if (findClass == null) {
			INamedElement[] findEls = this.projectAccessor.findElements(IClass.class, type.getNamespaceClass().clazz);
			for (INamedElement findEl : findEls) {
				if (findEl.getFullName("::").equals(type.getNamespaceClass().getFullName())) {
					findClass = (IClass) findEl;
					break;
				}
			}
		}
		if (findClass == null) {
			findClass = (IClass) this.createClass(this.typeUtil.getCompounddefByLoadXml(type.getRefId()));
		}
		return findClass;
	}

	private IPackage createPackage(Type type) throws InvalidEditingException {
		if (type.getNamespaceClass() == null || isEmpty(type.getNamespaceClass().namespace)) {
			return this.project;
		}
		String[] namespaces = type.getNamespaceClass().namespace.split("::");
		IPackage parentModel = this.project;
		for (String ns : namespaces) {
			IPackage pkg;
			if ((pkg = this.getNamespace(parentModel, ns)) == null) {
				parentModel = this.basicModelEditor.createPackage(parentModel, ns);
				LOG.trace(format("create model : %s", parentModel.getFullName("::")));
			} else {
				LOG.debug(String.format("%s is exits.", pkg.getFullName("::")));
				parentModel = pkg;
			}
		}
		return parentModel;
	}

	private void createTaggedValue(IElement el, String key, String value) throws InvalidEditingException {
		ITaggedValue taggedValue = findTaggedValue(el, key);
		if (taggedValue == null) {
			this.basicModelEditor.createTaggedValue(el, key, value);
		} else {
			taggedValue.setValue(value);
		}
	}

	private ITaggedValue findTaggedValue(IElement el, String key) {
		ITaggedValue[] taggedValues = el.getTaggedValues();
		for (ITaggedValue taggedValue : taggedValues) {
			if (taggedValue.getKey().equals(key)) {
				return taggedValue;
			}
		}
		return null;
	}

	private IModel initProject() {
		try {
			if (this.project == null) {
				this.project = projectAccessor.getProject();
			}
		} catch (ProjectNotFoundException e) {
			throw new RuntimeException(e);
		}
		return this.project;
	}

	@Inject
	public void setAstahModelUtil(AstahModelUtil astahModelUtil) {
		this.astahModelUtil = astahModelUtil;
	}

	@Inject
	public void setBasicModelEditor(BasicModelEditor basicModelEditor) {
		this.basicModelEditor = basicModelEditor;
	}

	@Inject
	public void setProjectAccessor(ProjectAccessor projectAccessor) {
		this.projectAccessor = projectAccessor;
	}

	@Inject
	public void setTypeUtil(TypeUtil typeUtil) {
		this.typeUtil = typeUtil;
	}
}

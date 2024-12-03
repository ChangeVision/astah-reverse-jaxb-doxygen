package com.change_vision.astah.extension.plugin.reverser;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.util.List;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.Unmarshaller;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;

import org.junit.Before;
import org.junit.Test;

import com.change_vision.astah.extension.plugin.common.AstahModelUtil;
import com.change_vision.astah.extension.plugin.doxygen._1_8_4.compound.DoxygenType;
import com.change_vision.astah.extension.plugin.doxygen._1_8_4.compound.MemberdefType;

public class TypeUtilTest {
	private List<MemberdefType> protectedAttri;
	private List<MemberdefType> staticProtectedAttri;
	private TypeUtil util;

	@Before
	public void before() throws Exception {
		XMLStreamReader r = null;
		try {
			XMLInputFactory factory = XMLInputFactory.newInstance();
			r = factory.createXMLStreamReader(getClass().getClassLoader().getResourceAsStream("sample_cpp/xml/classcv_1_1astah_1_1_class3.xml"));
			JAXBContext context = JAXBContext.newInstance("com.change_vision.astah.extension.plugin.doxygen._1_8_4.compound");
			Unmarshaller unmarshaller = context.createUnmarshaller();
			JAXBElement<DoxygenType> element = unmarshaller.unmarshal(r, DoxygenType.class);
			DoxygenType doxygenType = element.getValue();
			protectedAttri = doxygenType.getCompounddef().get(0).getSectiondef().get(0).getMemberdef();
			staticProtectedAttri = doxygenType.getCompounddef().get(0).getSectiondef().get(1).getMemberdef();

		} finally {
			if (r != null) {
				r.close();
			}
		}
		util = new TypeUtil();
		util.setXmlDir(new File(getClass().getClassLoader().getResource("sample_cpp/xml").getFile()));
		util.setAstahModelUtil(new AstahModelUtil());
	}

	@Test
	public void convertParamType_文字列へ変換() {
		assertThat(util.toRawtypeByLinkedTextType(protectedAttri.get(0).getType()).rawtype,
				is("std::vector< cv::astah::CvStack < cv::astah::Hogehoge , std::string > > **"));
		assertThat(util.toRawtypeByLinkedTextType(protectedAttri.get(1).getType()).rawtype, is("const char *"));
		assertThat(util.toRawtypeByLinkedTextType(protectedAttri.get(2).getType()).rawtype, is("cv::astah::Hogehoge"));
	}

	@Test
	public void convertParamType_パースする() {
		{
			Type type = util.parseType("std::vector<CvStack<Hogehoge,std::string > > **");
			assertThat(type.getNamespaceClass().namespace, is("std"));
			assertThat(type.getNamespaceClass().clazz, is("vector"));
			assertThat(type.getTemplates(), is("CvStack<Hogehoge,std::string >"));
			assertThat(type.isConst(), is(false));
			assertThat(type.getTypeModifier(), is("**"));
		}
		{
			Type type = util.parseType("const char *");
			assertThat(type.getNamespaceClass().namespace, is(""));
			assertThat(type.getNamespaceClass().clazz, is("char"));
			assertThat(type.getTemplates(), is(""));
			assertThat(type.isConst(), is(true));
			assertThat(type.getTypeModifier(), is("*"));
		}
		{
			Type type = util.parseType("Hogehoge");
			assertThat(type.getNamespaceClass().namespace, is(""));
			assertThat(type.getNamespaceClass().clazz, is("Hogehoge"));
			assertThat(type.getTemplates(), is(""));
			assertThat(type.isConst(), is(false));
			assertThat(type.getTypeModifier(), is(""));
		}
	}

	@Test
	public void convertParamType_Typeを作成する() {
		assertThat(protectedAttri.size(), is(3));
		{
			Type type = util.createType(protectedAttri.get(0));
			assertThat(type.getNamespaceClass().namespace, is("std"));
			assertThat(type.getNamespaceClass().clazz, is("vector"));
			assertThat(type.getTemplates(), is("cv::astah::CvStack < cv::astah::Hogehoge , std::string >"));
			assertThat(type.isConst(), is(false));
			assertThat(type.getTypeModifier(), is("**"));
			assertThat(type.getVisiblity(), is("protected"));
			assertThat(type.getMultiplicity(), is(""));
			assertThat(type.isStatic(), is(false));
		}
		{
			Type type = util.createType(protectedAttri.get(1));
			assertThat(type.getNamespaceClass().namespace, is(""));
			assertThat(type.getNamespaceClass().clazz, is("char"));
			assertThat(type.getTemplates(), is(""));
			assertThat(type.isConst(), is(true));
			assertThat(type.getTypeModifier(), is("*"));
			assertThat(type.getVisiblity(), is("protected"));
			assertThat(type.getMultiplicity(), is(""));
			assertThat(type.isStatic(), is(false));
		}
		{
			Type type = util.createType(protectedAttri.get(2));
			assertThat(type.getNamespaceClass().namespace, is("cv::astah"));
			assertThat(type.getNamespaceClass().clazz, is("Hogehoge"));
			assertThat(type.getTemplates(), is(""));
			assertThat(type.isConst(), is(false));
			assertThat(type.getTypeModifier(), is(""));
			assertThat(type.getVisiblity(), is("protected"));
			assertThat(type.getMultiplicity(), is("10"));
			assertThat(type.isStatic(), is(false));
		}
		assertThat(staticProtectedAttri.size(), is(2));
		{
			Type type = util.createType(staticProtectedAttri.get(0));
			assertThat(type.getNamespaceClass().namespace, is(""));
			assertThat(type.getNamespaceClass().clazz, is("unsigned long"));
			assertThat(type.getTemplates(), is(""));
			assertThat(type.isConst(), is(false));
			assertThat(type.getTypeModifier(), is(""));
			assertThat(type.getVisiblity(), is("protected"));
			assertThat(type.getMultiplicity(), is(""));
			assertThat(type.isStatic(), is(true));
		}
		{
			Type type = util.createType(staticProtectedAttri.get(1));
			assertThat(type.getNamespaceClass().namespace, is(""));
			assertThat(type.getNamespaceClass().clazz, is("long"));
			assertThat(type.getTemplates(), is(""));
			assertThat(type.isConst(), is(true));
			assertThat(type.getTypeModifier(), is("*"));
			assertThat(type.getVisiblity(), is("protected"));
			assertThat(type.getMultiplicity(), is(""));
			assertThat(type.isStatic(), is(true));
		}
	}
}

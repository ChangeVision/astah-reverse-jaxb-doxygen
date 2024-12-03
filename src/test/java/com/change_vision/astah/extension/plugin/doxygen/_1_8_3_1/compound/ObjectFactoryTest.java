package com.change_vision.astah.extension.plugin.doxygen._1_8_3_1.compound;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import java.util.List;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Node;

public class ObjectFactoryTest {
	private JAXBElement<DoxygenType> jaxbRootElement;

	@Before
	public void before() {
		try {
			JAXBContext context = JAXBContext.newInstance("com.change_vision.astah.extension.plugin.doxygen._1_8_3_1.compound");
			Unmarshaller unmarshaller = context.createUnmarshaller();
			XMLInputFactory factory = XMLInputFactory.newInstance();
			XMLStreamReader r = factory.createXMLStreamReader(getClass().getClassLoader().getResourceAsStream("_1_8_3_1/class_class0.xml"));
			jaxbRootElement = unmarshaller.unmarshal(r, DoxygenType.class);
		} catch (JAXBException e) {
			e.printStackTrace();
			fail(e.getMessage());
		} catch (XMLStreamException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	@After
	public void after() {
	}

	@Test
	public void class_class0_xmlよりクラスの情報が取得できること() throws Exception {
		System.out.println("ObjectFactoryTest.class_class0_xmlよりクラスの情報が取得できること()");
		assertThat(jaxbRootElement.getName().toString(), is("doxygen"));
		DoxygenType doxygenType = jaxbRootElement.getValue();
		assertThat(doxygenType.getVersion(), is("1.8.3.1"));

		List<CompounddefType> compounddefTypes = doxygenType.getCompounddef();
		assertThat(compounddefTypes.size(), is(1));
		CompounddefType compounddefType = compounddefTypes.get(0);
		assertThat(compounddefType.getCompoundname(), is("Class0"));
		assertThat(compounddefType.getKind(), is(DoxCompoundKind.CLASS));
		assertThat(compounddefType.getAbstract(), is(nullValue()));
		assertThat(compounddefType.getFinal(), is(nullValue()));
		assertThat(compounddefType.getProt(), is(DoxProtectionKind.PUBLIC));
		assertThat(compounddefType.getSealed(), is(nullValue()));
	}

	@Test
	public void class_class0_xmlよりpublic属性の情報が取得できること() throws Exception {
		System.out.println("ObjectFactoryTest.class_class0_xmlよりpublic属性の情報が取得できること()");
		DoxygenType doxygenType = jaxbRootElement.getValue();

		List<CompounddefType> compounddefTypes = doxygenType.getCompounddef();
		CompounddefType compounddefType = compounddefTypes.get(0);

		List<SectiondefType> sectiondefTypes = compounddefType.getSectiondef();
		assertThat(sectiondefTypes.size(), is(6));
		// PUBLIC_ATTRIB
		SectiondefType sectiondefType = sectiondefTypes.get(0);
		assertThat(sectiondefType.getKind(), is(DoxSectionKind.PUBLIC_ATTRIB));

		List<MemberdefType> memberdefTypes = sectiondefType.getMemberdef();
		assertThat(memberdefTypes.size(), is(2));
		MemberdefType memberdefType = null;
		{
			memberdefType = memberdefTypes.get(0);
			assertThat(memberdefType.getKind(), is(DoxMemberKind.VARIABLE));
			assertThat(memberdefType.getProt(), is(DoxProtectionKind.PUBLIC));
			assertThat(memberdefType.getStatic(), is(DoxBool.NO));
			assertThat(memberdefType.getMutable(), is(DoxBool.YES));
			assertThat(memberdefType.getType().getContent().get(0).toString(), is("int"));
			assertThat(((Node) memberdefType.getName()).getTextContent(), is("_counter"));
		}
	}

	@Test
	public void class_class0_xmlよりprotected属性の情報が取得できること() throws Exception {
		System.out.println("ObjectFactoryTest.class_class0_xmlよりprotected属性の情報が取得できること()");
		DoxygenType doxygenType = jaxbRootElement.getValue();

		List<CompounddefType> compounddefTypes = doxygenType.getCompounddef();
		CompounddefType compounddefType = compounddefTypes.get(0);

		List<SectiondefType> sectiondefTypes = compounddefType.getSectiondef();
		assertThat(sectiondefTypes.size(), is(6));
		// PROTECTED_ATTRIB
		SectiondefType sectiondefType = sectiondefTypes.get(1);
		assertThat(sectiondefType.getKind(), is(DoxSectionKind.PROTECTED_ATTRIB));

		List<MemberdefType> memberdefTypes = sectiondefType.getMemberdef();
		assertThat(memberdefTypes.size(), is(4));
		MemberdefType memberdefType = null;
		{
			memberdefType = memberdefTypes.get(0);
			assertThat(memberdefType.getKind(), is(DoxMemberKind.VARIABLE));
			assertThat(memberdefType.getProt(), is(DoxProtectionKind.PROTECTED));
			assertThat(memberdefType.getStatic(), is(DoxBool.NO));
			assertThat(memberdefType.getMutable(), is(DoxBool.NO));
			assertThat(memberdefType.getType().getContent().get(0).toString(), is("std::vector< int >"));
			assertThat(((Node) memberdefType.getName()).getTextContent(), is("list"));
		}
		{
			memberdefType = memberdefTypes.get(1);
			assertThat(memberdefType.getKind(), is(DoxMemberKind.VARIABLE));
			assertThat(memberdefType.getProt(), is(DoxProtectionKind.PROTECTED));
			assertThat(memberdefType.getStatic(), is(DoxBool.NO));
			assertThat(memberdefType.getMutable(), is(DoxBool.NO));
			assertThat(memberdefType.getType().getContent().get(0).toString(), is("const char *"));
			assertThat(((Node) memberdefType.getName()).getTextContent(), is("name"));
		}
		{
			memberdefType = memberdefTypes.get(2);
			assertThat(memberdefType.getKind(), is(DoxMemberKind.VARIABLE));
			assertThat(memberdefType.getProt(), is(DoxProtectionKind.PROTECTED));
			assertThat(memberdefType.getStatic(), is(DoxBool.NO));
			assertThat(memberdefType.getMutable(), is(DoxBool.NO));
			assertThat(memberdefType.getType().getContent().get(0).toString(), is("int"));
			assertThat(((Node) memberdefType.getName()).getTextContent(), is("summary"));
			Node node = (Node) memberdefType.getArgsstring();
			assertThat(node.getTextContent(), is("[5]"));
		}
	}
}

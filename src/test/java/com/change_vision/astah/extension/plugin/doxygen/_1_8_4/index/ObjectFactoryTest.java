package com.change_vision.astah.extension.plugin.doxygen._1_8_4.index;

import static org.hamcrest.CoreMatchers.is;
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

public class ObjectFactoryTest {
	private JAXBElement<DoxygenType> jaxbRootElement;

	@Before
	public void before() {
		try {
			JAXBContext context = JAXBContext.newInstance("com.change_vision.astah.extension.plugin.doxygen._1_8_4.index");
			Unmarshaller unmarshaller = context.createUnmarshaller();
			XMLInputFactory factory = XMLInputFactory.newInstance();
			XMLStreamReader r = factory.createXMLStreamReader(getClass().getClassLoader().getResourceAsStream("_1_8_4/index.xml"));
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
	public void index_xmlより対象のファイルが取得できること() throws Exception {
		System.out.println("ObjectFactoryTest.index_xmlより対象のファイルが取得できること()");
		assertThat(jaxbRootElement.getName().toString(), is("doxygenindex"));
		DoxygenType doxygenType = jaxbRootElement.getValue();
		assertThat(doxygenType.getVersion(), is("1.8.4"));

		List<CompoundType> compoundTypes = doxygenType.getCompound();
		assertThat(compoundTypes.get(0).getRefid(), is("class_class0"));
		assertThat(compoundTypes.get(1).getRefid(), is("class_class1"));
		assertThat(compoundTypes.get(2).getRefid(), is("classcv_1_1astah_1_1_class3"));
		assertThat(compoundTypes.get(3).getRefid(), is("classcv_1_1astah_1_1_cv_stack"));
	}
}

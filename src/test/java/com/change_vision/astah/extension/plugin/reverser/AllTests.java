package com.change_vision.astah.extension.plugin.reverser;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ DoxygenXmlParserTest_asole.class, DoxygenXmlParserTest_cppunit_1_12_0.class, DoxygenXmlParserTest_gtest_1_6_0.class,
		DoxygenXmlParserTest_mozilla_release.class, DoxygenXmlParserTest_poco_Foundation.class, DoxygenXmlParserTest_poco_Foundation_ans.class,
		/*DoxygenXmlParserTest_sample_2.class,*/ DoxygenXmlParserTest_sample_cpp.class, TypeUtilTest.class })
public class AllTests {

}

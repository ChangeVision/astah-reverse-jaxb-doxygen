package com.change_vision.astah.extension.plugin.reverser;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class LanguageManagerTest {

	private Set<String> sut;

	@Before
	public void before() throws Exception {
		sut = LanguageManager.PRIMITIVE_TYPE;
	}
	
	@Test
	public void loadPrimitiveFile() {
		assertThat(sut.contains("int"),is(true));
		assertThat(sut.contains("NSString"),is(true));
	}

}

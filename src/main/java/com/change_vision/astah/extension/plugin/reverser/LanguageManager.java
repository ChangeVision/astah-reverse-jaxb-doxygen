package com.change_vision.astah.extension.plugin.reverser;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LanguageManager {
	
	private static final String KEY_OF_CPLUS_LANGUAGE = "cplus_primitivite_type";
	private static final String KEY_OF_OBJECTIVE_C_LANGUAGE = "objc_primitivite_type";

	public final static Set<String> PRIMITIVE_TYPE;

	static {
		Config config;
		try {
			config = new Config(Config.CONFIG_PROPERTIES);
		} catch (IOException e) {
			throw new IllegalStateException("cannot read config file",e);
		}
		Set<String> primitiveTypes = new HashSet<String>(); 
		loadLanguagePrimitive(config, primitiveTypes, KEY_OF_CPLUS_LANGUAGE);
		loadLanguagePrimitive(config, primitiveTypes, KEY_OF_OBJECTIVE_C_LANGUAGE);
		PRIMITIVE_TYPE = Collections.unmodifiableSet(primitiveTypes);
	}

	private static void loadLanguagePrimitive(Config config, Set<String> primitiveTypes, String key) {
		String value = config.getValue(key);
		String[] split = value.split(",");
		List<String> asList = Arrays.asList(split);
		primitiveTypes.addAll(asList);
	}
}
package com.change_vision.astah.extension.plugin.reverser;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LanguageManager {
	public static final String LANGUAGE = "cplus_primitivite_type";

	public final static Set<String> PRIMITIVE_TYPE = new HashSet<String>();

	static {
		try {
			PRIMITIVE_TYPE.addAll(Arrays.asList(new Config(Config.CONFIG_PROPERTIES).getValue(LANGUAGE).split(",")));
		} catch (IOException e) {
		}
	}
}
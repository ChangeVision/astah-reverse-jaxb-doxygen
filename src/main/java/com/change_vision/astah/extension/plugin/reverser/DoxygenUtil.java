package com.change_vision.astah.extension.plugin.reverser;

import com.change_vision.astah.extension.plugin.doxygen._1_8_4.compound.DoxBool;

public final class DoxygenUtil {
	private DoxygenUtil() {
	}

	public static boolean bool(DoxBool yesno) {
		if (null == yesno) {
			return false;
		}
		return yesno == DoxBool.YES;
	}
}

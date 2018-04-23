/**
 * 
 */
package com.company.utils;

import java.io.File;

 
public class Constant {
	private static final String ROOT = System.getProperty("user.dir");

	public static File getMinicap() {
		return new File(ROOT, "minicap");
	}

	public static File getMinicapBin() {
		return new File(ROOT, "minicap/bin");
	}

	public static File getMiniTouchBin() {
		return new File(ROOT, "minitouch");
	}

	public static File getMinicapSo() {
		return new File(ROOT, "minicap/shared");
	}
	
	public static File getMinicapAdb() {
		return new File(ROOT, "platform-tools");
	}

}

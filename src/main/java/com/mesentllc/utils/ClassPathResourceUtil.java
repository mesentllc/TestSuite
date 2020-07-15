package com.mesentllc.utils;

import com.google.common.io.Resources;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;

public class ClassPathResourceUtil {
	public static String getString(String resourcePath) {
		try {
			URL url = Resources.getResource(resourcePath);
			return Resources.toString(url, Charset.defaultCharset());
		}
		catch (IOException ioe) {
			throw new IllegalStateException(String.format("Could not read resource {%s}", resourcePath), ioe);
		}
	}
}

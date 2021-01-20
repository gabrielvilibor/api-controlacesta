package com.example.services.util;

import org.apache.commons.codec.digest.DigestUtils;

public class Hash {
	
	public static String getSecurityHash(String text) {
		String hash = DigestUtils.sha256Hex(text);
		return hash;
	}

}

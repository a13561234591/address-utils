package com.payegis.common;

import com.google.common.hash.Hasher;
import com.google.common.hash.Hashing;
import com.payegis.constant.SystemConstant;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;

public class EncryptUtil {

	private EncryptUtil() {

	}

	private static final Charset charset = Charset.forName("utf-8");

	public static String encryptMD5Password(String plainPassword) {
		Hasher hasher = Hashing.md5().newHasher();
		hasher.putString(plainPassword, charset);
		byte[] finalData = hasher.hash().asBytes();
		return HexUtil.bytesToHex(finalData);
	}

	public static String encryptSHAPassword(String plainPassword)
			throws UnsupportedEncodingException, GeneralSecurityException {
		byte[] finalData = null;
		byte[] data = plainPassword.getBytes(SystemConstant.CHARSET_UTF8);
		MessageDigest sha = MessageDigest.getInstance("SHA");
		finalData = sha.digest(data);
		return HexUtil.bytesToHex(finalData);
	}
}

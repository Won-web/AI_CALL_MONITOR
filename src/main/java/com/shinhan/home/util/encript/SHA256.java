package com.shinhan.home.util.encript;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SHA256 {

	private static Logger logger = LoggerFactory.getLogger(SHA256.class);

	public static String getSalt() {
		java.util.Random random = new java.util.Random();
		byte[] saltBytes = new byte[8];
		random.nextBytes(saltBytes);

		StringBuilder salt = new StringBuilder();
		for (byte b : saltBytes) {
			salt.append(String.format("%02x", b));
		}
		return salt.toString();
	}

	public static String encrypt(String SrcText, String salt) {
		String returnStr = "";
		MessageDigest msgDigest;
		try {
			msgDigest = MessageDigest.getInstance("SHA-256");
			msgDigest.reset();
			msgDigest.update(salt.getBytes());
			byte[] digest = msgDigest.digest(SrcText.getBytes());
			returnStr = bytesToHex(digest);
		} catch (NoSuchAlgorithmException e) {
			logger.error("[SHA256]에서 익셉션 발생 - " + e.getMessage());
		}
		return returnStr;
	}

	public static String encrypt(String SrcText) {
		String returnStr = "";
		MessageDigest msgDigest;
		try {
			msgDigest = MessageDigest.getInstance("SHA-256");
			msgDigest.reset();
			byte[] digest = msgDigest.digest(SrcText.getBytes());
			returnStr = bytesToHex(digest);
		} catch (NoSuchAlgorithmException e) {
			logger.error("[SHA256]에서 익셉션 발생 - " + e.getMessage());
		}
		return returnStr;
	}

	// Apache Hex 대신 사용하는 메서드
	private static String bytesToHex(byte[] bytes) {
		StringBuilder hexString = new StringBuilder(2 * bytes.length);
		for (byte b : bytes) {
			String hex = String.format("%02x", b);
			hexString.append(hex);
		}
		return hexString.toString();
	}
}

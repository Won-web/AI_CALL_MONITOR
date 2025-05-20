package com.shinhan.home.util.encript;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/**
 * @분류 : 암호화
 * @클래스명 : CipherUtil
 * @클래스설명 : RSA 암복호화 
 */
public class CipherUtil {
	
	/**===========================================
	 * @분류 : 암호화
	 * @메소드명 : genRSAKeyPair
	 * @테스트일자 : 2020. 2. 21.
	 * @개발자 : 이강민
	 * @리턴 : KeyPair(공개키, 개인키 묶음)
	 * @메소드설명 : 공개키, 개인키 를 생성(RSA-2048) 
	 * ===========================================*/
	public static KeyPair genRSAKeyPair() throws NoSuchAlgorithmException {
		SecureRandom random= SecureRandom.getInstance("SHA1PRNG");
		KeyPairGenerator gen;
		gen = KeyPairGenerator.getInstance("RSA");
		gen.initialize(2048, random);
		KeyPair keyPair = gen.genKeyPair();
		return keyPair;
	}
	
	/**===========================================
	 * @분류 : 암호화
	 * @메소드명 : encryptRSA
	 * @테스트일자 : 2020. 2. 21.
	 * @개발자 : 이강민
	 * @리턴 : 암호화된 문자열
	 * @메소드설명 : 공개키를 이용한 암호화 메소드
	 * ===========================================*/
	public static String encryptRSA(String plainText, PublicKey publicKey) throws NoSuchPaddingException,
			NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
		Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWithSHA-1AndMGF1Padding");

		cipher.init(Cipher.ENCRYPT_MODE, publicKey);
		byte[] bytePlain = cipher.doFinal(plainText.getBytes());
		String encrypted = Base64.getEncoder().encodeToString(bytePlain);
		return encrypted;
	}
	
	/**===========================================
	 * @분류 : 암호화
	 * @메소드명 : encryptRSAPrivateKey
	 * @테스트일자 : 2020. 2. 21.
	 * @개발자 : 이강민
	 * @리턴 : 암호화된 문자열
	 * @메소드설명 : 개인키를 이용한 암호화 메소드(사용안할 예정)
	 *           안정성이 떨어짐
	 * ===========================================*/
	public static String encryptRSAPrivateKey(String plainText, PrivateKey privateKey) throws NoSuchPaddingException,
			NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
		Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWithSHA-1AndMGF1Padding");
		cipher.init(Cipher.ENCRYPT_MODE, privateKey);
		byte[] bytePlain = cipher.doFinal(plainText.getBytes());
		String encrypted = Base64.getEncoder().encodeToString(bytePlain);
		return encrypted;
	}
	
	/**===========================================
	 * @분류 : 암호화
	 * @메소드명 : decryptRSA
	 * @테스트일자 : 2020. 2. 21.
	 * @개발자 : 이강민
	 * @리턴 : 개인키로 복호화된 평문
	 * @메소드설명 : 개인키를 이용하여 암호화된 문자열 복호화 메소드
	 * ===========================================*/
	public static String decryptRSA(String encrypted, PrivateKey privateKey)
			throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException,
			IllegalBlockSizeException, UnsupportedEncodingException {
		byte[] byteEncrypted = Base64.getDecoder().decode(encrypted);
		Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWithSHA-1AndMGF1Padding");
		cipher.init(Cipher.DECRYPT_MODE, privateKey);
		byte[] bytePlain = cipher.doFinal(byteEncrypted);
		String decrypted = new String(bytePlain, "utf-8");
		return decrypted;
	}
	
	/**===========================================
	 * @분류 : 암호화
	 * @메소드명 : decryptRSAPublicKey
	 * @테스트일자 : 2020. 2. 21.
	 * @개발자 : 이강민
	 * @리턴 : 공개키로 복호화된 평문
	 * @메소드설명 : 공개키를 이용하여 암호화된 문자열 복호화 메소드(사용안할 예정)
	 *           안정성 떨어짐
	 * ===========================================*/
	public static String decryptRSAPublicKey(String encrypted, PublicKey publicKey)
			throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException,
			IllegalBlockSizeException, UnsupportedEncodingException {
		Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWithSHA-1AndMGF1Padding");
		byte[] byteEncrypted = Base64.getDecoder().decode(encrypted.getBytes());
		cipher.init(Cipher.DECRYPT_MODE, publicKey);
		byte[] bytePlain = cipher.doFinal(byteEncrypted);
		String decrypted = new String(bytePlain, "utf-8");
		return decrypted;
	}
	
	/**===========================================
	 * @분류 : 암호화
	 * @메소드명 : strToPublicKey
	 * @테스트일자 : 2020. 2. 21.
	 * @개발자 : 이강민
	 * @리턴 : PublicKey 객체
	 * @메소드설명 : 문자열로 된 공개키를 PublicKey 객체로 변환(Cast)
	 * ===========================================*/
	public static PublicKey strToPublicKey(String base64PublicKey)
			throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException,
			IllegalBlockSizeException, UnsupportedEncodingException, InvalidKeySpecException {
		KeyFactory keyFactory = KeyFactory.getInstance("RSA");
		byte[] bytePublicKey = Base64.getDecoder().decode(base64PublicKey.getBytes());
		X509EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(bytePublicKey);
		PublicKey publicKey = keyFactory.generatePublic(publicKeySpec);
		return publicKey;
	}
	
	/**===========================================
	 * @분류 : 암호화
	 * @메소드명 : strToPrivateKey
	 * @테스트일자 : 2020. 2. 21.
	 * @개발자 : 이강민
	 * @리턴 : PrivateKey 객체
	 * @메소드설명 : 문자열로 된 개인키를 PrivateKey 객체로 변환(Cast)
	 * ===========================================*/
	public static PrivateKey strToPrivateKey(String base64PrivateKey) 
			throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException,
			IllegalBlockSizeException, UnsupportedEncodingException, InvalidKeySpecException {
		KeyFactory keyFactory = KeyFactory.getInstance("RSA/ECB/OAEPWithSHA-1AndMGF1Padding");
		byte[] bytePrivateKey = Base64.getDecoder().decode(base64PrivateKey.getBytes());
		PKCS8EncodedKeySpec privateKeySpec = new PKCS8EncodedKeySpec(bytePrivateKey);
		PrivateKey privateKey = keyFactory.generatePrivate(privateKeySpec);
		return privateKey;
	}
	
	/**===========================================
	 * @분류 : 암호화
	 * @메소드명 : publicKeyToStr
	 * @테스트일자 : 2020. 2. 21.
	 * @개발자 : 이강민
	 * @리턴 : 문자열 키
	 * @메소드설명 : PublicKey 객체를 문자열 키값으로 변환
	 * ===========================================*/
	public static String publicKeyToStr(PublicKey publicKey) 
			throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException,
			IllegalBlockSizeException, UnsupportedEncodingException, InvalidKeySpecException {
		byte[] bytePublicKey = publicKey.getEncoded();
		String base64PublicKey = Base64.getEncoder().encodeToString(bytePublicKey);
		return base64PublicKey;
	}
	
	/**===========================================
	 * @분류 : 암호화
	 * @메소드명 : privateKeyToStr
	 * @테스트일자 : 2020. 2. 21.
	 * @개발자 : 이강민
	 * @리턴 : 문자열 키
	 * @메소드설명 : PrivateKey 객체를 문자열 키값으로 변환
	 * ===========================================*/
	public static String privateKeyToStr(PrivateKey privateKey) 
			throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException,
			IllegalBlockSizeException, UnsupportedEncodingException, InvalidKeySpecException {
		byte[] bytePrivateKey = privateKey.getEncoded();
		String base64PrivateKey = Base64.getEncoder().encodeToString(bytePrivateKey);
		return base64PrivateKey;
	}
}

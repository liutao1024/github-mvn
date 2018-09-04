package cn.spring.mvn.comm.tools;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Tool2 {
	/**
	 * @author LiuTao @date 2018年5月13日 下午8:51:04 
	 * @Title: Md5 
	 * @Description: TODO(Describe) 
	 * @param plainText
	 */
	public static void Md5(String plainText) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(plainText.getBytes());
			byte b[] = md.digest();
			int i;
			StringBuffer buf = new StringBuffer("");
			for (int offset = 0; offset < b.length; offset++) {
				i = b[offset];
				if (i < 0){
					i += 256;
				}
				if (i < 16){
					buf.append("0");
				}
				buf.append(Integer.toHexString(i));
			}
			System.out.println("result: " + buf.toString());// 32位的加密
			System.out.println("result: " + buf.toString().substring(8, 24));// 16位的加密
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @author LiuTao @date 2018年5月13日 下午8:52:03 
	 * @Title: MD5 
	 * @Description: TODO(MD5加码-32位) 
	 * @param inStr
	 * @return
	 */
	public static String MD5(String inStr) {
		MessageDigest md5 = null;
		try {
			md5 = MessageDigest.getInstance("MD5");
		} catch (Exception e) {
			System.out.println(e.toString());
			e.printStackTrace();
			return "";
		}
		char[] charArray = inStr.toCharArray();
		byte[] byteArray = new byte[charArray.length];
		for (int i = 0; i < charArray.length; i++){
			byteArray[i] = (byte) charArray[i];
		}
		byte[] md5Bytes = md5.digest(byteArray);
		StringBuffer hexValue = new StringBuffer();
		for (int i = 0; i < md5Bytes.length; i++) {
			int val = ((int) md5Bytes[i]) & 0xff;
			if (val < 16){
				hexValue.append("0");
			}
			hexValue.append(Integer.toHexString(val));
		}
		return hexValue.toString();
	}

	/**
	 * @author LiuTao @date 2018年5月13日 下午8:53:02 
	 * @Title: KL 
	 * @Description: TODO(可逆的加密算法) 
	 * @param inStr
	 * @return
	 */
	public static String KL(String inStr) {
		// String s = new String(inStr);
		char[] a = inStr.toCharArray();
		for (int i = 0; i < a.length; i++) {
			a[i] = (char) (a[i] ^ 't');
		}
		String s = new String(a);
		return s;
	}

	/**
	 * @author LiuTao @date 2018年5月13日 下午8:53:20 
	 * @Title: JM 
	 * @Description: TODO(加密后解密) 
	 * @param inStr
	 * @return
	 */
	public static String JM(String inStr) {
		char[] a = inStr.toCharArray();
		for (int i = 0; i < a.length; i++) {
			a[i] = (char) (a[i] ^ 't');
		}
		String k = new String(a);
		return k;
	}
	/**
	 * @author LiuTao @date 2018年5月13日 下午8:53:39 
	 * @Title: main 
	 * @Description: TODO(Describe) 
	 * @param args
	 */
	public static void main(String[] args) {
		Md5("123456");
		System.out.println();
		String s = new String("123456");
		
		
		System.out.println("原始：" + s);
		System.out.println(KL(s));
		System.out.println(JM(KL(s)));
//		System.out.println("MD5后：" + MD5(s));
//		System.out.println("MD5后再加密：" + KL(MD5(s)));
//		System.out.println("解密为MD5后的：" + JM(KL(MD5(s))));
//		System.out.println("解密为MD5后的：" + JM(MD5(s)));
		
	}

}

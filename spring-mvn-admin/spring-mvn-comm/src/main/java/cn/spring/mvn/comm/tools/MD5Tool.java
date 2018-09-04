package cn.spring.mvn.comm.tools;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author LiuTao @date 2018年5月13日 下午8:45:58
 * @ClassName: MD5Tools 
 * @Description: TODO(MD5加密的不可逆性,没有解密方法)
 */
public class MD5Tool {
	/**
	 * @author LiuTao @date 2018年5月13日 下午8:39:43 
	 * @Title: md5EncryptFile 
	 * @Description: TODO(MD5加密文件) 
	 * @param file
	 * @return
	 */
	public static String md5EncryptFile(String file) {
		try {
			MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
//			 localMessageDigest.update(IOHelper.toBytes(new FileInputStream(file)));
			byte[] arrayOfByte = localMessageDigest.digest();

			StringBuffer localStringBuffer = new StringBuffer("");
			for (int j = 0; j < arrayOfByte.length; j++) {
				int i = arrayOfByte[j];
				if (i < 0)
					i += 256;
				if (i < 16)
					localStringBuffer.append("0");
				localStringBuffer.append(Integer.toHexString(i));
			}
			return localStringBuffer.toString();
		} catch (Throwable localThrowable1) {
			localThrowable1.printStackTrace();
		}
		return null;
	}
	/**
	 * @author LiuTao @date 2018年5月13日 下午8:39:59 
	 * @Title: md5EncryptString 
	 * @Description: TODO(MD5加密字符串) 
	 * @param str
	 * @return
	 */
	public static String md5EncryptString(String str) {
		try {
			MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
			localMessageDigest.update(str.getBytes());
			byte[] arrayOfByte = localMessageDigest.digest();
			StringBuffer localStringBuffer = new StringBuffer("");
			for (int j = 0; j < arrayOfByte.length; j++) {
				int i = arrayOfByte[j];
				if (i < 0)
					i += 256;
				if (i < 16)
					localStringBuffer.append("0");
				localStringBuffer.append(Integer.toHexString(i));
			}
			return localStringBuffer.toString();
		} catch (NoSuchAlgorithmException localNoSuchAlgorithmException1) {
			localNoSuchAlgorithmException1.printStackTrace();
		}
		return null;
	}
	/**
	 * @author LiuTao @date 2018年5月13日 下午8:39:29 
	 * @Title: md5EncryptArray 
	 * @Description: TODO(Describe) 
	 * @param str
	 * @return
	 */
	public static String md5EncryptArray(byte[] str) {
		try {
			MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
			localMessageDigest.update(str);
			byte[] arrayOfByte = localMessageDigest.digest();
			StringBuffer localStringBuffer = new StringBuffer("");
			for (int j = 0; j < arrayOfByte.length; j++) {
				int i = arrayOfByte[j];
				if (i < 0)
					i += 256;
				if (i < 16)
					localStringBuffer.append("0");
				localStringBuffer.append(Integer.toHexString(i));
			}
			return localStringBuffer.toString();
		} catch (NoSuchAlgorithmException localNoSuchAlgorithmException1) {
			localNoSuchAlgorithmException1.printStackTrace();
		}
		return null;
	}
}

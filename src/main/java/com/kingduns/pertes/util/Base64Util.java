package com.kingduns.pertes.util;

import java.util.Base64;

public class Base64Util {

	private static final String SALT = "huihuixu"; // 公共的盐值
	private static final int REPEAT = 3; // 加密3次

	/**
	 * 加密处理
	 * 
	 * @param str 要加密的字符串，需要与盐值整合
	 * @return 加密后的数据
	 */
	public static String encode(String str) {
		String temp = str + "{" + SALT + "}";// 盐值不对外公布
		byte[] data = temp.getBytes();// 将字符串变为字节数组
		for (int x = 0; x < REPEAT; x++) {
			data = Base64.getEncoder().encode(data);// 重复加密
		}
		return new String(data);
	}

	/**
	 * 进行解密处理
	 * 
	 * @param str 输入的密文
	 * @return 返回明文
	 */
	public static String decode(String str) {
		byte[] data = str.getBytes();
		for (int x = 0; x < REPEAT; x++) {
			data = Base64.getDecoder().decode(data);
		} // 正则表达式
		return new String(data).replaceAll("\\{\\w+\\}", "");
	}

	public static void main(String[] args) {
		String encStr = Base64Util.encode("Hello Word!");
		System.out.println(encStr);
		String decStr = Base64Util.decode(encStr);
		System.out.println(decStr);
	}
}

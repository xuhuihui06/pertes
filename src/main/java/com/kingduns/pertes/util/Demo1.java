package com.kingduns.pertes.util;

import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;

/** 
 * 采用MD5加密解密  
 */  
public class Demo1 {  
  
		
	public final static String MD5(String s) {
        char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'A', 'B', 'C', 'D', 'E', 'F' };
        try {
            byte[] btInput = s.getBytes();
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            mdInst.update(btInput);
            // 获得密文
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
		public static void main(String[] args) {
			List<String> strins = new ArrayList<String>();
			strins.add(0, "A");
			strins.add(1, "B");
			strins.add(2, "C");
			strins.add(3, "D");
			strins.add(4, "E");
			strins.add(5, "F");
			strins.add(6, "G");
			strins.add(7, "H");
			strins.add(8, "I");
			strins.add(9, "J");
			strins.add(10, "K");
			strins.add(11, "L");
			strins.add(12, "M");
			strins.add(13, "N");
			strins.add(14, "O");
			strins.add(15, "P");
			strins.add(16, "Q");
			strins.add(17, "R");
			strins.add(18, "S");
			strins.add(19, "T");
			strins.add(20, "U");
			strins.add(21, "V");
			strins.add(22, "W");
			strins.add(23, "X");
			strins.add(24, "Y");
			strins.add(25, "Z");
			String str = "TASC?O3RJMV?WDJKX?ZM";
			StringBuilder sb = new StringBuilder(str);
			for (int i = 0; i < strins.size(); i++) {
				sb = sb.replace(4, 5, strins.get(i));
				for (int j = 0; j < strins.size(); j++) {
					sb = sb.replace(11, 12, strins.get(j));
					for (int j2 = 0; j2 < strins.size(); j2++) {
						sb = sb.replace(17, 18, strins.get(j2));
						if(MD5(sb.toString()).indexOf("E903") != -1) {
							System.out.println(sb.toString() + ":" + MD5(sb.toString()));
						}
					}
				}
			}
		}


}
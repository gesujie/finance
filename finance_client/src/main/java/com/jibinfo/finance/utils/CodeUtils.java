package com.jibinfo.finance.utils;

import java.util.Random;

public class CodeUtils {
	public static String getRandomCode(int length) {
		StringBuilder sbd = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			// 随机数奇数-字母；随机数偶数-数字
			String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";
			if ("char".equalsIgnoreCase(charOrNum)) {
				sbd.append((char) (65 + random.nextInt(26)));
			} else if ("num".equalsIgnoreCase(charOrNum)) {
				sbd.append(random.nextInt(10));
			}
		}
		return sbd.toString();
	}
}

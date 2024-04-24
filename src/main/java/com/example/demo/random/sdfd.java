package com.example.demo.random;

import java.util.Arrays;

public class sdfd {

	public static void main(String[] args) {
		String str = "my name is niraj";// 65 97
		String ans = convert2(str);
		System.out.println(ans);
	}

	private static String convert(String str) {
		StringBuilder sb = new StringBuilder();
		String[] ans = str.split(" ");
		for (String current : ans) {
			char ch = current.charAt(0);
			ch = (char) (ch - 32);
			sb.append(ch + current.substring(1) + " ");
		}
		return sb.toString();
	}

	private static String convert2(String str) {
		StringBuilder sb = new StringBuilder();
		sb.append((char) (str.charAt(0) - 32));

		for (int i = 1; i < str.length()-1; i++) {
			if (str.charAt(i) == ' ') {
				sb.append(" ");
				char ch = (char) (str.charAt(i + 1) - 32);
				sb.append(ch);
			} else {
				sb.append(str.charAt(i+1));
			}
		}
		return sb.toString();
	}

}

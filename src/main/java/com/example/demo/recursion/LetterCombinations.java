package com.example.demo.recursion;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinations {

	public static void main(String[] args) {

//		generate("12", "");
//		List<String> ans = generateAdd("12", "");
		List<String> letterCombinations = letterCombinations("98");
		System.out.println(letterCombinations);
	}

	public static List<String> letterCombinations(String digits) {
		List<String> ans = new ArrayList<>();
		if(digits.isEmpty()) {
			return ans;
		}
		letterCombinations(digits, "", ans);
		return ans;
	}

	private static void letterCombinations(String up, String p, List<String> ans) {
		if (up.isEmpty()) {
			ans.add(p);
			return;
		}
		int digit = up.charAt(0) - '0';
		if (digit < 7) {
			for (int i = (digit - 2) * 3; i < (digit - 1) * 3; i++) {
				char ch = (char) ('a' + i);
				letterCombinations(up.substring(1), p + ch, ans);
			}
		} else {
			if(digit==8) {
				for (int i = ((digit - 2) * 3)+1; i < ((digit - 1) * 3) + 1; i++) {
					char ch = (char) ('a' + i);
					letterCombinations(up.substring(1), p + ch, ans);
				}
			}else if(digit==9) {
				for (int i = ((digit - 2) * 3)+1; i <= ((digit - 1) * 3) + 1; i++) {
					char ch = (char) ('a' + i);
					letterCombinations(up.substring(1), p + ch, ans);
				}
			}//22
			else {
				for (int i = ((digit - 2) * 3); i < ((digit - 1) * 3) + 1; i++) {
					char ch = (char) ('a' + i);
					letterCombinations(up.substring(1), p + ch, ans);
				}
			}
			
		}

	}

	// 1 based where 1 also contains alphabet mapping not for leetcode.
	private static void generate(String up, String p) {

		if (up.isEmpty()) {
			System.out.println(p);
			return;
		}
		int digit = up.charAt(0) - '0';

		for (int i = (digit - 1) * 3; i < (digit * 3); i++) {

			char ch = (char) ('a' + i);
			generate(up.substring(1), p + ch);
		}

	}

	private static List<String> generateAdd(String up, String p) {

		List<String> ans = new ArrayList<>();

		if (up.isEmpty()) {
			ans.add(p);
			return ans;
		}
		int digit = up.charAt(0) - '0';

		for (int i = (digit - 1) * 3; i < (digit * 3); i++) {

			char ch = (char) ('a' + i);
			ans.addAll(generateAdd(up.substring(1), p + ch));
		}
		return ans;

	}

}

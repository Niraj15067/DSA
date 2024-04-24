package com.example.demo.recursion;

import java.util.ArrayList;
import java.util.List;

public class DiceThrow {

	public static void main(String[] args) {

//		diceGenerate(4, "");
		List<String> ans = diceGenerateList(4,"");
		System.out.println(ans);

	}

	private static void diceGenerate(int target, String ans) {

		if (target == 0) {
			System.out.println(ans);
			return;
		}

		for (int i = 1; i <= 6 && i <= target; i++) {
			char ch = (char) ('0' + i);
			int newTarget = target - i;
			diceGenerate(newTarget, ans + ch);
		}
	}

	private static List<String> diceGenerateList(int target, String ans) {

		List<String> ansList = new ArrayList<>();
		
		if (target == 0) {
			ansList.add(ans);
			return ansList;
		}

		for (int i = 1; i <= 6 && i <= target; i++) {
			char ch = (char) ('0' + i);
			int newTarget = target - i;
			ansList.addAll(diceGenerateList(newTarget, ans + ch));
		}
		return ansList;
	}

}

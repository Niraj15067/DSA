package com.example.demo.string;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingChar {

	public static void main(String[] args) {
		String str = "abcdaaabcde";
		int ans = longestSubstring(str);
		System.out.println(ans);
	}

	private static int longestSubstring(String s) {

		int max = 0;
		int left = 0;
		Map<Character, Integer> map = new HashMap<>();
		for (int right = 0; right < s.length(); right++) {
			char current = s.charAt(right);
			if (map.containsKey(current)) {
				left = Math.max(left, map.get(current)+1);
			}
			map.put(current, right);
			max = Math.max(max, right - left + 1);
		}
		return max;
	}
}

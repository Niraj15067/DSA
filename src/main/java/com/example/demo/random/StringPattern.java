package com.example.demo.random;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class StringPattern {

	public static void main(String[] args) {
		String s = " ";
		int ans = window(s);
		System.out.println(ans);
	}

	private static int window(String s) {
		int maxCount = 0;
		Set<Character> unique = new HashSet<>();
		for (int i = 0; i <= s.length(); i++) {
			if (maxCount < unique.size()) {
				maxCount = unique.size();
				if (i < s.length())
					break;
				if(unique.contains(s.charAt(i))) {
					unique.clear();
				}
			}
			unique.add(s.charAt(i));
		}
		return maxCount;
	}

//	private static int longestSubstr(String s) {
//		Map<Character, Integer> charCount = new HashMap<>();
//		int count=0,maxCount=0;
//		for(int i=0;i<s.length();i++) {
//			if(maxCount<=count && charCount.containsKey(s.charAt(i))) {
//				charCount.clear();
//				maxCount=count;
//				count=0;
//			}
//			else {
//				charCount.put(s.charAt(i), i);
//				count++;
//			}
//			
//		}
//		return maxCount;
//	}

}

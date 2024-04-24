package com.example.demo.arrays;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class CountOccurenceOfAnagrams {

	public static void main(String[] args) throws IOException {
		File file = new File("C:\\Users\\Niraj\\Downloads\\fileInput.txt");
		FileReader fr = new FileReader(file);
		String txt = "";
		while (fr.ready()) {
			txt += (char) fr.read();
		}
		System.out.println(txt);
		fr.close();
		String pattern = "for";
		int search = search(pattern, "forxxorfxdofr");
		System.out.println(search);
		List<Integer> findAnagrams = findAnagrams(txt, pattern);
		System.out.println(findAnagrams);
	}

	private static int search(String pattern, String txt) {
		int start = 0, end = 0;
		int count = 0;
		int plen = pattern.length();
		int tlen = txt.length();
		int ans = 0;
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < plen; i++) {
			char ch = pattern.charAt(i);
			if (map.containsKey(ch)) {
				map.put(ch, map.get(ch) + 1);
			} else {
				map.put(ch, 1);
			}
		}
		count = map.size();
		while (end < tlen) {
			// common calculation for removing occurences of char in the window every time.
			char ch = txt.charAt(end);
			if (map.containsKey(ch)) {
				map.put(ch, map.get(ch) - 1);
				if (map.get(ch) == 0) {
					count--;
				}
			}
			//every time till we don't hit the window size just inc the end.
			if (end - start + 1 < plen) {
				end++;
			} else if (end - start + 1 == plen) { //we have hit the req window size calculate the ans.

				if (count == 0) {
					ans++;
				}
				char ch1 = txt.charAt(start);
				if(map.containsKey(ch1)) {
					map.put(ch1, map.get(ch1)+1);
					if(map.get(ch1)==1)
						count++;
				}
				start++;
				end++;
			}
		}
		return ans;
	}

	private static int search1(String pattern, String txt) {
		int plen = pattern.length();
		int tlen = txt.length();
		int count = 0;
		int ans = 0;

		Map<Character, Integer> patternMap = new HashMap<>();
		Map<Character, Integer> windowMap = new HashMap<>();

		// Build frequency map for pattern
		for (char ch : pattern.toCharArray()) {
			patternMap.put(ch, patternMap.getOrDefault(ch, 0) + 1);
		}

		int start = 0;
		int end = 0;

		// Sliding window approach
		while (end < tlen) {
			char chEnd = txt.charAt(end);
			windowMap.put(chEnd, windowMap.getOrDefault(chEnd, 0) + 1);
			end++;

			// Shrink the window until its size becomes equal to the pattern size
			while (end - start == plen) {
				// Check if the window contains an anagram of the pattern
				if (windowMap.equals(patternMap)) {
					ans++;
				}

				// Shrink the window from the left
				char chStart = txt.charAt(start);
				if (windowMap.containsKey(chStart)) {
					windowMap.put(chStart, windowMap.get(chStart) - 1);
					if (windowMap.get(chStart) == 0) {
						windowMap.remove(chStart);
					}
				}
				start++;
			}
		}
		return ans;
	}

	public static List<Integer> findAnagrams(String s, String p) {
		List<Integer> ans = new ArrayList<>();

		int k = p.length();
		HashMap<Character, Integer> map = new HashMap<>();

		for (int i = 0; i < k; i++) {
			char ch = p.charAt(i);
			if (map.containsKey(ch)) {
				map.put(ch, map.get(ch) + 1);
			} else {
				map.put(ch, 1);
			}
		}

		int count = map.size();
		int i = 0, j = 0;

		while (j < s.length()) {
			// Calculation:
			char ch = s.charAt(j);
			if (map.containsKey(ch)) {
				map.put(ch, map.get(ch) - 1);
				if (map.get(ch) == 0) {
					count--;
				}
			}

			if (j - i + 1 < k) {
				j++;
			} else if (j - i + 1 == k) {
				if (count == 0) {
					ans.add(i);
				}
				char ch1 = s.charAt(i);
				if (map.containsKey(ch1)) {
					map.put(ch1, map.get(ch1) + 1);
					if (map.get(ch1) == 1) {
						count++;
					}
				}
				i++;
				j++;
			}
		}

		return ans;
	}
}

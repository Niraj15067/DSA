package com.example.demo.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//https://leetcode.com/problems/ransom-note/submissions/1203573693/
public class RansomNote {

	public static void main(String[] args) {
		
		boolean canConstructOptimal = canConstructOptimal("abc", "aabbcc");
		System.out.println(canConstructOptimal);
	}
	//a : 97  A: 65
	public static boolean canConstructOptimal(String ransomNote, String magazine){
		int[] r = new int[26];
		Arrays.fill(r, 0);
		
		int[] m = new int[26];
		Arrays.fill(m, 0);
		
		for(int i=0;i<ransomNote.length();i++) {
			int index = ransomNote.charAt(i)-'a';
			r[index]++;
		}
		
		for(int i=0;i<magazine.length();i++) {
			int index = magazine.charAt(i)-'a';
			m[index]++;
		}
		for(int i=0;i<r.length;i++) {
			if(m[i]<r[i]) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean canConstruct(String ransomNote, String magazine) {
		List<Character> mag = new ArrayList<>();
		for (int i = 0; i < magazine.length(); i++) {
			mag.add(magazine.charAt(i));
		}

		for (int i = 0; i < ransomNote.length(); i++) {
			if (mag.contains(ransomNote.charAt(i))) {
				int idx = mag.indexOf(ransomNote.charAt(i));
				mag.remove(idx);
			} else {
				return false;
			}
		}
		return true;
	}

	public boolean canConstruct1(String ransomNote, String magazine) {
		List<Character> ransom = new ArrayList<>();
		List<Character> mag = new ArrayList<>();

		for (int i = 0; i < ransomNote.length(); i++) {
			ransom.add(ransomNote.charAt(i));
		}
		for (int i = 0; i < magazine.length(); i++) {
			mag.add(magazine.charAt(i));
		}

		Collections.sort(ransom);
		Collections.sort(mag);
		int len = Math.min(ransom.size(), mag.size());
		int rI = 0;
		int mI = 0;
		while (rI < len && mI < mag.size()) {
			if (ransom.get(rI) == mag.get(mI)) {
				rI++;
				mI++;
			} else {
				mI++;
			}
		}
		if (rI == ransom.size()) {
			return true;
		} else {
			return false;
		}
	}
}

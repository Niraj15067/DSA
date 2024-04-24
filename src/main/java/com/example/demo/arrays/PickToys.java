package com.example.demo.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//john wants to buy as many toys as he can so his mom told him to pick them in a row continuously as many of them 
//as you want but those should only be of categories k find the max number of toys john can buy
// for input : abaccab considering each char one type of toy the max toys he can buy is 4 i.e accab.
public class PickToys {

	public static void main(String[] args) {
//		int[] arr = { 20, 30, 50 };
		String str = "abcabcdede";
		int ans = pickToys(str, 3);
		System.out.println(ans);
	}

	static int pickToys(String s, int k) {
		int max = 0;
		Map<Character, Integer> map = new HashMap<>();
		int start = 0, end = 0,unique=0;
		while(end<s.length()) {
			char ch = s.charAt(end);
			map.put(ch, map.getOrDefault(ch, 0)+1);
			if(map.get(ch)==1) {
				unique++;
			}
			while(unique>k) {
				char i = s.charAt(start++);
				map.put(i, map.get(i)-1);
				if(map.get(i)==0) {
					map.remove(i);
					unique--;
				}
			}
			if(unique==k) {
				max = Math.max(max, end-start+1);
			}
			end++;
		}
		return max;
	}

	static int toyCount(int N, int K, int arr[]) {
		Arrays.sort(arr);
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if (K - arr[i] >= 0) {
				K -= arr[i];
				count++;
			} else {
				break;
			}
		}
		return count;
	}
}

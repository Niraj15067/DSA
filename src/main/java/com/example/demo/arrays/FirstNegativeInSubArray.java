package com.example.demo.arrays;

import java.util.ArrayList;
import java.util.List;

public class FirstNegativeInSubArray {

	public static void main(String[] args) {
		int[] arr = { 12, -1, -7, 8, -18, 30, 13, 28 };
		int k = 3;
		List<Integer> ans = find(arr, k);
		System.out.println(ans);
	}

	private static List<Integer> find(int[] arr, int k) {
		List<Integer> neg = new ArrayList<>();
		List<Integer> cur = new ArrayList<>();
		int start = 0, end = 0;
		while (end < arr.length) {
			if (end - start + 1 < k) {
				if (arr[end] < 0) {
					cur.add(arr[end++]);
				} else {
					end++;
				}
			} else if (end - start + 1 == k) {
				if (arr[end] < 0) {
					cur.add(arr[end]);
				}
				if (cur.size() == 0) {
					neg.add(0);
				} else {
					neg.add(cur.get(0));
				}
				if (!cur.isEmpty() && arr[start] == cur.get(0)) {
					cur.remove(0);
				}
				start++;
				end++;
			}
		}
//		if (cur.isEmpty()) {
//			neg.add(0);
//		} else {
//			neg.add(cur.remove(0));
//		}
		return neg;
	}
}

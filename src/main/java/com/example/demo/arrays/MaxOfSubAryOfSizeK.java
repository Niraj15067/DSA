package com.example.demo.arrays;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class MaxOfSubAryOfSizeK {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, -4, 5, 6, -3, 2, 1 };
		int k = 3;
		List<Integer> ans = find(arr, k);
		System.out.println(ans);
	}

	private static List<Integer> find(int[] arr, int k) {
		int start = 0;
		int end = 0;
		Deque<Integer> kaam = new ArrayDeque<>();
		List<Integer> ans = new ArrayList<>();
		while (end < arr.length) {
			// calculations
			// when we add new element in the queue check if there are ele with value less
			// than it from behind
			// not the front as the front contains the ans. If there are remove them before
			// adding the number.
			while (!kaam.isEmpty() && kaam.peekLast() < arr[end]) {
				kaam.pollLast();
			}
			kaam.add(arr[end]);
			if (end - start + 1 < k) {
				end++;
			} else if (end - start + 1 == k) {
				ans.add(kaam.peek());
				// simply check if the top ele is the start ele if yes then remove it from q as
				// we are sliding.
				if (!kaam.isEmpty() && arr[start] == kaam.peek()) {
					kaam.pop();
				}
				start++;
				end++;
			}
		}
		return ans;
	}
}

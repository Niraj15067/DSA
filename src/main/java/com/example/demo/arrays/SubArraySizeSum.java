package com.example.demo.arrays;

//max sum of sub array with size k.
public class SubArraySizeSum {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, -4, 5, 6, 7, -8, 9 };
		int k = 3;
		int max = find(arr, k);
		System.out.println(max);
	}

	private static int find(int[] arr, int k) {
		int max = -1;
		int len = arr.length;
		int start = 0, end = 0, sum = 0;
		while (end < len) {
			if (end < k) {
				sum += arr[end++];
			} else {
				max = Math.max(max, sum);
				sum -= arr[start++];
				sum += arr[end++];
			}
		}
		max = Math.max(max, sum);
		return max;
	}
}

package com.example.demo.arrays;

public class LargestLengthSubArrayGivenSum {

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 1, 1, 1, 2, 3, 4, 8 };
		int sum = 5;
		int ans = largestLength(arr, sum);
		System.out.println(ans);
	}

	private static int largestLength(int[] arr, int sum) {
		int max = -1;
		int start = 0;
		int end = 0;
		int cs = 0;
		int count = 0;
		while (end < arr.length) {
			
		}
		return max;
	}
}

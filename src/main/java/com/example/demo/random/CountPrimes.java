package com.example.demo.random;

public class CountPrimes {

	public static void main(String[] args) {

		int n = 6;
		int ans = countPrimes(n);
		System.out.println(ans);
	}

	public static int countPrimes(int n) {
		if (n <= 2) {
			return 0;
		}
		boolean[] nums = new boolean[n];
		int count = 0;
		for (int i = 2; i*i < n; i++) {
			if (!nums[i]) {
				for (int j = i*i ; j < n; j += i) {
					nums[j] = true;
				}
			}
		}
		for (int i = 2; i < n; i++) {
			if (!nums[i]) {
				count++;
			}
		}
		return count;
	}

}

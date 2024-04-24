package com.example.demo.recursion;

public class CountZero {

	public static void main(String[] args) {
		int num = 30404;
		int ans = countZero(num);
		System.out.println(ans);
	}

	public static int countZero(int num) {
		if (num == 0) {
			return 0;
		}
		if (num % 10 == 0) {
			return 1 + countZero(num / 10);
		} else {
			return countZero(num / 10);
		}
	}
}

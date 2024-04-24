package com.example.demo.random;

import java.util.Arrays;

public class uu {

	public static void main(String[] args) {

		int[] n = { 9, 9, 9 ,9};
		int[] ans = addOne(n);
		System.out.println(Arrays.toString(ans));
	}

	private static int[] addOne(int[] n) {
		int current = n.length - 1;
		int carry = 0;
		while (current >= 0 && carry == 0) {
			int add = n[current] + 1;
			carry = add % 10;
			n[current] = carry;
			current--;
		}
		if (carry == 0) {
			int[] newArr = new int[n.length + 1];
			newArr[0] = 1;
			int j = 1;
			for (int i = 0; i < n.length; i++) {
				newArr[j] = n[i];
				j++;
			}
			n = newArr;
		}
		return n;
	}
}

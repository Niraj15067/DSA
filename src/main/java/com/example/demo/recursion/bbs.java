package com.example.demo.recursion;

import java.util.Arrays;

public class bbs {

	public static void main(String[] args) {
		int[] arr = {4,3,1,2};
		sort(arr,arr.length-1,0);
		System.out.println(Arrays.toString(arr));
	}

	private static void sort(int[] arr, int r, int c) {
		boolean flag = false;
		if(c==r) {
			return;
		}
		if(arr[c+1]<arr[c]) {
			int temp = arr[c];
			arr[c] = arr[c+1];
			arr[c+1] = temp;
			flag = true;
		}
		if(!flag) {
			return;
		}
		sort(arr, r, c+1);
		sort(arr, r-1, 0);
	}

}

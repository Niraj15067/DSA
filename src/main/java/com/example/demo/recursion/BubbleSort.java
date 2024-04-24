package com.example.demo.recursion;

import java.util.Arrays;

public class BubbleSort {

	public static void main(String[] args) {
		int arr[] = {4,3,2,1};
		bubbleSort(arr, arr.length-1,0);
		System.out.println(Arrays.toString(arr));
	}

	private static void bubbleSort(int[] arr, int r, int c) {
		if(r==0) {
			return;
		}
		if(c<r) {
			if(arr[c+1]<arr[c]) {
				int temp = arr[c+1];
				arr[c+1]=arr[c];
				arr[c]=temp;
			}
			bubbleSort(arr, r, c+1);
		}else {
			bubbleSort(arr, r-1, 0);
		}
		
	}

}

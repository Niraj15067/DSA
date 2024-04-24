package com.example.demo.recursion;

import java.util.Arrays;

public class QuickSort {
	public static void main(String[] args) {
		
		int[] arr = {12,10,9,7,5};
		quickSort(arr,0,arr.length-1  );
		System.out.println(Arrays.toString(arr));
	}

	private static void quickSort(int[] arr, int low, int hi) {
		
		if(low>=hi) {
			return;
		}
		
		int mid = low+(hi-low)/2;
		int pivot = arr[mid];
		int s = low;
		int e = hi;
		
		while(s<=e) {
			if(arr[s]<pivot) {
				 s++;
			}
			else if(arr[e]>pivot) {
				e--;
			}
			else {
				int temp = arr[s];
				arr[s]=arr[e];
				arr[e]=temp;
				s++;
				e--;
			}
		}
		quickSort(arr, low,e);
		quickSort(arr, s, hi);
	}
}

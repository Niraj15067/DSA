package com.example.demo.recursion;

import java.util.Arrays;

public class SelectionSort {
	public static void main(String[] args) {
		
		int arr[]= {5,1,3,4,2};
		selectionSort(arr,arr.length,0, 0);
		System.out.println(Arrays.toString(arr));
	}

	private static void selectionSort(int[] arr, int r, int c, int max) {
		if(r==0) {
			return;
		}
		if(c<r) {
			if(arr[max]<arr[c]) {
				selectionSort(arr, r, c+1, c);
			}else {
				selectionSort(arr, r, c+1, max);
			}
			
		}
		else {
			//if you dont want to use the r-1 just pass the initial r as arr.length-1.
			//doing so might also impact the if(c<r) condition as well change it <=
			int temp=arr[r-1];
			arr[r-1]=arr[max];
			arr[max]=temp;
			selectionSort(arr, r-1, 0, 0);
		}
		
	}

}

package com.example.demo.sort;

import java.util.Arrays;

public class MissingNumber {

	public static void main(String[] args) {
		int arr[]= {9, 6, 4, 2, 3, 5, 7, 0, 1};
		sort(arr);
		int ans=missing(arr);
		System.out.println(Arrays.toString(arr));
		System.out.println("Missing value is: "+ ans);
	}
	static void sort(int[] arr) {
		int i=0;
		while(i<arr.length) {
			//when you need to insert the element at there index and not -1 that is when there is a value 0 in the array.
			int correct=arr[i];

			if(arr[i]<arr.length && arr[i]!=arr[correct]) {
				swap(arr, i, correct);
			}
			else
				i++;
		}
	}
	static int missing(int[] arr) {
		int missingVal=0;
		for(int index=0;index<arr.length;index++) {
			if(index!=arr[index])
				missingVal=index;
		}
		return missingVal;
	}
	 static void swap(int[] arr, int i, int j) {
		 
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
}

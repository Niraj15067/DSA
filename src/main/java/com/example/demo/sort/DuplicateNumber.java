package com.example.demo.sort;

import java.util.Arrays;

public class DuplicateNumber {

	public static void main(String[] args) {
		int arr[]= {1,3,4,2,2};
		int ans=sort(arr);
		System.out.println(Arrays.toString(arr));
		System.out.println("Duplicate value is: "+ ans);
	}
	static int sort(int[] arr) {
		int i=0;
		while(i<arr.length) {
			//when you need to insert the element at there index and not -1 that is when there is a value 0 in the array.
//			if(arr[i]!=i+1) {
//				
//			}
			int correct=arr[i]-1;
			if(arr[i]!=arr[correct]) {
				swap(arr, i, correct);
			}
			else
				i++;
		}
		
		int duplicateVal=0;
		for(int index=0;index<arr.length;index++) {
			if(index+1!=arr[index])
				duplicateVal=arr[index];
		}
		return duplicateVal;
	}
	//1,2,3,4,2
		
	 static void swap(int[] arr, int i, int j) {
		 
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
}


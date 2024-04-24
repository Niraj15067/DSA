package com.example.demo.search;

import java.util.Arrays;
//same binary  search code just in the end return the start to find the ceil.
public class CeilFind {

	public static void main(String[] args) {
		int arr[]= {2,3,5,9,14,16,18};
		int ceil=findCeil(arr, 19);
		System.out.println("value is: "+ ceil);
	}

	//but if the target is larger than the largest number of the array then just return -1
	private static int findCeil(int[] arr,int target) {
		
		if(target>arr[arr.length-1])
			return -1;
		int start=0;
		int end=arr.length-1;
		int mid=0;
		while(start<=end) {
			mid=start+(end-start)/2;
			if(arr[mid]==target)
				return mid;
			if(target<arr[mid])
				end=mid-1;
			else if(target>arr[mid])
				start=mid+1;
		}
		return arr[start];
	}

}

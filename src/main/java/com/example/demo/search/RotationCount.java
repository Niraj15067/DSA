package com.example.demo.search;

public class RotationCount {

	public static void main(String[] args) {
		int arr[] = {7, 9, 11, 12, 15};
		int pivot = findPivot(arr, 0, arr.length-1);
		System.out.println(pivot);
		int count=pivot+1;
		System.out.println(count);
	}

	private static int findPivot(int[] arr, int start, int end) {
		while(start<=end) {
			int mid = start+(end-start)/2;
			if(mid<end && arr[mid]>arr[mid+1])
				return mid;
			else if(mid> start && arr[mid]<arr[mid-1])
				return  mid-1;
			if(arr[start]>arr[mid])
				end=mid-1;
			else
				start=mid+1;	
		}
		return -1;
	}

}

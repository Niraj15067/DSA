package com.example.demo.search;

public class MountainPeek {

	public static void main(String[] args) {
		int [] arr= {5,1,3};
		int ans= peakIndexInMountainArray(arr);
		System.out.println(ans);
	}

	public static int peakIndexInMountainArray(int[] arr) {
		int start = 0;
		int end = arr.length - 1;
		int mid = 0;
		while (start < end) {
			mid = start + (end - start) / 2;
			if(arr[mid]>arr[mid+1])
				end=mid;
			else 
				start=mid+1;
	}
		return start;
	}
}

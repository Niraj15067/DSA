package com.example.demo.recursion;

public class SearchInRotatedArray {

	public static void main(String[] args) {
		int[] arr = { 5, 6, 7, 8, 9, 1, 2, 3 };
		int ans = search(arr, 3, 0, arr.length-1);
		System.out.println(ans);
	}

	private static int search(int[] arr, int target, int start, int end) {

			int  mid = start+(end-start)/2;
			if(arr[mid]==target) {
				return mid;
			}
			if(arr[start]<arr[mid]) {
				if(target>=arr[start] && target<arr[mid]) {
					return search(arr, target, 0, mid-1);
				}else {
					return search(arr, target, mid+1, end);
				}
			}else {
				if(target>arr[mid] && target <=arr[end]) {
					return search(arr, target, mid+1, end);
				}else {
					return search(arr, target, 0, mid-1);
				}
			}
	}
}

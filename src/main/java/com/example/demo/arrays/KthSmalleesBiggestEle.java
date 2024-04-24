package com.example.demo.arrays;

public class KthSmalleesBiggestEle {

	public static void main(String[] args) {
		int[] arr = {10,14,11,3,4,5,6,23};
		int k = 4;
		int small = kthSmallest(arr,k);
		System.out.println(small);
	}

	private static int kthSmallest(int[] arr, int k) {
		int start = 0;
		int end = arr.length-1;
		int mid = 0;
		while(start<end) {
			mid = start+(end-start)/2;
			int count = lessThan(arr,mid);
			if(count+1==k) {
				return arr[mid];
			}
			if(count>=k) {
				end = mid;
			}else {
				start = mid;
			}
		}
		return -1;
	}

	private static int lessThan(int[] arr, int mid) {
		int count = 0;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]<arr[mid]) {
				count++;
			}
		}
		return count;
	}
}


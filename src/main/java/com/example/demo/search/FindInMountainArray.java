package com.example.demo.search;

import java.util.Scanner;

//here basically you have to return the index of the first occurence of the target if not
//present then return -1
public class FindInMountainArray {

	public static void main(String[] args) {
		int arr[] = {1,2,3,4,5,3,1};
		int peak = peakIndexInMountainArray(arr);
		System.out.println(peak);
		int ans = findInMountainArray(3, arr,0,peak, true);
		if(ans==-1) {
			ans=findInMountainArray(2, arr,peak,arr.length-1,false);
		}
		System.out.println(ans);
		
	}
	private static int  findInMountainArray(int target, int[] nums,int start, int end, boolean isAsc) {
		int mid=0;
		while(start<=end) {
			mid=start+(end-start)/2;
			if(isAsc) {
				if(target>nums[mid]) {
					start=mid+1;
				}
				else if(target<nums[mid]) {
					end=mid-1;
				}
				else
					return mid;
			}
			else {
				if(target>nums[mid]) {
					end=mid-1;
				}
				else if(target<nums[mid]) {
					start=mid+1;
				}
				else
					return mid;
			}
		}
		
		return -1;
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

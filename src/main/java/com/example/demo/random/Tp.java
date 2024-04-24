package com.example.demo.random;

import java.util.HashMap;
import java.util.Map;

public class Tp {

	public static void main(String[] args) {
		int[] nums = {1,2,3,4,3,2,1};
		int ans = longest(nums);
		System.out.println(ans);
	}

	private static int longest(int[] arr) {
		int start=0,end=arr.length-1;
		while(start<end) {
			int mid = start+(end-start)/2;
			if(arr[mid]>arr[mid+1])
				end=mid;
			else
				start=mid+1;
		}
		return start;
	}
}

package com.example.demo.random;

public class MinimumInRotated {
	//4,3,2,1   3,4,5,1,2
	public static void main(String[] args) {
		int[] nums= {2,1};
		int ans=findMin(nums);
		System.out.println(ans);
	}
	public static int findMin(int[] nums) {
        int peak=findPeak(nums);
        return peak;
        }
	private static int findPeak(int[] nums) {
		int start=0;
		int end=nums.length-1;
		while(start<end) {
			int mid=start+(end-start)/2;
			if(mid<end && nums[mid]>nums[mid+1])
				return mid;
			else if(mid>start && nums[mid]<nums[mid-1])
				return mid-1;
			else 
				start=mid+1;
		}
		return 0;
	}
}

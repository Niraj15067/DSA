package com.example.demo.search;

public class SplitArrayLargestSum {

	public static void main(String[] args) {
		int[] nums = {7,2,5,10,8}; 
		int ans = splitArray(nums, 2);
		System.out.println(ans);

	}
	public static int splitArray(int[] nums, int m) {
		
		int start = 0, end=0;
		for(int i=0;i<nums.length;i++) {
			start = Math.max(start, nums[i]);//largest individual ele
			end +=nums[i]; //sum of the whole array,
		}
		
		//binary search
		while(start<end) {
			int mid = start+(end-start)/2; //this  is the max allowed sum for a sub array or partition.
			//find the partition for this mid then.
			int pieces = 1;
			int sum = 0;
			for(int num:nums) {
				if(sum+num>mid) {
					sum=num;
					pieces++;
				}
				else {
					sum+=num;
				}
			}
			if(pieces>m) {
				start = mid+1; // if we have more pieces than we need
			}
			else {
				end = mid;
			}
			
		}
		return end; //at the end the end or the start will have the value of the largest sum that
					//that we need and return the same. Run with debugger to check the same.
	}

}

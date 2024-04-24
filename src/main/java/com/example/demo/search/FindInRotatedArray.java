package com.example.demo.search;

import java.util.Scanner;


public class FindInRotatedArray {

	public static void main(String[] args) {
		int nums[] = {4,3,2,1};
		int pivot=findPeak(nums);
        if(pivot==-1){
            System.out.println(binarySearch(0,nums.length-1,nums, 1));
        }
        if(1==nums[pivot])
        	System.out.println(pivot);
        if(nums[0]>1){
        	System.out.println(binarySearch(pivot+1,nums.length-1,nums, 1));
        }
        System.out.println(binarySearch(0,pivot,nums,1));
    }
    public static int findPeak(int[] nums){
        int start=0;
        int end=nums.length-1;
        while(start<end){
            int mid=start+(end-start)/2;
            if(mid<end && nums[mid]>nums[mid+1])
                return mid;
            if(mid>start && nums[mid]<nums[mid-1])
                return mid-1;
            if(nums[mid]<=nums[start])
                end=mid-1;
            else
                start=mid+1;
        }
        return -1;
    }

    public static int binarySearch(int start, int end, int[] nums, int target){
        int mid=0;
        while(start<=end){
            mid=start+(end-start)/2;
            if(target<nums[mid])
                end=mid-1;
            else if(target>nums[mid])
                start=mid+1;
            else
                return mid;
        }
        return -1;
    }
}


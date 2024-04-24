package com.example.demo.random;

public class MissingNumber {

	public static void main(String[] args) {
		int[] nums={1};
		int ans=missingNumber(nums);
		System.out.println(ans);
	}
	 public static int missingNumber(int[] nums) {
		 int i=0;
	        while(i<nums.length) {
	        	int correct=nums[i];
	        	if(nums[i]<nums.length && nums[correct]!=nums[i]) {
	        		int temp=nums[i];
	        		nums[i]=nums[correct];
	        		nums[correct]=temp;
	        	}
	        	else 
	        		i++;
	        }
	        int missing=-1;
	        for(int j=0;j<nums.length;j++) {
	        	if(j!=nums[j])
	        		missing=j;
	        }
	        if(missing==0)
	        	return nums.length;
	        return missing;
	    }
}

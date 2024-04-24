package com.example.demo.search;

import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDuplicate {

	public static void main(String[] args) {
		int nums[]= {0,0,1,1,1,2,2,3,3,4};
		int unique=1;
		for(int i=1;i<nums.length-1;i++) {
			if(nums[i]!=nums[i-1]) {
				nums[unique]=nums[i];
				unique++;
			}
		}
		System.out.println(unique);
	}

}

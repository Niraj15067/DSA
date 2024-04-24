package com.example.demo.random;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SingleNumber {

	public static void main(String[] args) {
		int nums[]= {4,1,2,1,2};
		int ans=singleNumber(nums);
		System.out.println(ans);
	}
	private static int singleNumber(int[] nums) {
		
		int result=0;
	      for(int num: nums){
					result^=num;
				}
				return result;
		
//		HashMap<Integer, Integer> single=new HashMap<>();
//		for(int i=0;i<nums.length;i++) {
//			single.put(nums[i], single.getOrDefault(nums[i], 0)+1);
//		}
//		for(Map.Entry<Integer, Integer> entry: single.entrySet()) {
//			if(entry.getValue()==1)
//				return entry.getKey();
//		}
//		return -1;
	}

}

package com.example.demo.hashTables;

import java.util.HashSet;

public class FirstMissingPositive {

	public static void main(String[] args) {

		int nums[] = {1,2,0};
		int ans = firstMissingPositive(nums);
		System.out.println(ans);
	}
	//we are going to put all the elements of the array inside a set.
	//now start checking from 1 are all the elements inside the set the first one absent will be the ans.
	//number of comparisons are obv the number of elements in the array +1
	//+1 because even if we have 1,2,0 in the  array we have 3 absent so we need to check for that as well.
	public static int firstMissingPositive(int[] nums) {
		HashSet<Integer> set = new HashSet<>();
		for(int num:nums) {
			if(num>0) {
				set.add(num);
			}
		}
		for(int i=1;i<=set.size()+1;i++) {
			if(!set.contains(i)) {
				return i;
			}
		}
		return -1;
	}
}

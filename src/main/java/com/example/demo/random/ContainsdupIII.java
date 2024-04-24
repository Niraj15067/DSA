package com.example.demo.random;

import java.util.TreeSet;

public class ContainsdupIII {

//	You are given an integer array nums and two integers indexDiff and valueDiff.
//
//	Find a pair of indices (i, j) such that:
//
//	i != j,
//	abs(i - j) <= indexDiff.
//	abs(nums[i] - nums[j]) <= valueDiff, and
//	Return true if such pair exists or false otherwise.
	
	public static void main(String[] args) {
		int[] nums= {1,5,9,1,5,9};
		int indexDiff =2;
		int valueDiff =3;
		boolean ans = containsNearbyAlmostDuplicate(nums, indexDiff, valueDiff);
		System.out.println(ans);

	}
	public static boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        TreeSet<Long> window = new TreeSet<>();
        
        for (int i = 0; i < nums.length; i++) {
            Long ceiling = window.ceiling((long) nums[i] - valueDiff);
            if (ceiling != null && ceiling <= (long) nums[i] + valueDiff) {
                return true;
            }
            
            window.add((long) nums[i]);
            
            if (i >= indexDiff) {
                window.remove((long) nums[i - indexDiff]);
            }
        }
        
        return false;
    }
}

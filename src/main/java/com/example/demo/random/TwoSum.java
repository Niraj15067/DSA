package com.example.demo.random;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public class TwoSum {

	public static void main(String[] args) {
		int[] arr= {1,2,3,4,5,6,7,8};
		List ans=findTwo(arr, 5);
		System.out.println(ans.toString());
	}
	private static List findTwo(int[] arr, int target) {
		Map<Integer, Integer> twoSum = new HashMap<>();
		List<Integer> ans = new ArrayList<>();
		for(int i=0;i<arr.length;i++) {
			int compliment = target-arr[i];
			if(twoSum.containsKey(compliment)) {
//				return new int[] {compliment, arr[i]};
				ans.add(compliment);
				ans.add(arr[i]);
			}
			else
				twoSum.put(arr[i],i);
		}
		if(ans.size()==0) {
			ans.add(-1);
		}
		return ans;
		
	}
	
}

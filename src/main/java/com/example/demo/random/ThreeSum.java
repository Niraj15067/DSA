package com.example.demo.random;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ThreeSum {
	public static void main(String[] args) {
		
		int arr[]= {4,5,3,6,4,2};
		List<Integer> ans = threeSum(arr,12);
		System.out.println(ans.toString());
	}

	private static List<Integer> threeSum(int[] arr, int sum) {
		List<Integer> ans =new ArrayList<>();
		for(int  i = 0;i<arr.length;i++) {
			int comp = sum -arr[i];
			ans = findTwo(arr,comp,i+1);
			if(ans.size()!=2)
				continue;
			ans.add(0,arr[i]);
			break;
		}
		return ans;
	}
	private static List<Integer> findTwo(int[] arr, int target, int j) {
		Map<Integer, Integer> twoSum = new HashMap<>();
		List<Integer> ans = new ArrayList<>();
		for(int i=j;i<arr.length;i++) {
			int compliment = target-arr[i];
			if(twoSum.containsKey(compliment)) {
//				return new int[] {compliment, arr[i]};
				ans.add(compliment);
				ans.add(arr[i]);
			}
			else
				twoSum.put(arr[i],compliment);
		}
		return ans;
		
	}
}

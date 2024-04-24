package com.example.demo.recursion;

import java.util.ArrayList;
import java.util.List;

public class SubsetWithRecursion {

	public static void main(String[] args) {
		
		int[] arr = {1,2,2};
		List<Integer> ans = new ArrayList<>();
		List<List<Integer>> whole = new ArrayList<>();
		subset(arr,0,arr.length,ans,whole);
		System.out.println(whole);

	}

	private static void subset(int[] arr,int idx,int n,List<Integer> ans,List<List<Integer>> whole) {
		
		if(idx==n) {
			if(!whole.contains(ans))
				whole.add(new ArrayList<>(ans));
			return;
		}
		
		ans.add(arr[idx]);
		subset(arr,idx+1,n,ans,whole);
		ans.remove(ans.size()-1);
		subset(arr, idx+1,n, ans, whole);
		
	}

}

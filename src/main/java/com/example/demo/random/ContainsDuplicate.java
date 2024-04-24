package com.example.demo.random;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class ContainsDuplicate {

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4, 1};
//		Set<Integer> unique = new HashSet<>(Arrays.stream(arr).boxed().collect(Collectors.toList()));
//		if(unique.size()!=arr.length)
//			System.out.println("duplicate exists");
//		else
//			System.out.println("duplicate nai hai");
		boolean ans = find(arr);
		System.out.println(ans);
	}

	private static boolean find(int[] arr) {
		Map<Integer, Integer> unique = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			if (unique.containsKey(arr[i]))
				return true;
			else
				unique.put(arr[i], i);
		}
		int a = Math.abs(-10-10);
		return false;
		
	}

}

package com.example.demo.random;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ThrSum {

	public static void main(String[] args) {
		int arr[]= {4,5,3,6,4,2};
		int sum = 9;
		List<List<Integer>> ans = threeSum(arr, sum);
		System.out.println(ans.toString());
	}
	private static List<List<Integer>> threeSum(int[] arr, int sum) {
	    List<List<Integer>> triplets = new ArrayList<>();

	    // Sort the array to handle duplicates and for efficient traversal
	    Arrays.sort(arr);
	    System.out.println(Arrays.toString(arr));

	    for (int i = 0; i < arr.length - 2; i++) {
	        if (i > 0 && arr[i] == arr[i - 1]) {
	            continue; // Skip duplicates
	        }

	        int target = sum - arr[i];
	        int left = i + 1;
	        int right = arr.length - 1;

	        while (left < right) {
	            int currentSum = arr[left] + arr[right];

	            if (currentSum == target) {
	                triplets.add(Arrays.asList(arr[i], arr[left], arr[right]));

	                // Skip duplicates
	                while (left < right && arr[left] == arr[left + 1]) {
	                    left++;
	                }
	                while (left < right && arr[right] == arr[right - 1]) {
	                    right--;
	                }

	                left++;
	                right--;
	            } else if (currentSum < target) {
	                left++;
	            } else {
	                right--;
	            }
	        }
	    }

	    return triplets;
	}


}

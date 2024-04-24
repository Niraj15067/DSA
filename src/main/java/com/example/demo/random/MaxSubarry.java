package com.example.demo.random;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MaxSubarry {

	public static void main(String[] args) {
		int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
		int[] nums = {1, 4, 20, 3, 10, 5};
		int res[] = subArraySumNonNegative(nums,15);
		System.out.println(Arrays.toString(res));
//		int ans = find(arr);
//		System.out.println("Maximum contagious sub array sum is: "+ ans);
	}
	public static int find(int[] arr) {
		
		int max = Integer.MIN_VALUE;
		int sum = 0;
		for(int i=0;i<arr.length;i++) {
			sum = Math.max(arr[i], arr[i]+sum);
			max = Math.max(max, sum);
		}
		return max;
	}
	//optimal solution.
	public static int[] subArraySumNonNegative(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int currentSum = 0;

        for (int end = 0; end < arr.length; end++) {
            currentSum += arr[end];

            if (currentSum == target) {
                return new int[]{0, end};
            }

            int diff = currentSum - target;
            if (map.containsKey(diff)) {
                return new int[]{map.get(diff) + 1, end};
            }

            map.put(currentSum, end);
        }

        return new int[]{-1, -1};
    }
	
	//not optimal.
	public static int[] subArraySumNonNegative1(int[] arr,int target) {
		int start = 0, end = 0,currentSum = 0;
		for(int i=0;i<arr.length;i++) {
			currentSum += arr[end];
			end++;
			if(currentSum==target) {
				return new int[] {start,--end};
			}else if(currentSum>target){
				for(int j=0;j<=end;j++) {
					currentSum -= arr[start];
					start++;
					if(currentSum==target) {
						return new int[] {start,--end};
					}
				}
			}
		}
		return new int[] {-1,-1};
	}
}

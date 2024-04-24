package com.example.demo.random;

public class MaximumSubarray {

	public static void main(String[] args) {
		int[] nums= {7,1};
		int ans =  maxSubArray(nums);
		System.out.println(ans);
	}

	private static int maxSubArray(int[] nums) {
		int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;
        
        for (int price : nums) {
            minPrice = Math.min(minPrice, price);
            maxProfit = Math.max(maxProfit, price - minPrice);
        }
        
        return maxProfit;
	}
}

package com.example.demo.random;

import java.util.Arrays;

public class BuyAndSellStock {

	public static void main(String[] args) {
		int nums[]= {1,4,2};
		int ans=buyAndSell(nums);
		System.out.println(ans);
	}

	private static int buyAndSell(int[] prices) {
		int buy=Integer.MAX_VALUE,sell=Integer.MIN_VALUE;
		int i=0, j=prices.length-1;
		
		while(i<j) {
			if(i+1<prices.length && prices[i]>prices[i+1]) {
				i++;
				continue;
			}
			buy=Math.min(buy, prices[i]);
			sell=Math.max(sell,prices[j]);
			i++;
			j--;
		}
		if(buy==Integer.MAX_VALUE)
			return 0;
		
		return sell-buy;
	}

}

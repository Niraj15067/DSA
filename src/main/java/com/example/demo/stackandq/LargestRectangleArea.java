package com.example.demo.stackandq;

import java.util.Stack;

//brute force approach not accepted on leetcode.
public class LargestRectangleArea {

	public static int largestRectangleArea(int[] heights) {

		if (heights.length == 1) {
			return heights[0];
		}

		int currentArea = heights[0];
		int areaTillNow = 0;
		int height = 0;
		int width = 0;
		int heightTillNow = 0;
		int currH = 0;

		for (int i = 1; i < heights.length; i++) {
			currentArea = Math.max(currentArea, heights[i]);
			width = 2;
			height = heights[i];
			currH = heights[i];
			for (int j = i, k = i - 1; j > 0 && k >= 0; j--, k--) {
				currH = Math.min(currH, heights[k]);
				heightTillNow = Math.min(heights[j], currH);
				heightTillNow = Math.min(height, heightTillNow);
				areaTillNow = Math.max(areaTillNow, heightTillNow * width);
				width++;
			}
		}
		return Math.max(areaTillNow, currentArea);
	}

	public static void main(String[] args) {
		int[] heights = { 9, 0 };
		int area = largestRectangleArea(heights);
		System.out.println("Largest area is: " + area);
	}
}

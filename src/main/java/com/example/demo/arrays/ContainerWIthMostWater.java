package com.example.demo.arrays;

//https://leetcode.com/problems/container-with-most-water/
public class ContainerWIthMostWater {

	public static void main(String[] args) {

		int height[] = {1,8,6,2,5,4,8,3,7};
		int maxArea = maxArea(height);
		System.out.println(maxArea);
	}

	public static int maxArea(int[] height) {
        if(height.length<=1){
            return 0;
        }
        int max = 0;
        int start = 0, end = height.length-1;
        while(start<end){
            //multiply lower of the two values of height with the subtraction of the indices of start 
            //and end.
            max = Math.max(max, (end-start)*Math.min(height[start],height[end]));
            //lower value height is being skipped other ramins same for the next calculation.
            if(height[start]>height[end]){
                end--;
            }else{
                start++;
            }
        }
        return max;
    }
}

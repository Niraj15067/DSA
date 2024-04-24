package com.example.demo.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NegativeFirst {

	public static void main(String[] args) {
		int [] arr= {1,2,3,-3,1,-2,-3};
		move(arr);
		List<Integer> list = new ArrayList<>();
		System.out.println(Arrays.toString(arr));
	}

	private static void move(int[] arr) {
		int s = 0;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]<0 && i!=s) {
				arr[s] = arr[s]+arr[i]; 
				arr[i] = arr[s]-arr[i]; 
				arr[s] = arr[s]-arr[i];
				s++;
			}
		}
		
	}
}

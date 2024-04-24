package com.example.demo.search;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class BinaryIn3dArray {

	public static void main(String[] args) {
		//here 10 will be the lower bound and the 40  will be the upper bound this is a row and 
		//col wise sorted array so skip the column if the top ele in the col is greater than the
		//target that is col -- and if the target is greater than the target then row ++.
		int arr[][] = { 
				{ 1,3 }};
		int[] ans = binarySearch(arr, 3);
		System.out.println(Arrays.toString(ans));
		Set<Integer> a= new HashSet<>();
	}

	public static int[] binarySearch(int arr[][], int target) {
		int row = 0;
		int column = arr[0].length;
		while (column >= 0 &&  row< arr[0].length - 1) {
			if (target == arr[row][column])
				return new int[] { row, column };
			else if (target < arr[row][column])
				column--;
			else
				row++;
		}
		return new int[] { -1, -1 };
	}

}

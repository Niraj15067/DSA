package com.example.demo.search;

import java.util.Arrays;

public class BinaryIn3DSortedArray {

	public static void main(String[] args) {
		int[][] arr= {
				{1,2,3},
				{4,5,6},
				{7,8,9}
		};
		int res[] = search(arr, 4);
		System.out.println(Arrays.toString(res));
	}

	private static int[] search(int[][] arr, int target) {
		int rows = arr.length-1; 
		int cols = arr[0].length-1;
		
		if(rows==0)
			return binarySearch(arr, rows, 0, cols, target);
		
		int rStart = 0;
		int rEnd = rows;
		int cMid = cols+1/2;
		while(rStart < rEnd-1) {
			int mid = rStart + (rEnd-rStart)/2;
			if(arr[mid][cMid]==target)
				return new int[] {mid, cMid};
			if(arr[mid][cMid]<target)
				rStart = mid;
			else
				rEnd = mid;
		}
		
		if(arr[rStart][cMid] == target)
			return new int[] {rStart, cMid};
		
		if(arr[rStart+1][cMid] == target)
			return new int[] {rStart+1, cMid};
		
		if(target <= arr[rStart][cMid-1])
			return binarySearch(arr, rStart, 0, cMid-1, target);
		
		if(target >= arr[rStart][cMid] && target <= arr[rStart][cols])
			return binarySearch(arr, rStart, cMid+1, cols, target);
		
		if(target <= arr[rStart+1][cMid-1])
			return binarySearch(arr, rStart+1, 0, cMid-1, target);
		
		else
			return binarySearch(arr, rStart+1, cMid+1, cols, target);
	}
	
	private static int[] binarySearch(int[][] arr, int row, int cStart, int cEnd, int target) {
		while(cStart<=cEnd) {
			int mid = cStart+(cEnd-cStart)/2;
			if(arr[row][mid]==target)
				return new int[] {row,mid};
			if(arr[row][mid]<target)
				cStart = mid+1;
			else
				cEnd = mid-1;
		}
		return new int[] {-1,-1};
	}

}

package com.example.demo.search;

public class LinearSearch {

	public static void main(String[] args) {
		int arr[] = { 10, 20, 30, 5, 6, 7, 8, 9, 3 };
		int target = 6;
		int index = linearSearch(arr, target);
		System.out.println("Element found at index: " + index);

		String str = "Nirai";
		char search = 'j';
		boolean result = charSearch(str, search);
		System.out.println("j found ?: " + result);
		int min = findMin(arr);
		System.out.println("The smallest value is: " + min);

		// 2d array
		int twoDArr[][] = { { 12, 23, 45 }, { 23, 67, 89, 67 }, { 13, 46, 78, 56 }, { 12, 56 }

		};
		int dest = 56;
		System.out.println("Number found at index: " + searchIn2dArr(twoDArr, dest));
		
		//find min value in 2d array.
		//similarly can be done for the max by changing the sign of the if cond.
		int res=findMin(twoDArr);
		System.out.println("Minimum value is : "+res);

	}

	// search in 2d array.
	static String searchIn2dArr(int[][] twoDArr, int dest) {
		if (twoDArr.length == 0)
			return "Not found";
		for (int row = 0; row < twoDArr.length; row++) {
			for (int column = 0; column < twoDArr[row].length; column++) {
				if (twoDArr[row][column] == dest)
					return "Found  at row: " + row + " and column: " + column;
				// or you can create a new array of 2 length holding the row and the col
				// and return int[]{row,column};
			}
		}
		return "Not found";
	}

	// search in 2d array.
	static int findMin(int[][] twoDArr) {
		if (twoDArr.length == 0)
			return -1;
		int min =  Integer.MAX_VALUE;
		for (int row = 0; row < twoDArr.length; row++) {
			for (int column = 0; column < twoDArr[row].length; column++) {
				if (twoDArr[row][column]<min)
					 min= twoDArr[row][column];
			}
		}
		return min;
	}

	public static int linearSearch(int[] arr, int target) {
		if (arr.length == 0)
			return -1;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == target)
				return i;
		}
		return -1;
	}

	static boolean charSearch(String str, char search) {
		if (str.length() == 0)
			return false;
		for (char c : str.toCharArray()) {
			if (c == search)
				return true;
		}
		return false;

	}

	// find minimum number from the array
	// similarly the largest can be found.
	static int findMin(int[] arr) {
		if (arr.length == 0)
			return -1;
		int min = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (min > arr[i])
				min = arr[i];
		}
		return min;
	}

}

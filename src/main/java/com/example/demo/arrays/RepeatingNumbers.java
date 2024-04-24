package com.example.demo.arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RepeatingNumbers {

	 public static List<Integer> findRepeatingNumbers(int[] arr)  {
	        List<Integer> duplicates = new ArrayList<>();
	        int n = arr.length;
	 
	        // First check all the values that are present in
	        // the array then go to those values as indices and
	        // increment by the size of the array
	        for (int i = 0; i < n; i++) {
	            int index = arr[i] % n;
	            arr[index] += n;
	        }
	 
	        // Now check which value exists more than once by
	        // dividing with the size of the array
	        for (int i = 0; i < n; i++) {
	            if (arr[i] / n >= 2) {
	                duplicates.add(i);
	            }
	        }
	        return duplicates;
	    }

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the value of n: ");
		int n = scanner.nextInt();
		int[] arr = new int[n];
		System.out.println("Enter the elements of the array: ");
		for (int i = 0; i < n; i++) {
			arr[i] = scanner.nextInt();
		}
		List ans = findRepeatingNumbers(arr);
		System.out.println(ans);
		scanner.close();
	}
}

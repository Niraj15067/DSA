package com.example.demo.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MissingMultipleNumbers {

	public static void main(String[] args) {
		int arr[]= {4,3,2,7,8,2,3,1};
		sort(arr);
		List<Integer> result = missing(arr);
		System.out.println(Arrays.toString(arr));
		System.out.println("Missing value is: "+ result.toString());
	}
	static void sort(int[] arr) {
		int i=0;
		while(i<arr.length) {
			//when you need to insert the element at there index and not -1 that is when there is a value 0 in the array.
			int correct=arr[i]-1;
			
			//here you dont need this condition  if(arr[i]<arr.length && arr[i]!=arr[correct]) 
			//Because here there is no 0 value in the array.
			if(arr[i]!=arr[correct]) {
				swap(arr, i, correct);
			}
			else
				i++;
		}
	}
	static List missing(int[] arr) {
		List<Integer> missingVals=new ArrayList<>();
		for(int index=0;index<arr.length;index++) {
			if(arr[index]!=index+1)
				//add index +1 because we want the value which is missing not the index.
				missingVals.add(index+1);
		}
		return missingVals;
	}
	 static void swap(int[] arr, int i, int j) {
		 
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
}


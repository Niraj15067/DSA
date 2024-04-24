package com.example.demo.sort;

import java.util.Arrays;

public class InsertionSort {

	public static void main(String[] args) {
		int arr[]= {2,4,1,5,3};
		for(int i =0;i<arr.length;i++) {
			for(int j=i;j>=0;j--) {
				if(j+1<arr.length && arr[j]>arr[j+1]) {
					int temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
		}
		System.out.println(Arrays.toString(arr));

	}

}

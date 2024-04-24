package com.example.demo.sort;

import java.util.Arrays;

public class SelectionSort {

	public static void main(String[] args) {
		
		int arr[]= {5,1,4,2,3};
		for(int  i=0;i<arr.length;i++) {
			int max=0;
			int last=arr.length-1-i;
			for(int j=0;j<=arr.length-i-1;j++) {
				if(arr[max]<arr[j])
					max=j;
			}
			int temp=arr[last];
			arr[last]=arr[max];
			arr[max]=temp;
		}
		System.out.println(Arrays.toString(arr));
	}

}

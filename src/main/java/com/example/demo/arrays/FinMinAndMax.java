package com.example.demo.arrays;

public class FinMinAndMax {

	public static void main(String[] args) {
		int[] array = {5,1,3,9,2,34};
		quickSort(array,0,array.length-1);
		int min = array[0];
		int max = array[array.length-1];
		System.out.println("Minimum ele in array is : "+ min+ " Max ele in the array is : "+ max);
	}

	private static void quickSort(int[] arr, int low, int hi) {
		
		if(low>=hi) {
			return;
		}
		int s = low;
		int e = hi;
		int mid = s+(e-s)/2;
		int pivot = arr[mid];
		while(s<=e) {
			while(arr[s]<pivot) {
				s++;
			}
			while(arr[e]>pivot) {
				e--;
			}
			if(s<=e) {
				int temp = arr[s];
				arr[s]=arr[e];
				arr[e]=temp;
				s++;
				e--;
			}
		}
		quickSort(arr,low,e);
		quickSort(arr,s,hi);
	}
}


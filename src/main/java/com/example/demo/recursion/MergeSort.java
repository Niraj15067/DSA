package com.example.demo.recursion;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		int[] arr= {5,4,3,2,1};
		int[] ans = mergeSort(arr);
		System.out.println(Arrays.toString(ans));
	}

	private static int[] mergeSort(int[] arr) {
		if(arr.length==1) {
			return arr;
		}
		
		int mid = arr.length/2;
		
		int left[] = Arrays.copyOfRange(arr, 0, mid);
		int right[] = Arrays.copyOfRange(arr, mid,arr.length);
		
		left=mergeSort(left);
		right=mergeSort(right);
		return merge(left, right);
	}

	private static int[] merge(int[] left, int[] right) {
		
		int i=0,j=0,k=0;
		int merged[] = new int[left.length+right.length];
		while(i<left.length && j<right.length) {
			if(left[i]<right[j]) {
				merged[k]=left[i];
				i++;
			}else {
				merged[k]=right[j];
				j++;
			}
			k++;	
		}
		while(i<left.length) {
			merged[k]=left[i];
			i++;
			k++;
		}
		while(j<right.length) {
			merged[k]=left[j];
			j++;
			k++;
		}
		return merged;
	}

}

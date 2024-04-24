package com.example.demo.recursion;

import java.util.Arrays;

public class MergeSortInPlace {

	public static void main(String[] args) {
		int[] arr = { 5, 4, 3, 2, 1 };
		mergeSort(arr, 0, arr.length);
		System.out.println(Arrays.toString(arr));
	}

	private static void mergeSort(int[] arr, int start, int end) {
		if (end - start == 1) {
			return;
		}
		int middle = (start + end) / 2;

		mergeSort(arr, start, middle);
		mergeSort(arr, middle, end);

		merge(arr, start, middle, end);
	}

	private static void merge(int[] arr, int start, int mid, int end) {

		int i = start, j = mid, k = 0;
		int merged[] = new int[end - start];
		while (i < mid && j < end) {
			if (arr[i] < arr[j]) {
				merged[k] = arr[i];
				i++;
			} else {
				merged[k] = arr[j];
				j++;
			}
			k++;
		}
		while (i < mid) {
			merged[k] = arr[i];
			i++;
			k++;
		}
		while (j < end) {
			merged[k] = arr[j];
			j++;
			k++;
		}
		System.arraycopy(merged, 0, arr, start+0, merged.length);
	}

}

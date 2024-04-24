package com.example.demo.random;

import java.util.Arrays;

public class MergeSortedArrays {

	public static void main(String[] args) {

		int[] n1 = { 1, 2, 3, 0, 0, 0 };
		int[] n2 = { 2, 5, 6 };
		merge(n1, 6, n2, 3);
		System.out.println(Arrays.toString(n1));
	}

	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		int[] merged = new int[nums1.length];
		int s1 = 0;
		int s2 = 0;
		int k = 0;
		while (s1 < m-n && s2 < n) {
			if (nums1[s1] <= nums2[s2]) {
				merged[k] = nums1[s1];
				s1++;
			} else {
				merged[k] = nums2[s2];
				s2++;
			}
			k++;
		}
		while (s1 < m-n) {
			merged[k] = nums1[s1];
			s1++;
			k++;
		}
		while (s2 < n) {
			merged[k] = nums2[s2];
			s2++;
			k++;
		}
		for (int i = 0; i < merged.length; i++) {
			nums1[i] = merged[i];
		}
	}

}

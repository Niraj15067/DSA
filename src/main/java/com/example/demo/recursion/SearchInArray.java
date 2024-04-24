package com.example.demo.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchInArray {

	static List<Integer> indexes = new ArrayList<>();

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4, 4, 4, 5, 6 };
//		System.out.println(search1(arr,1,0));
		
		System.out.println(findAllIndexes2(arr, 4, 0));
	}

	private static boolean search(int[] arr, int target, int idx) {
		if (idx == arr.length) {
			return false;
		}
		return (arr[idx] == target) || search(arr, target, idx + 1);
	}

	private static int search1(int[] arr, int target, int idx) {
		if (idx == arr.length) {
			return -1;
		}
		return (arr[idx] == target ? idx : search1(arr, target, idx + 1));
	}

	private static void findAllIndexes(int[] arr, int target, int idx) {
		if (idx == arr.length) {
			return;
		}
		if (arr[idx] == target) {
			indexes.add(idx);
		}
		findAllIndexes(arr, target, idx + 1);
	}
	private static ArrayList<Integer> findAllIndexes2(int[] arr, int target, int idx) {
		ArrayList<Integer> list = new ArrayList<>();
		if (idx == arr.length) {
			return list;
		}
		if(arr[idx]==target) {
			list.add(idx);
		}
		ArrayList<Integer> belowCalls = findAllIndexes2(arr, target, idx+1);
		list.addAll(belowCalls);
		return list;
	}
}

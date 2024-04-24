package com.example.demo.search;

import java.util.Scanner;

public class BinarySearch {
	public static void main(String[] args) {
		int arr[] = { 10, 20, 30, 50, 60, 70, 80, 90, 300};
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter element to search: ");
		int find=sc.nextInt();
		int mid=0, left=0, right=arr.length-1,index=0;
		while(left<=right){
			mid=(left+right)/2;
			if(arr[mid]==find) {
				index=mid;
				break;
			}
			else if(find>arr[mid]) {
				left=mid+1;
			}
			else if(find<arr[mid]) {
				right=mid-1;
			}
			else
				index=-1;
		}
		if (index == -1) {
		    System.out.println("Element not found");
		} else {
		    System.out.println("Element found at index: " + index);
		}
	}
}

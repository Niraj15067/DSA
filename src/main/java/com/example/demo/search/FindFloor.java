package com.example.demo.search;

public class FindFloor {

	public static void main(String[] args) { 
			int arr[]= {2,3,5,9,14,16,18};
			int floor=findFloor(arr, 10);
			System.out.println("value is: "+ floor);
		}

		private static int findFloor(int[] arr,int target) {
			int start=0;
			int end=arr.length-1;
			int mid=0;
			while(start<=end) {
				mid=start+(end-start)/2;
				if(arr[mid]==target)
					return arr[mid];
				if(target<arr[mid])
					end=mid-1;
				else if(target>arr[mid])
					start=mid+1;
			}
			return arr[end];
		}

	}


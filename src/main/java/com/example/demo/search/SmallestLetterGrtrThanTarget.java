package com.example.demo.search;

public class SmallestLetterGrtrThanTarget {

	public static void main(String[] args) {
		char arr[]= {'c','f','j'};
		char ceil=findCeil(arr, 'j');
		System.out.println("value is: "+ ceil);
	}

	//but if the target is larger than the largest number of the array then just return -1
	private static char findCeil(char[] arr,char target) {
		int start=0;
		int end=arr.length-1;
		int mid=0;
		while(start<=end) {
			mid=start+(end-start)/2;
			if(target<arr[mid])
				end=mid-1;
			//important thing to note here is that dont give the condition for the target>arr[mid]
			//if you give no answer will be given.
			//you might think that our ans is crossed and all 3 are on the same index in the next
			//itertaion while con will be violated and we will return the ans
			else 
				start=mid+1;
		}
		return arr[start%arr.length];
	}

}


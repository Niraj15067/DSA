package com.example.demo.search;

public class CountNumberOfEvenDigitNumbers {

	public static void main(String[] args) {
		
		int arr[]= {1,123,45,6789,98,2345,45678,78906};
		int evnCount = findEvenNumberOfDigits(arr);
		System.out.println("Total numbers having even number of digits: "+evnCount);
	}

	 static int findEvenNumberOfDigits(int[] arr) {
		 int evenDigits=0;
		for(int i=0;i<arr.length;i++) {
			int count=0;
			int temp=arr[i];
			while(temp>0) {
				temp/=10;
				count++;
			}
			if(count%2==0)
				evenDigits++;
		}
		return evenDigits;
	}
	 
}

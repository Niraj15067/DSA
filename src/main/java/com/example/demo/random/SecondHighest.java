package com.example.demo.random;

public class SecondHighest {

	public static void main(String[] args) {
		int[] arr = {10,5,6,12,34,23};
		int highest = arr[0];
		int sh = Integer.MIN_VALUE;
		int th = sh;
		for(int i=1;i<arr.length;i++) {
			if(arr[i]>highest) {
				sh = highest;
				highest = arr[i];
			}
			if(arr[i]>sh && arr[i]<highest) {
				if(th<sh) {
					th = sh;
				}
				sh = arr[i];
			}
			if(arr[i]>th && arr[i]<sh) {
				th = arr[i];
			}
		}
		System.out.println(th);
	}
}

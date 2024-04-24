package com.example.demo.random;

import java.util.Arrays;

public class AddOne {

	public static void main(String[] args) {
		int arr[] = {9,9,9,9};
		int carry=1;
		int i=arr.length-1;
		while(carry!=0 && i>=0) {
			int current=(arr[i]+1)%10;
			carry=(arr[i]+1)/10;
			if(current==0) {
				arr[i]=current;
				i--;
			}
			else {
				arr[i]+=1;
				break;
			}	
		}
		if(carry!=0) {
			int newArr[]= new int[arr.length+1];
			System.out.println(newArr.length);
			newArr[0]=carry;
			for(int j=1;j<newArr.length;j++) {
				newArr[j]=0;
			}
			System.out.println(Arrays.toString(newArr));
		}
		else
			System.out.println(Arrays.toString(arr));
	}
}

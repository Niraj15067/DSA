package com.example.demo.random;

import java.util.Arrays;

public class PlusOne {

	public static void main(String[] args) {
		int[] arr= {9};
		int ans[]=plusOne(arr);
		System.out.println(Arrays.toString(ans));
	}

	private static int[] plusOne(int[] digits) {
		 int len=digits.length;
	       int carry=1;
	       for(int i=len-1;i>=0;i--){
	           int sum=digits[i]+carry;
	           digits[i]=sum % 10;
	           carry=sum / 10;

	           if(carry==0)
	                break;
	       }
	       if(carry>0){
	           int[] result = new int[len+1];
	           result[0]=carry;
	           System.arraycopy(digits, 0, result, 1, len);
	           return result;
	       }
	       else
	            return digits;
	}


}

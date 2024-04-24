package com.example.demo.random;

public class Multiply {

	public static void main(String[] args) {
		String ans = multiply("123", "456");
		System.out.println(ans);
	}

	  public static String multiply(String num1, String num2) {
	        // Calculate the lengths of the input strings
	        int n1 = num1.length(), n2 = num2.length();
	        
	        // Array to store the products of digits
	        int[] products = new int[n1 + n2];

	        // Multiply each digit of num1 with each digit of num2
	        for (int i = n1 - 1; i >= 0; i--) {
	            for (int j = n2 - 1; j >= 0; j--) {
	                int d1 = num1.charAt(i) - '0';
	                int d2 = num2.charAt(j) - '0';
	                // Add the product to the corresponding position in the products array
	                products[i + j + 1] += d1 * d2;
	            }
	        }
	        //process all the carries 
	        int carry = 0;
	        for(int i=products.length-1;i>=0;i--) {
	        	 int val = (products[i]+carry)%10;
	        	 carry = (products[i]+carry)/10;
	        	 products[i]=val;
	        }
	        //insert into a stringbuilder.
	        StringBuilder sb = new StringBuilder();
	        for(int i:products) {
	        	sb.append(i);
	        }
	        //eliminate the leading zeroes.
	        while(sb.length()>0 && sb.charAt(0)=='0') {
	        	sb.deleteCharAt(0);
	        }
	        return sb.length()==0?"0":sb.toString();
	    }
}

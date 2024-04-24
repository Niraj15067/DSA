package com.example.demo.random;

public class PyramidPatter {

	    public static void main(String[] args) {
	        int row=5;
	        for(int j=1;j<=row;j++) {
	        	
	        	for(int i=1;i<=row-j;i++) {
		        	System.out.print(" ");
		        }
		        for(int k=1;k<=2*j-1;k++) {
		        	System.out.print("*");
		        }
		        System.out.println();
	        }
	    }
	}

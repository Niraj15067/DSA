package com.example.demo.random;

public class DecreasingTriangle {

	public static void main(String[] args) {
		for(int i=0;i<9;i++) {
			if(i<5) {
				for(int j=0;j<=i;j++) {
					System.out.print("*");
				}
				System.out.println();
			}
			else {
				for(int j=i;j<9;j++) {
					System.out.print("*");
				}
				System.out.println();
			}
		}

	}

}

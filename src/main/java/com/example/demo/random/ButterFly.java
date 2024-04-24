package com.example.demo.random;

public class ButterFly {

	public static void main(String[] args) {
		int n = 5;
		int spaceCount = (n-1)*2;
		for(int i=0;i<n;i++) {
			for(int j=0;j<=i;j++) {
				System.out.print("*");
			}
			for(int k=0;k<spaceCount && spaceCount>0;k++) {
				System.out.print(" ");
			}
			spaceCount -= 2;
			for(int j=0;j<=i;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		spaceCount = 2;
		for(int i=n-2;i>=0;i--) {
			for(int j = 0;j<=i;j++) {
				System.out.print("*");
			}
			for(int k=0;k<spaceCount;k++) {
				System.out.print(" ");
			}
			spaceCount += 2;
			for(int j = 0;j<=i;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}

package com.example.demo.random;

public class Pattern4 {
	public static void main(String[] args) {
		for (int i = 1; i < 6; i++) {
			int  k=0;
			int inc=4;
			k=i;
			for (int j = 0; j <= i-1; j++) {
				System.out.print(k + "\t");
				k+=inc;
				inc--;
			}
			System.out.println();
		}
	}
}

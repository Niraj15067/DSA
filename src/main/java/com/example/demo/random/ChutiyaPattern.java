package com.example.demo.random;

public class ChutiyaPattern {

	public static void main(String[] args) {
		for (int i = 1; i <= 25; i++) {
			for (int j = 1; j <= 25; j++) {
				if (j % 6 != 0) {
					System.out.printf("*");
				}
				System.out.print(" ");
			}
			System.out.println("\n");
		}

	}

}

package com.example.demo.stackandq;

import java.util.Scanner;

import linkedListAndTree.TwoStacks;

public class GameOfTwoStacks {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int game = sc.nextInt();
		int aCount = sc.nextInt();
		int bCount = sc.nextInt();
		int maxSum = sc.nextInt();
		int[] a = new int[aCount];
		int[] b = new int[bCount];

		for (int i = 0; i < aCount; i++) {
			a[i] = sc.nextInt();
		}
		for (int i = 0; i < bCount; i++) {
			b[i] = sc.nextInt();
		}
		sc.close();
		int score = TwoStacks.game(a, b, maxSum);
		System.out.println("Score is: "+ score);
	}
}

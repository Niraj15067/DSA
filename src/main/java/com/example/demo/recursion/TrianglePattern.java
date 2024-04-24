package com.example.demo.recursion;

public class TrianglePattern {

	public static void main(String[] args) {
		triangle(4, 0);
	}

	private static void triangle(int r, int c) {
		if (r == 0) {
			return;
		}
		if (c < r) {
			//if print is above the funtion call u get inverted triangle and vice versa
			triangle(r, c + 1);
			System.out.print("*");
		}
		if(c==r) {
			triangle(r-1,0);
			System.out.println();
		}

	}

}

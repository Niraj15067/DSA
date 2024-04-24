package com.example.demo.recursion;

public class NumberOfStepsToReduceToZero {

	public static void main(String[] args) {
		int val = 14;
		System.out.println(reduceToZero(val,0));

	}

//	private static int reduceToZero(int val) {
//		if(val==0) {
//			return 0;
//		}
//		if(val %2 == 0) {
//			return 1+reduceToZero(val/2);
//		}
//		return 1+reduceToZero(val-1);
//	}
	private static int reduceToZero(int val, int count) {
		if(val==0) {
			return count;
		}
		if(val %2 == 0) {
			return reduceToZero(val/2,count+1);
		}
		return reduceToZero(val-1,count+1);
	}

}

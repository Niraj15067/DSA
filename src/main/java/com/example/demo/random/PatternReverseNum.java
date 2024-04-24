package com.example.demo.random;

public class PatternReverseNum {

	public static void main(String[] args) {
		int k=15;
		for(int i=1;i<6;i++) {
			for(int j=1;j<=i && k>0;j++) {
				System.out.print(k+"\t");
				k--;
			}
			System.out.println();		
		}
	}

}

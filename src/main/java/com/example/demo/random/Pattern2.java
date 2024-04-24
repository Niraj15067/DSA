package com.example.demo.random;

public class Pattern2 {

	public static void main(String[] args) {
		int k=1;
		int ans = 0;
		for(int i=0;i<6;i++) {
			ans+=i+1;
			k=ans;
			for(int j=0; j<=i;j++) {
				System.out.print(k+"\t");
				k--;
			}
			System.out.println();
		}

	}
}

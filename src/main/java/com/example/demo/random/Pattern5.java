package com.example.demo.random;

public class Pattern5 {

	public static void main(String[] args) {
		int k=5;
		for(int i=1;i<6;i++) {
			int inc =5;
			int ans=k;
			for(int j=1;j<=i;j++) {
				System.out.print(ans+"\t");
				ans+=inc;
				inc--;
			}
			k--;
			System.out.println();
		}

	}

}

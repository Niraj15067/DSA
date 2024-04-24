package com.example.demo.random;

public class Pattern3 {

	public static void main(String[] args) {
		int k=15;
		int count =2, ans=k;
		
		for(int i=0;i<5;i++) {
			for(int j=0;j<=i;j++) {
				System.out.print(k + "\t");
				k++;
			}
			ans-=count;
			k=ans;
			count++;
			System.out.println();
		}

	}

}

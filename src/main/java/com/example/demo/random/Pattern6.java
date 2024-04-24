package com.example.demo.random;

public class Pattern6 {
	public static void main(String[] args) {
//		pattern6();
//		pattern7();
//		pattern8();
		pattern9();
//		pattern10();
	}

	private static void pattern6() {
		int k = 15;
		for (int i = 1; i < 6; i++) {
			int dec = 4;
			int ans = k;
			for (int j = 1; j <= i; j++) {
				System.out.print(ans + "\t");
				ans -= dec;
				dec--;
			}
			k--;
			System.out.println();

		}
	}
	private static void pattern7() {
		int k = 11;
		for (int i = 1; i < 6; i++) {
			int dec = 5;
			int ans = k;
			for (int j = 1; j <= i; j++) {
				System.out.print(ans + "\t");
				ans -= dec;
				dec--;
			}
			k++;
			System.out.println();

		}
	}
	private static void pattern8() {
		int k=1, inc=5, dec=4;
		for(int i=1;i<6;i++) {
			int ans=k;
			for(int j=1;j<=i;j++) {
				System.out.print(ans+"\t");
				ans-=dec;
				dec++;
			}
			System.out.println();
			k+=inc;
			inc--;
			dec=inc;
		}
	}
	private static void pattern9() {
		int k=5, inc=4, dec=5;
		for(int i=1;i<6;i++) {
			int ans=k;
			for(int j=1;j<=i;j++) {
				System.out.print(ans+"\t");
				ans-=dec;
				dec++;
			}
			System.out.println();
			k+=inc;
			dec=inc;
			inc--;	
		}
	}
	private static void pattern10() {
		int k=5, inc=4, dec=5;
		for(int i=1;i<6;i++) {
			int ans=k;
			for(int j=1;j<=i;j++) {
				System.out.print(ans+"\t");
				ans-=dec;
				dec++;
			}
			System.out.println();
			dec=inc+1;
			k+=inc;
			inc--;	
		}
	}
	
}

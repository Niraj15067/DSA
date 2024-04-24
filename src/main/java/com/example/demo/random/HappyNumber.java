package com.example.demo.random;

public class HappyNumber {

	public static void main(String[] args) {
		int n = 19;
		boolean ans = find(n);
		System.out.println(ans);
	}

	private static boolean find(int n) {
		int slow = n;
		int fast = n;
		do {
			slow = findSq(slow);
			fast = findSq(findSq(fast));
			if(slow==1 || fast==1) {
				return true;
			}
		}while(slow!=fast);
		return false;
	}

	private static int findSq(int n) {
		int ans = 0;
		while(n>0) {
			int rem = n%10;
			ans += rem*rem;
			n /=10;
		}
		return ans;
	}

	
}

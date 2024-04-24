package com.example.demo.string;

public class LengthOfLastWord {

	public static void main(String[] args) {

		String str = "Hello ";//for such cases we need to trim first.
		int ans = find(str);
		System.out.println(ans);
	}

	private static int find(String s) {
		String str = s.trim();
		int i = str.length()-1;
		int length = 0;
		while(i>=0 && str.charAt(i)!=' ') {
			i--;
			length++;
		}
		return length;
	}

}

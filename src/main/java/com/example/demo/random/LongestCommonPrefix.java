package com.example.demo.random;

public class LongestCommonPrefix {

	public static void main(String[] args) {
		String[] s = { "flower", "flow", "floight" };
		String ans = longestCommonPrefix(s);
		System.out.println(ans);
	}
	public static String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length == 0) {
			return "";
		}

		StringBuilder prefix = new StringBuilder(strs[0]);

		for(int i=1;i<strs.length;i++) {
			while(strs[i].indexOf(prefix.toString())!=0) {
				prefix.setLength(prefix.length()-1);
				if(prefix.length()==0)
					return "";
			}
		}
		return prefix.toString();
	}

}

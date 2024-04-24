package com.example.demo.random;

//optimal
public class FirstOccurence {

	public static void main(String[] args) {
		 String s = "mississippi";
		 int ans = strStr(s,"issip");
		 System.out.println(ans);

	}

	private static int strStr(String haystack, String needle) {
		for(int i=0;i<=haystack.length()-needle.length();i++) {
			if(haystack.charAt(i)==needle.charAt(0)) {
				boolean ans = isSubstring(haystack,i,needle);
				if(ans)
					return i;
			}
		}
 		return -1;
	}

	private static boolean isSubstring(String haystack, int i, String needle) {
		for(int k=i,j=0;j<needle.length();k++,j++) {
			if(haystack.charAt(k)!=needle.charAt(j)) {
				return false;
			}
		}
		return true;
	}

}

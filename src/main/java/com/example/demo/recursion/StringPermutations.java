package com.example.demo.recursion;

public class StringPermutations {

	public static void main(String[] args) {
		
		 permutations("abc","",0);

	}

	private static void permutations(String up, String p, int idx) {
		
		if(up.isEmpty()) {
			System.out.println(p);
			return;
		}
		char current = up.charAt(0);
		if(p.isEmpty()) {
			permutations(up.substring(1), p+current,idx);
		}
		
		permutations(up.substring(1),insertIntoProcessed(p.length(),current,p,idx), idx);
		permutations(up.substring(1),insertIntoProcessed(p.length(),current,p,idx), idx+1);
		
	}

	private static String insertIntoProcessed(int length, char current, String p, int idx) {
		StringBuilder sb = new StringBuilder(p);
		if(idx<=length)
			sb.insert(idx, current);
		return sb.toString();
	}

}

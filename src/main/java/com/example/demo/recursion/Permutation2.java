package com.example.demo.recursion;

public class Permutation2 {

	public static void main(String[] args) {
		generate("","abc");

	}

	private static void generate(String p, String up) {
		
 		if(up.isEmpty())
		{
			System.out.println(p);
			return;
		}
		
		for(int i=0;i<=p.length();i++) {
			String first = p.substring(0,i);
			String second = p.substring(i,p.length());
			
			generate(first+up.charAt(0)+second,up.substring(1));
		}
		
	}

}

package com.example.demo.recursion;

public class Permutation {

	public static void main(String[] args) {
		
 		generate("","abc");

	}

	private static void generate(String fixed, String remaining) {
		
		if(remaining.length()==1) {
			System.out.println(fixed+remaining);
			return;
		}
		
		for(int i=0;i<remaining.length();i++) {
			
			String newFixed = fixed+remaining.charAt(i);
			String newRemaining = remaining.substring(0,i)+remaining.substring(i+1);
 			generate(newFixed, newRemaining);
		}
	}

}

package com.example.demo.recursion;

public class Throw {

	public static void main(String[] args) {
		
		generate(4,"");

	}

	private static void generate(int target, String p) {
		
		if(target==0) {
			System.out.println(p);
			return;
		}
		
		for(int i=1;i<=target;i++) {
			if(i<=target) {
				String newP = p+i;
				generate(target-i,newP);
			}
		}
		
	}

}

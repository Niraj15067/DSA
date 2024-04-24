package com.example.demo;

import java.util.Scanner;

public class Fun {

	public static void main(String[] args) {
		 Scanner sc =new Scanner(System.in);
	      System.out.println("enter input: ");
	      String input = sc.nextLine();
	      String result=stringChallenge(input);
	      System.out.println(result);
	  }
	
	 public static String stringChallenge(String input){
	    	
	    	if (input.isEmpty()) {
	            return "";
	        }
	    	String words[]=input.split("\\s+");
	    	StringBuilder sb =new StringBuilder();
	    	int maxLength = 0;
	    	String longestWord = "";
	    	for(String s: words) {
	    		if(s.length()>maxLength) {
	    			maxLength = s.length();
	                longestWord = s;
	    		}else if (s.length() == maxLength && longestWord.isEmpty()) {
	                longestWord = s;
	    		}
	    	}
	    	return longestWord;
	 }
}

package com.example.demo.search;

import java.util.*;

public class Encode {
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
    	
	    StringBuilder sb = new StringBuilder();
	    int occurence =1;
	    char currentChar= input.charAt(0);
	    for(int  i=1;i<input.length();i++)
	    {	      
	      if(input.charAt(i)==currentChar)
	      {
	        occurence++;
	      }
	      else{
	        sb.append(occurence).append(currentChar);
	        occurence=1;
	        currentChar=input.charAt(i);
	      }
	    }
	    sb.append(occurence).append(currentChar);
	    return sb.toString();
	  }
  
}
package com.example.demo.string;

//https://leetcode.com/problems/roman-to-integer/submissions/1035776494/
public class RomanToInt {

	public static void main(String[] args) {
		int romanToInt = romanToInt("L");
		System.out.println(romanToInt);
	}
	 public static int romanToInt(String s) {
	        int intval=0;
	        for(int i=0;i<s.length();i++){
	           if(s.charAt(i)=='I')
	                intval+=1;
	            else if(i>0 && s.charAt(i-1)=='I' && (s.charAt(i)=='V' || s.charAt(i)=='X')){
	                intval-=1;
	                intval+=(s.charAt(i)=='V')?4:9;
	            }
	            else if(s.charAt(i)=='X')
	                intval+=10;
	            else if(s.charAt(i)=='V')
	                intval+=5;
	            else if(i>0 && s.charAt(i-1)=='X' &&(s.charAt(i)=='L' || s.charAt(i)=='C')){
	                intval-=10;
	                intval+=(s.charAt(i)=='L')?40:90;
	            }
	            else if(s.charAt(i)=='L')
	                intval+=50;
	            else if(s.charAt(i)=='C')
	                intval+=100;
	            else if(i>0 && s.charAt(i-1)=='C' && (s.charAt(i)=='D' || s.charAt(i)=='M')){
	                intval-=100;
	                intval+=(s.charAt(i)=='D')?400:900;
	            }
	            else if(s.charAt(i)=='D')
	                intval+=500;
	            else if(s.charAt(i)=='M')
	                intval+=1000;
	        }
	        return intval;
	    }
}

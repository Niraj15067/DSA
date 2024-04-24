package com.example.demo.string;

//https://leetcode.com/problems/integer-to-roman/description/
public class IntegerToRoman {

	public static void main(String[] args) {
		String intToRoman = intToRoman(234);
		System.out.println(intToRoman);
	}
	public static String intToRoman(int n) {
        String[] symbol = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int[] value = {1000,900,500,400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

        int i = 0;
        StringBuilder sb = new StringBuilder();
        for( i=0; n!= 0; i++){
            while(n >= value[i]){
                n -= value[i];
                sb.append(symbol[i]);
            }
        }
        return sb.toString();
    }
}

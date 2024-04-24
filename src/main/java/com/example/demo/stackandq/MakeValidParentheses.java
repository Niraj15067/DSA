package com.example.demo.stackandq;

import java.util.Stack;

public class MakeValidParentheses {

	public static void main(String[] args) {
		String str = "(((";
		int count = minAddToMakeValid(str);
		System.out.println(count);
	}

	public static int minAddToMakeValid(String s) {
		Stack<Character> brackets = new Stack<>();
		for(char c : s.toCharArray()) {
			if(c==')') {
				if(!brackets.isEmpty() && brackets.peek()=='(') {
					brackets.pop();
				}else {
					brackets.push(c);
				}
			}else {
				brackets.push(c);
			}
		}
		return brackets.size();
	}

}

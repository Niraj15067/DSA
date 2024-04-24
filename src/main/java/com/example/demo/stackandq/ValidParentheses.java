package com.example.demo.stackandq;

import java.util.Stack;

public class ValidParentheses {

	public static void main(String[] args) {
		String s = "()";
		boolean ans = validParenthesis(s);
		System.out.println(ans);
	}

	private static boolean validParenthesis(String s) {
		Stack<Character> brackets = new Stack<>();
		for(char c: s.toCharArray()) {
			if(c=='(' || c=='[' || c=='{') {
				brackets.push(c);
			}
			else if(!brackets.isEmpty() && brackets.peek()=='[' && c==']') {
				brackets.pop();
			}
			else if(!brackets.isEmpty() && brackets.peek()=='{' && c=='}') {
				brackets.pop();
			}
			else if(!brackets.isEmpty() && brackets.peek()=='(' && c==')') {
				brackets.pop();
			}
		}
		
		return brackets.isEmpty();
	}

}

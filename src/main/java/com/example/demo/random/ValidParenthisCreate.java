package com.example.demo.random;

import java.util.Stack;

public class ValidParenthisCreate {

	public static void main(String[] args) {
		String s = "))())("; // ()) ))) ())) ((( )((( ())))     
//		int count = find(s);
		int count = find2(s);
		System.out.println(count);// op = close =
	}

	private static int find(String s) {
		Stack<Integer> stack = new Stack<>();
		int ans = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '(') {
				if (stack.isEmpty() || stack.peek() == 2) {
					stack.push(2);
				} else {
					if (stack.peek() == 1) {
						stack.pop();
						ans += 1;
						stack.push(2);
					}
				}
			} else {
				if (stack.isEmpty()) {
					ans += 1;
					stack.push(1);
				} else if (stack.peek() == 2) {
					stack.pop();
					stack.push(1);
				} else if (stack.peek() == 1) {
					stack.pop();
				}
			}
		}
		while (!stack.isEmpty()) {
			ans += stack.pop();
		}
		return ans;
	}
	public static int find2(String s) {
		int open = 0,close= 0, ans = 0; 
		for(int i=0;i<s.length();i++) {
			char c = s.charAt(i);
			if(c=='(') {
				open++;
			}else {
				//cancel out if two opening available
				if(i+1<s.length() && s.charAt(i+1)==')') {
					//two closing available to cancel out.
					//but check if we have open available to cancel out.
					if(open>0) {
						open--;
					}
					else {
						//2 close available but no open to close this.
						ans += 1;   //need one open to balance out
					}
					i+=1;//we have checked 2 closed at once here so skip the next one.
					//we dont have a closing followed by another closing.
				}else {
					if(open>0) {
						ans += 1;//have open already and one close need one more close to bal out.
						open--; // we have balanced the closing for this open so remove it as well.
					}else {
						//no opening and no closing followed by this closing so we need 2 brackets for this.
						ans += 2;
					}
				}
			}
		}
		return ans+open*2;
	}
}

package com.example.demo.stackandq;

import java.util.Stack;

public class MinimumInsertionsToBalanceAParenth {

	public static void main(String[] args) {
		String str = ")(";
		int ans = minInsertions(str);
		System.out.println(ans);
	}

	// using 1 and 2 approach for closing and opening.
	public static int minInsertions(String s) {
		int ans = 0;
		Stack<Integer> stack = new Stack<>();
		for(int i = 0; i<s.length();i++) {
			char c = s.charAt(i);
			if(c=='(') {
				if(stack.isEmpty() || stack.peek()==2) {
					stack.push(2);
				}else {
					ans++;//opening was already provided below but we assumed the next might be ) so
						//that might give it the closing for that but this wasn't the case so provide
						//the closing here and then remove it.
					stack.pop();
					stack.push(2);
				}
			}else {
				if(stack.isEmpty()) {
					stack.push(1);
					ans++; //stack is empty and we have closing so just provide the opening for this
				}else if(stack.peek()==1) {
					stack.pop();
				}else if(stack.peek()==2) {
					stack.pop();
					stack.push(1);
				}
			}
		}
		while(!stack.isEmpty()) {
			ans += stack.pop();
		}
		return ans;
	}

	public static int minInsertionsCount(String s) {
		int open = 0;
		int ans = 0;
		for(int i=0;i<s.length();i++) {
			char c = s.charAt(i);
			if(c=='(') {
				open++;
			}else {
				//current is closing and check if next is closing as well if y then cancel out.
				if(i+1<s.length()&&s.charAt(i+1)==')') {
					//to cancel out first check if open is available for this or not.
					if(open>0) {
						open--;
					}else {
						//encountered 2 closing and no open available so add one open brace in ans
						ans += 1;
					}
					i++;//we are checking 2 at a time here so skip i+1 for the next loop.
				}else {
					//current is closing but next is not closing and we have open before this
					if(open>0) {
						ans++; //add one closing for this to ans and we have cancel out the prev open
						open--; // so reduce the open count by 1.
					}else {
						//no open available and obv next is not closing so we need 2 braces
						// i.e one for closing and one for open.
						ans += 2;
					}
				}
			}
		}

		return ans+open*2;
	}
}

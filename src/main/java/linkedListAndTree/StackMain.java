package linkedListAndTree;

import java.util.Queue;
import java.util.Stack;

public class StackMain {

	public static void main(String[] args) throws StackException {
//		CustomStack stack = new CustomStack();
//		stack.push(10);
//		stack.push(20);
//		System.out.println(stack.pop());
//		System.out.println(stack.pop());
		
		QueueUsingStackRemoveEfficient q = new QueueUsingStackRemoveEfficient();
		q.push(10);
		q.push(20);
		System.out.println(q.pop());
		System.out.println(q.empty());
	}

}

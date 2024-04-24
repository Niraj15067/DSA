package linkedListAndTree;

import java.util.Stack;

//this is insert efficient queue using stack where insert takes O(1) and removal takes O(n)
//remove efficient can be made using deque.
public class QueueUsingStack {
	Stack<Integer> deque1;
	Stack<Integer> deque2;

	public QueueUsingStack() {
		deque1 = new Stack<>();
		deque2 = new Stack<>();
	}

	public void push(int x) {
		deque1.push(x);
	}

	public int pop() {
		int size = deque1.size();
		for (int i = 0; i < size; i++) {
			deque2.push(deque1.pop());
		}
		int removed = deque2.pop();
		size = deque2.size();
		for (int i = 0; i < size; i++) {
			deque1.push(deque2.pop());
		}
		return removed;
	}

	public int peek() {
		int size = deque1.size();
		for (int i = 0; i < size; i++) {
			deque2.push(deque1.pop());
		}
		int val = deque2.peek();
		for (int i = 0; i < size; i++) {
			deque1.push(deque2.pop());
		}
		return val;
	}

	public boolean empty() {
		return deque1.isEmpty();
	}
}

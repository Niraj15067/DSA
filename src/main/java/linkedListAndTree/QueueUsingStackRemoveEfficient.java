 package linkedListAndTree;

import java.util.ArrayDeque;
import java.util.Deque;

//this is remove efficient queue using stack where remove takes O(1) and insertion takes O(n)
//insert efficient can be made using stack.
public class QueueUsingStackRemoveEfficient {
	Deque<Integer> deque1;
	Deque<Integer> deque2;

	public QueueUsingStackRemoveEfficient() {
		deque1 = new ArrayDeque<>();
		deque2 = new ArrayDeque<>();
	}

	public void push(int x) {
		while(!deque1.isEmpty()) {
			deque2.push(deque1.pop());
		}
		deque2.push(x);
		while(!deque2.isEmpty()) {
			deque1.push(deque2.pop());
		}
	}

	public int pop() {
		return deque1.pop();
	}

	public int peek() {
		return deque1.peek();
	}

	public boolean empty() {
		return deque1.isEmpty();
	}
}

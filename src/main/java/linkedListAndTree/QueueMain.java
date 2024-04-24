package linkedListAndTree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class QueueMain {

	public static void main(String[] args) throws Exception {
//		CircularQueue q = new DynamicQueue(5);
//		((DynamicQueue) q).insert(10);
//		((DynamicQueue) q).insert(100);
//		((DynamicQueue) q).insert(20);
//		((DynamicQueue) q).insert(30);
//		((DynamicQueue) q).insert(40);
//		((DynamicQueue) q).insert(50);
//		((DynamicQueue) q).insert(60);
//		((DynamicQueue) q).insert(70);
//		((DynamicQueue) q).insert(80);
//		((DynamicQueue) q).insert(90);
//		((DynamicQueue) q).display();
		
		Deque<Integer> deque = new ArrayDeque<>();
		deque.push(10);
		deque.push(50);
		deque.push(40);
		deque.push(30);
		deque.push(20);
		for(int i:deque) {
			System.out.println(i);
		}
		deque.isEmpty();
	}
}

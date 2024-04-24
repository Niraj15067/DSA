package linkedListAndTree;

import java.util.Stack;

public class CustomStack {

	protected int[] data;
	private final static int DEFAULT_SIZE = 10;
	int ptr = -1;

	public CustomStack() {
		this(DEFAULT_SIZE);
	}

	public CustomStack(int size) {
		data = new int[size];
	}

	public int push(int val) throws StackException {
		if (isFull()) {
			throw new StackException("Stack is full !!");
		}
		ptr++;
		data[ptr] = val;
		return val;
	}

	public int pop() throws StackException {
		if (isEmpty())
			throw new StackException("Can't perform pop on an empty stack!!");
//		ptr--;
//		return data[ptr++];
		return data[ptr--];
	}

	public int peek() throws StackException {
		if (ptr == -1)
			throw new StackException("Stack is Empty !!");
		return data[ptr];
	}

	protected boolean isFull() {
		return ptr == data.length - 1;
	}

	private boolean isEmpty() {
		return ptr == -1;
	}
}

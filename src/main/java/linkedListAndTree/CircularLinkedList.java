package linkedListAndTree;

//this is double ended circular linked list we can do single as well
public class CircularLinkedList {

	private Node head;
	private Node tail;
	private int size;

	public CircularLinkedList() {
		this.head = null;
		this.tail = null;
	}

	public void insertLast(int val) {
		Node node = new Node(val);
		if (tail == null) {
			head = node;
			tail = node;
		} else {
			tail.next = node;
			node.next = head;
			tail = node;
		}
		size++;
	}

	public void display() {
		if (head != null) {
			Node temp = head;
			do {
				System.out.print(temp.value + "-->");
				temp = temp.next;
			} while (temp != head);
			System.out.println("HEAD");
		}
	}

	public void delete(int val) {
		Node temp = head;
		if (head == null) {
			return;
		}
		if (head.value == val) {
			head = head.next;
			tail.next = head;
		}
		while (temp.next != head) {
			if (temp.next.value == val) {
				temp.next = temp.next.next;
			}
			temp = temp.next;
		}
	}
	public boolean isCyclePresent() {
		Node slow = head;
		Node fast = head;
		while(fast!=null && fast.next!=null) {
			slow=slow.next;
			fast=fast.next.next;
			if(slow==fast) {
				System.out.println(slow.value);
				return true;
			}
		}
		return false;
	}
	
	public int lengthOfCycle() {
		Node fast = head;
		Node slow = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (fast == slow) {
				int len=0;
				do {
					slow=slow.next;
					len++;
				}while(slow!=fast);
				return len;
			}
		}
		return 0;
	}
	public int findStart() {
		int len=0;
		if(isCyclePresent()) {
			len = lengthOfCycle();
			Node f = head;
			Node s = head;
			while(len>0) {
				f=f.next;
				len--;
			}
			while(f!=s) {
				f=f.next;
				s=s.next;
			}
			return s.value;
		}
		return 0;
	}

	private class Node {
		private int value;
		private Node next;
		private Node prev;

		Node(int value) {
			this.value = value;
		}

		Node(int value, Node next) {
			this.value = value;
			this.next = next;
		}

		Node(int value, Node next, Node prev) {
			this.value = value;
			this.next = next;
			this.prev = prev;
		}
	}
}

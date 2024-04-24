package linkedListAndTree;

public class DoublyLinkedList {

	private Node head;
	private Node tail;
	private int size;

	public void insertFirst(int val) {
		Node node = new Node(val);
		node.next = head;
		node.prev = null;
		if (head != null) {
			head.prev = node;
		}
		head = node;
		if (tail == null) {
			tail = head;
		}
		size += 1;
	}

	public int size() {
		return size;
	}
	public void insertLast(int val) {

		if (tail == null) {
			insertFirst(val);
			return;
		}
		Node node = new Node(val);
		tail.next = node;
		node.prev = tail;
		tail = node;
		size++;
	}
	
	public void insertAt(int value, int index) {
		if(index==0) {
			insertFirst(value);
			return;
		}
		if(index==size) {
			insertLast(value);
			return;
		}
		int len = 1;
		Node temp = head;
		while(len<index) {
			temp=temp.next;
			len++;  
		}
		System.out.println(temp.value);
		Node node = new Node(value, temp.next);
		temp.next = node;
		node.prev = temp;
		node.next.prev=node;
		size++;
	}
	
	public void insertWithoutTail(int val) {
		Node node = new Node(val);
		if(head==null) {
			head = node;
			tail = node;
			return;
		}
		Node temp = head;
		
		//not required the below line for sure i guess.
		node.next=null;
		if(head==null) {
			node.prev=null;
			head=node;
			return;
		}
		while(temp.next!=null) {
			temp=temp.next;
		}
		temp.next = node;
		node.prev = temp;
		tail = node;
		size++;
	}

	public void display() {
		Node node = head;
		while (node != null) {
			System.out.print(node.value + "-->");
			node = node.next;
		}
		System.out.print("END");
	}

	public void displayReverse() {
		Node last = tail;
		while (last != null) {
			System.out.print(last.value + "-->");
			last = last.prev;
		}
		System.out.print("END");
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

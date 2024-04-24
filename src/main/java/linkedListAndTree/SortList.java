package linkedListAndTree;

public class SortList {
	
	public static void main(String[] args) {
		SinglyLinkedList ll = new SinglyLinkedList();
		ll.insertFirst(3);
		ll.insertFirst(1);
		ll.insertFirst(2);
		ll.insertFirst(4);
		
		ll.display();
		System.out.println();
		
		// Get the sorted head
		SinglyLinkedList.Node sortedHead = ll.sortList(ll.head);
		
		// Create a new linked list with the sorted head
		SinglyLinkedList sortedList = new SinglyLinkedList();
		sortedList.head = sortedHead;
		
		sortedList.display();
	}
}

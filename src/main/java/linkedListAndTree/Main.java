package linkedListAndTree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
//		SinglyLinkedList ll = new SinglyLinkedList();
//		ll.insertFirst(3);
//		ll.insertFirst(13);
//		ll.insertFirst(15);
//		ll.insertFirst(16);
//		ll.insertAtGivenIndex(17, 4);//0 based index over here
//		ll.delete(1);//0 based
//		ll.display();
//		System.out.println(ll.delete(2)); //not 0 based
//		ll.display();
//		Object obj = ll.find(16);
//		System.out.println(obj);
		
//		DoublyLinkedList dll = new DoublyLinkedList();
//		dll.insertFirst(66);
//		dll.insertWithoutTail(89);
//		dll.insertLast(90);
//		dll.insertFirst(10);
//		dll.insertFirst(23);
//		dll.display();
//		System.out.println();
//		dll.insertAt(2, 1);
//		dll.display();
//		dll.displayReverse();
		

//		CircularLinkedList cll = new CircularLinkedList();
//		cll.insertLast(10);
//		cll.insertLast(20);
//		cll.insertLast(30);
//		cll.insertLast(40);
//		cll.display();
//		cll.delete(20);
//		cll.display();
		
		
//		SinglyLinkedList ll = new SinglyLinkedList(); 
//		ll.insertFirst(2);
//		ll.insertFirst(1);
//		ll.display();
//		System.out.println();
//		ll.reOrderList();
//		ll.revKGroupsAlternative(2);
// 		ll.rotateRight(1);
//		ll.display();
//		ll.reverse(ll.head)
//		ll.inPlaceReverse();
//		ll.reverseFrom(2, 4);
//		ll.display();
		
//		SinglyLinkedList ll1 = new SinglyLinkedList();
//		ll1.insertFirst(4);
//		ll1.insertFirst(2);
//		ll1.insertFirst(1);
//		ll1.display();
//		
//		SinglyLinkedList merged = new SinglyLinkedList();
//		merged.merge(ll, ll1);
//		ll.removeDuplicate();
//		merged.display();
		
		
//		CircularLinkedList cll = new CircularLinkedList();
//		cll.insertLast(10);
//		cll.insertLast(20);
//		cll.insertLast(30);
//		cll.insertLast(40);
//		cll.insertLast(50);
//		System.out.println(cll.isCyclePresent());
//		System.out.println();
//		System.out.println("length of the cycle is: "+cll.lengthOfCycle());
//		System.out.println("Cycle starts from: "+ cll.findStart());
		
		SinglyLinkedList l = new SinglyLinkedList();
		l.insertLast(1);
		l.insertLast(2);
		l.insertLast(3);
		l.insertLast(4);
		l.insertLast(5);
		l.insertLast(6);
		l.insertLast(7);
//		l.display();
//		l.rotateRight(2);
		l.display();
		l.rkg(3);
		l.display();
	}

}

package com.example.demo.sort;

import java.util.Arrays;

import linkedListAndTree.SinglyLinkedList;
import linkedListAndTree.SinglyLinkedList.Node;

public class Bbsort {
	
	public static void main(String[] args) {
		SinglyLinkedList ll = new SinglyLinkedList();
		ll.insertLast(4);
		ll.insertLast(3);
		ll.insertLast(1);
		ll.insertLast(2);
		ll.insertLast(9);
		ll.insertLast(6);
		ll.display();
		System.out.println();
		sort(ll.getSize(), 0, ll);
		ll.display();
	}

	private static void sort(int r, int c, SinglyLinkedList l) {
		if(r==0) {
			return;
		}
		if(c<r) {
			Node first = l.get(c);
			Node second = l.get(c+1);
			
			if(first.value>second.value) {
				if(first==l.head) {
					l.head = second;
					first.next = second.next;
					second.next = first;
				}else if(second==l.tail) {
					Node prev = l.get(c-1);
					l.tail = first;
					first.next = null;
					prev.next = second;
					second.next = l.tail;
				}else {
					Node prev = l.get(c-1);
					prev.next = second;
					first.next = second.next;
					second.next = first;
				}
			}
			sort(r,c+1,l);
		}else
			sort(r-1,0,l);
	}
}

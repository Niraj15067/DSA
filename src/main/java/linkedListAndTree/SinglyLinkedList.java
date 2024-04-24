package linkedListAndTree;

public class SinglyLinkedList {

	public Node head;
	public Node tail;
	private int size;

	public void insertFirst(int val) {
		Node node = new Node(val);
		node.next = head;
		head = node;
		if (tail == null) {
			tail = head;
		}
		size += 1;
	}

	public int getSize() {
		return size;
	}

	public void insertAtGivenIndex(int val, int index) {
		if (index == 0) {
			this.insertFirst(val);
		}
		if (index == size) {
			this.insertLast(val);
			return;
		}
		int len = 1;
		Node tempH = head;
		// do index - 1 if you wanna implement a 1 based start index or remove -1
		// if u want a 0 based index.
		while (len < index) {
			tempH = tempH.next;
			len++;
		}
		Node node = new Node(val, tempH.next);
		tempH.next = node;
		size++;
	}

	public void insertUsingRecursion(int val, int index) {
		head = insertR(val, index, head);
	}

	private Node insertR(int val, int index, Node node) {
		if (index == 0) {
			Node insert = new Node(val, node);
			size++;
			return insert;
		}
		node.next = insertR(val, --index, node.next);
		return node;
	}

	public void insertLastWithoutTail(int val) {
		if (head == null) {
			this.insertFirst(val);
		}
		Node node = new Node(val);
		Node temp = head;
		int len = 1;
		while (len < size) {
			temp = temp.next;
			len++;
		}
		temp.next = node;
		tail = node;
		size++;
	}

	public void insertLast(int val) {
		if (tail == null) {
			this.insertFirst(val);
			return;
		}
		Node node = new Node(val);
		tail.next = node;
		tail = node;

		if (head == null) {
			head = tail;
		}
		size += 1;
	}

	public void removeDuplicate() {
		Node temp = head;
		while (temp.next != null) {
			if (temp.value == temp.next.value) {
				temp.next = temp.next.next;
				size--;
			} else {
				temp = temp.next;
			}
		}
		tail = temp;
		tail.next = null;
	}

	public void display() {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.value + "-->");
			temp = temp.next;
		}
		System.out.println("END");
	}

	public void display(Node h) {
		Node p = h;
		while (p != null) {
			System.out.print(p.value + "-->");
		}
		System.out.print("END");
	}

	public SinglyLinkedList() {
		this.size = 0;
	}

	public int deleteFirst() {
		int val = head.value;
		head = head.next;
		if (head == null) {
			tail = null;
		}
		size--;
		return val;
	}

	public int deleteLast() {
		if (size <= 1) {
			return deleteFirst();
		}
		Node temp = get(size);
		System.out.println(temp.value);
		int val = temp.value;
		tail = temp;
		tail.next = null;
		size--;
		return val;
	}

	public Node get(int index) {
		Node node = head;
		for (int i = 1; i < index; i++) {
			node = node.next;
		}
		return node;
	}

	public int delete(int index) {
		if (index == 0) {
			return deleteFirst();
		}
		if (index == size - 1) {
			return deleteLast();
		}
		Node prevDelete = get(index);
		System.out.println(prevDelete.value);
		int val = prevDelete.next.value;
		prevDelete.next = prevDelete.next.next;
		size--;
		return val;
	}

	public Node find(int value) {
		Node node = head;
		while (node != null) {
			if (node.value == value) {
				return node;
			}
			node = node.next;
		}
		return null;
	}

	public class Node {
		public int value;
		public Node next;

		public Node(int value) {
			this.value = value;
		}

		public Node(int value, Node next) {
			this.value = value;
			this.next = next;
		}

		@Override
		public String toString() {
			return "Node [value=" + value + ", next=" + next + "]";
		}
	}

	// codes
//	public Node merge(SinglyLinkedList head1, SinglyLinkedList head2) {
//		Node dummy = new Node(0);
//		head =dummy;
//        Node current = head;
//        Node list1 = head1.head;
//        Node list2 = head2.head;
//
//        while (list1 != null && list2 != null) {
//            if (list1.value <= list2.value) {
//                current.next = list1;
//                list1 = list1.next;
//            } else {
//                current.next = list2;
//                list2 = list2.next;
//            }
//            current = current.next;
//        }
//
//        // If one list is not empty, link the remaining nodes
//        if (list1 != null) {
//            current.next = list1;
//        } else if (list2 != null) {
//            current.next = list2;
//        }
//
//        return head.next;
//	}
	public Node sortList(Node head) {
		if (head == null || head.next == null) {
			return head;
		}

		Node mid = findMid(head);
		Node left = head;
		Node right = mid.next;
		mid.next = null; // Break the link to split the list into two halves

		left = sortList(left);
		right = sortList(right);

		return merge(left, right);
	}

	public Node findMid(Node head) {
		Node slow = head;
		Node fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

	public Node merge(Node l1, Node l2) {
		Node dummy = new Node(0);
		Node current = dummy;

		while (l1 != null && l2 != null) {
			if (l1.value <= l2.value) {
				current.next = l1;
				l1 = l1.next;
			} else {
				current.next = l2;
				l2 = l2.next;
			}
			current = current.next;
		}

		if (l1 != null) {
			current.next = l1;
		} else if (l2 != null) {
			current.next = l2;
		}

		return dummy.next;
	}

	// reverse using recursion.
	public void reverse(Node node) {
		if (node == tail) {
			head = tail;
			return;
		}
		while (node.next != null) {
			reverse(node.next);
			tail.next = node;
			tail = node;
			tail.next = null;
		}
	}

	public void inPlaceReverse() {
		if (size < 2) {
			return;
		}
		Node prev = null;
		Node present = head;
		Node next = present.next;

		while (present != null) {
			present.next = prev;
			prev = present;
			present = next;
			if (next != null)
				next = next.next;
		}
		head = prev;
	}

	public void reOrderList() {
		Node slow = head;
		Node fast = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		// reversing the list from prev
		Node p = null, c = slow, next = c.next;
		while (c != null) {
			c.next = p;
			p = c;
			c = next;
			if (next != null) {
				next = next.next;
			}
		}
		Node hf = head;
		Node hs = p;
		while (hf != null && hs != null) {
			Node temp = hf.next;
			hf.next = hs;
			hf = temp;

			temp = hs.next;
			hs.next = hf;
			hs = temp;
		}
		if (hf != null) {
			hf.next = null;
		}
	}

	public void reverseFrom(int left, int right) {
		if (left == right) {
			return;
		}
		Node prev = null;
		Node current = head;
		for (int i = 1; i < left; i++) {
			prev = current;
			current = current.next;
		}
		Node last = prev;
		Node newEnd = current;
		Node next = current.next;
		for (int i = 0; current != null && i <= right - left; i++) {
			current.next = prev;
			prev = current;
			current = next;
			if (next != null) {
				next = next.next;
			}
		}
		if (last != null) {
			last.next = prev;
		} else {
			head.next = prev;
		}
		newEnd.next = current;
	}

	public void revKGroups(int k) {
		
		if(k<=1 || head==null) {
			return;
		}
		Node itr = head;
		int length = 0;
		while(itr!=null) {
			itr = itr.next;
			length++;
		}
		Node prev = null;
		Node current = head;
		int count = 0;
		while (count<length/k) {
			Node last = prev;
			Node newEnd = current;
			Node next = current.next;
			prev = null; //at the start of new reverse we need prev null.
			for (int i = 0; current != null && i < k; i++) {
				current.next = prev;
				prev = current;
				current = next;
				if (next != null) {
					next = next.next;
				}
			}
			if (last != null) {
				last.next = prev;
			} else {
				head = prev;
			}
			newEnd.next = current;
			if(current==null) {
				break;
			}
			prev = newEnd;
		}
	}

	public void revKGroupsAlternative(int k) {
		if (k <= 1 || head == null) {
			return;
		}
		int length = 0;
		Node itr = head;
		while (itr != null) {
			itr = itr.next;
			length++;
		}
		int count = 0;
		Node prev = null, c = head;
		while (count < (length / k)) {
			Node last = prev;
			Node newEnd = c;
			Node next = c.next;
			prev = null;
			//another way to do this is to after each reversal just traverse the prev, c, and
			//next pointer for k times so that we are on the next reverse part again.
			if(count%2==0) {
				for (int i = 0; c != null && i < k; i++) {
					c.next = prev;
					prev = c;
					c = next;
					if (next != null) {
						next = next.next;
					}
				}
				if (last != null) {
					last.next = prev;
				} else {
					head = prev;
				}
				newEnd.next = c;
				prev = newEnd;
			}else {
				for(int i=0;c!=null && i<k;i++) {
					prev = c;
					c = next;
					if(next!=null) {
						next=next.next;
					}
				}
			}
			if (c == null) {
				break;
			}
			count++;
		}
	}
	
	public void rotateRight(int k) {
 		Node itr = head;
		int len = 1;
		while(itr.next!=null) {
			itr = itr.next;
			len++;
		}
		int count = len - (k%len);
		Node end = head;
		while(end.next!=null && count-1>0) {
			end = end.next;
			count--;
		}
		Node newHead = end.next;
		end.next = null;
		itr.next = head;
		head = newHead;
	}
	public void rkg(int k) {
		//need length to determine how many k groups to rotate
		int len = 0;
		Node itr = head;
		while(itr!=null) {
			len++;
			itr = itr.next;
		}
		int count = 0;
		Node prev = null;
		Node current = head;
		Node next = current.next;
		while(count < len/k) {
			Node prevHead = current;
			Node last = prev;
			prev = null;
			
			for(int i=0; current!=null && i<k; i++) {
				current.next = prev;
				prev = current;
				current = next;
				if(next.next!=null) {
					next = next.next;
				}
			}
			if(last!=null) {
				last.next = prev;
			}else {
				head = prev;
			}
			if(current==null) {
				break;
			}
			if(prevHead!=null) {
				prevHead.next = current;
			}
			prev = prevHead;
			count++;
		}
	}
	public Node addTwoNumbers(Node l1, Node l2) {
		Node dummy = new Node(0);
		Node head = dummy;
	     int carry = 0;
	     while(l1!=null || l2!=null || carry!=0){
	         int sum = 0;
	         if(l1!=null){
	             sum += l1.value;
	             l1 = l1.next;
	         }
	         if(l2!=null){
	             sum += l2.value;
	             l2 = l2.next;
	         }
	         sum += carry;
	         carry = sum/10;
	         Node node = new Node(sum%10);
	         dummy.next = node;
	         dummy = dummy.next;
	     }
	     return head.next;
	    }
}

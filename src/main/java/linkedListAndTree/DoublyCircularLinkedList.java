package linkedListAndTree;

public class DoublyCircularLinkedList {

    private Node head;
    private int size;

    public void insertFirst(int val) {
        Node node = new Node(val);
        if (head == null) {
            head = node;
            head.next = head;
            head.prev = head;
        } else {
            node.next = head;
            node.prev = head.prev;
            head.prev.next = node;
            head.prev = node;
            head = node;
        }
        size++;
    }

    public void display() {
        Node temp = head;
        if (head != null) {
            do {
                System.out.print(temp.value + "-->");
                temp = temp.next;
            } while (temp != head);
            System.out.println("END");
        }
    }

    public void displayReverse() {
        Node temp = head.prev;
        if (head != null) {
            do {
                System.out.print(temp.value + "-->");
                temp = temp.prev;
            } while (temp != head.prev);
            System.out.println("END");
        }
    }

    private static class Node {
        private int value;
        private Node next;
        private Node prev;

        Node(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        DoublyCircularLinkedList list = new DoublyCircularLinkedList();
        list.insertFirst(10);
        list.insertFirst(15);
        list.insertFirst(20);
        list.insertFirst(25);

        System.out.println("Original Order:");
        list.display();

        System.out.println("Reverse Order:");
        list.displayReverse();
    }
}

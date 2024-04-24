package linkedListAndTree;

import java.util.Scanner;

public class BinaryTree {

	private Node root;

	BinaryTree() {

	}

	private class Node {
		int value;
		Node left;
		Node right;

		Node(int value) {
			this.value = value;
		}
	}

	// insert elements
	public void populate(Scanner sc) {
		System.out.println("Enter the root node: ");
		int value = sc.nextInt();
		root = new Node(value);
		populate(sc, root);
	}

	private void populate(Scanner sc, Node node) {

		System.out.println("Do you want to enter left of: " + node.value);
		boolean left = sc.nextBoolean();
		if (left) {
			System.out.println("Enter the value for left of: " + node.value);
			int value = sc.nextInt();
			node.left = new Node(value);
			populate(sc, node.left);
		}

		System.out.println("Do you want to insert in the right of: " + node.value);
		boolean right = sc.nextBoolean();
		if (right) {
			System.out.println("Enter the value to insert to the right of: " + node.value);
			int value = sc.nextInt();
			node.right = new Node(value);
			populate(sc, node.right);
		}

	}

	public void display() {
//		display(root, "",false);
		display(root,0);
	}

	private void display(Node node, String indent, boolean isLeft) {
        if (node == null) {
            return;
        }

      System.out.println(indent + (isLeft ? "L--- " : "R--- ") + node.value);
      display(node.left, indent + (isLeft ? "\t" : "|\t"), true);
      display(node.right, indent + (isLeft ? "\t" : "|\t"), false);
    }
	private void display(Node node, int level) {
        if (node == null) {
            return;
        }
        
        display(node.right,level+1);
        if(level>0) {
        	for(int i=0;i<level-1;i++) {
            	System.out.print("\t");
            }
            System.out.println("----->"+node.value);
        }else {
        	System.out.println(node.value);
        }
        display(node.left,level+1);
    }

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BinaryTree bt = new BinaryTree();
		bt.populate(sc);
		bt.display();
	}
}

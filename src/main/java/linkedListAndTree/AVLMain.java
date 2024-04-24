package linkedListAndTree;

import java.util.Stack;

public class AVLMain {

	public static void main(String[] args) {
		AVL avl = new AVL();
		for(int i=1;i<1000;i++) {
			avl.insert(i);
		}
		avl.display();
		System.out.println(avl.height());
	}
}

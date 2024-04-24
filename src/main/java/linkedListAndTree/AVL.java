package linkedListAndTree;

public class AVL {

	private Node root;

	public AVL() {

	}

	private class Node {

		private int value;
		private Node left;
		private Node right;
		private int height;

		Node(int value) {
			this.value = value;
		}

		public int getValue() {
			return value;
		}
	}

	public void insert(int value) {
		root = insert(value, root);
	}

	public int height() {
		return height(root);
	}
	
	public int height(Node node) {
		if (node == null) {
			return -1;
		}
		return node.height;
	}

	public Node insert(int value, Node node) {
		if (node == null) {
			node = new Node(value);
			return node;
		}
		if (value < node.value) {
			node.left = insert(value, node.left);
		}
		if (value > node.value) {
			node.right = insert(value, node.right);
		}

		node.height = Math.max(height(node.left), height(node.right)) + 1;

		return rotate(node);
	}

	private Node rotate(Node node) {
		// LL and LR covered in this block
		if (height(node.left) - height(node.right) > 1) {
			// left heavy
			if (height(node.left.left) - height(node.left.right) > 0) {
				// left left case
				return rotateRight(node);
			}
			if (height(node.left.left) - height(node.left.right) < 0) {
				// left right case
				node.left = rotateLeft(node.left);// because the node.left node will be
				// changed
				return rotateRight(node);
			}
		}
		// RR and RL will be covered over here.
		if (height(node.left) - height(node.right) < -1) {
			// right heavy
			if (height(node.right.left) - height(node.right.right) < 0) {
				// right right case
				return rotateLeft(node);
			}
			if (height(node.right.left) - height(node.right.right) > 0) {
				// right left case
				node.right = rotateRight(node.right);
				return rotateLeft(node);
			}
		}
		// default case to do nothing if it's already balanced.
		return node;
	}

	private Node rotateLeft(Node p) {
		Node c = p.right;
		Node t = c.left;

		c.left = p;
		p.right = t;

		// height calculate again as it's changed now.
		p.height = Math.max(height(p.left), height(p.right))+ 1;
		c.height = Math.max(height(c.left), height(c.right))+ 1;

		return c;
	}

	private Node rotateRight(Node p) {
		Node c = p.left;
		Node t = c.right;

		c.right = p;
		p.left = t;

		// need to re calculate the height now
		p.height = Math.max(height(p.left), height(p.right))+ 1;
		c.height = Math.max(height(c.left), height(c.right))+ 1 ;

		return c;
	}

	public boolean balanced() {
		return balanced(root);
	}

	private boolean balanced(Node node) {
		if (node == null) {
			return true;
		}
		return Math.abs(height(node.left) - height(node.right)) <= 1 && balanced(node.left) && balanced(node.right);
	}

	public boolean isEmpty() {
		return root == null;
	}

	public void display() {
//		display(root, "Root node");
		invertedDisplay(root, 0);
	}

	private void display(Node node, String details) {
		if (node == null) {
			return;
		}
		System.out.println(details + node.getValue());
		display(node.left, "left child of " + node.getValue() + ":");
		display(node.right, "right child of " + node.getValue() + ":");

	}

//	public void populate(int[] nums) {
//		for(int i=0;i<nums.length;i++) {
//			insert(nums[i]);
//		}
//	}
	public void populate(int[] nums) {
		populate(nums, 0, nums.length);
	}

	// inserting according to the sorted order of array, to avoid skewed tree.
	private void populate(int[] nums, int start, int end) {
		if (start >= end) {
			return;
		}
		int mid = (start + end) / 2;
		insert(nums[mid]);
		populate(nums, start, mid);
		populate(nums, mid + 1, end);
	}

	public void invertedDisplay(Node node, int level) {
		if (node == null) {
			return;
		}
		invertedDisplay(node.right, level + 1);
		if (level > 0) {
			for (int i = 0; i < level; i++) {
				System.out.print("|\t");
			}
			System.out.println("-------->" + node.value);
		} else {
			System.out.println(node.value);
		}
		invertedDisplay(node.left, level + 1);
	}
}

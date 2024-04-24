package linkedListAndTree;

public class BinarySearchTree {

	private Node root;

	BinarySearchTree() {

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

		@Override
		public String toString() {
			return "Node [value=" + value + ", left=" + left + ", right=" + right + ", height=" + height + "]";
		}
		
	}

	public void insert(int value) {
		root = insert(value, root);
	}

	public int getHeight() {
		return height(root);
	}

	public Node insert(int value, Node node) {
		if (node == null) {
			Node n = new Node(value);
			return n;
		}
		if (value < node.value) {
			node.left = insert(value, node.left);
		}
		if (value > node.value) {
			node.right = insert(value, node.right);
		}

		node.height = Math.max(height(node.left), height(node.right)) + 1;

		return node;
	}

	public boolean balanced() {
		boolean ans = balanced(root);
		return ans;
	}

	private boolean balanced(Node node) {
		if (node == null) {
			return true;
		}
		return Math.abs(height(node.left) - height(node.right)) <= 1 && balanced(node.left) && balanced(node.right);
	}

	public int height(Node node) {
		if (node == null) {
			return -1;
		}
		return node.height;
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
	//inserting according to the sorted order of array, to avoid skewed tree.
	private void populate(int[] nums, int start, int end) {
		if(start>=end) {
			return;
		}
		int mid = (start+end)/2;
		insert(nums[mid]);
		populate(nums,start,mid);
		populate(nums,mid+1,end);
	}
	
	public void invertedDisplay(Node node,int level) {
		if(node == null) {
			return;
		}
		invertedDisplay(node.right, level+1);
		if(level>0) {
			for(int i=0;i<level;i++) {
				System.out.print("|\t");
			}
			System.out.println("-------->"+node.value);
		}else {
			System.out.println(node.value);
		}
		invertedDisplay(node.left, level+1);
	}
	public void preOrder() {
		preOrder(root);
	}
	public void inOrder() {
		inOrder(root);
	}
	public void postOrder() {
		postOrder(root);
	}

	private void postOrder(Node node) {
		if(node==null) {
			return;
		}
		postOrder(node.left);
		postOrder(node.right);
		System.out.print(node.value+" ");
	}

	private void inOrder(Node node) {
		if(node==null) {
			return;
		}
		
		inOrder(node.left);
		System.out.print(node.value+" ");
		inOrder(node.right);
	}

	private void preOrder(Node node) {
		if(node==null) {
			return;
		}
		
		System.out.print(node.value+" ");
		preOrder(node.left);
		preOrder(node.right);
	}
	int diameter = 0;
	public int diameter() {
		getHeight(root);
		return diameter; //being set in the funtion below just return the ans
	}

	private int getHeight(Node node) {
		if(node==null) {
			return 0;
		}
		
		int left = getHeight(node.left); //left part
		int right = getHeight(node.right); //right part
		int diamtr = left + right; //these two lines are like the operations performed on the node above the left and right
		                           //just like the post order traversal.
		diameter = Math.max(diameter, diamtr);
		return Math.max(left, right)+1; //this return is for internal purpose only not the final return.
	}
	
}

package linkedListAndTree;

public class SegmentTree {

	Node root;

	private class Node {
		private int value;
		private Node left;
		private Node right;
		private int height;
		private int startInterval;
		private int endInterval;

		Node(int value) {
			this.value = value;
		}

		Node(int value, int startInterval, int endInterval) {
			this.value = value;
			this.startInterval = startInterval;
			this.endInterval = endInterval;
		}

		@Override
		public String toString() {
			return "Node [value=" + value + ", left=" + left + ", right=" + right + ", height=" + height
					+ ", startInterval=" + startInterval + ", endInterval=" + endInterval + "]";
		}
	}

	public int height() {
		return height(root);
	}

	private int height(Node node) {
		if (node == null) {
			return -1;
		}
		return node.height;
	}

	SegmentTree(int[] arr) {
		root = constructTree(arr, 0, arr.length - 1);
	}

	private Node constructTree(int[] arr, int start, int end) {
		// as per the diagram we have made when start == end we have found a single
		// element which is the leaf.
		if (start == end) {

			Node leaf = new Node(arr[start], start, end);
			return leaf;
		}

		// above is the leaf node but to get till the leaf no nodes are available yet so
		// we need to create them
		Node node = new Node(0, start, end);
		int mid = (start + end) / 2;
		node.left = constructTree(arr, start, mid);
		node.right = constructTree(arr, mid + 1, end);

		node.value = node.left.value + node.right.value;

		return node;
	}

	public int findSum(int start, int end) {
		return findSum(root, start, end);
	}

	private int findSum(Node node, int start, int end) {

		if (node.startInterval > end || node.endInterval < start) {
			return 0;
		} else if (node.startInterval >= start && node.endInterval <= end) {
			return node.value;
		} else {
			return findSum(node.left, start, end) + findSum(node.right, start, end);
		}
	}

	// update
	public void update(int index, int val) {
		update(index, val, root, root.startInterval, root.endInterval);
	}

	private void update(int index, int val, Node node, int start, int end) {

		if (start == index && end == index) {
			node.value = val;
			return;
		}
		int mid = (start + end) / 2;
		if (index < start || index > end) {
			return;
		}
		if(node.left!=null && index<=mid) {
			update(index,val,node.left,node.left.startInterval,node.left.endInterval);
			
		}else if(node.right!=null && index>mid) {
			update(index,val,node.right,node.right.startInterval,node.right.endInterval);
		}
		//now we have updated the value but we need to update the upper nodes values according to the value of
		//the below nodes as well.
		if(node.left!=null && node.right!=null) {
			node.value = node.left.value + node.right.value;
		}	
	}

	public void display() {
		display(root);
	}

	private void display(Node node) {
		String str = "";
		if (node.left != null) {
			str += "Start interval: " + node.left.startInterval + " End interval: " + node.left.endInterval
					+ " Data is: " + node.left.value;
		} else {
			str += " No left child";
		}

		str += "Start interval: " + node.startInterval + " End interval: " + node.endInterval + " Data is: "
				+ node.value;

		if (node.right != null) {
			str += "Start interval: " + node.right.startInterval + " End interval: " + node.right.endInterval
					+ " Data is: " + node.right.value;
		} else {
			str += " No right child";
		}

		// we have printed now need to go to next level recursively.
		if (node.left != null) {
			display(node.left);
		}
		if (node.right != null) {
			display(node.right);
		}
		// printing in LNR pattern that is inorder traversal
		System.out.println(str);
	}
}

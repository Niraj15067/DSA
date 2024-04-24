package linkedListAndTree;

public class A {

	private Node root;

	private class Node {
		int value;
		Node left;
		Node right;
		int height;

		Node(int value) {
			this.value = value;
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

	public void insert(int val) {
		root = insert(val, root);
	}

	private Node insert(int val, Node node) {

		if(node==null) {
			node = new Node(val);
			return node;
		}
		
		if(val<node.value) {
			node.left = insert(val, node.left);
		}
		if(val>node.value) {
			node.right = insert(val, node.right);
		}
		
		node.height = Math.max(height(node.left), height(node.right))+1;
		return rotate(node);
	}
	//4 cases to make tree balanced in avl LL RR LR RL
	private Node rotate(Node node) {
		
		if(height(node.left)-height(node.right)>1) {
			//left unbalanced
			if(height(node.left.left)-height(node.left.right)>0) {
				//left left case
				return rotateRight(node);
			}
			if(height(node.left.left)-height(node.left.right)<0) {
				//left right case
				node.left = rotateLeft(node.left);
			}
		}
		if(height(node.left)-height(node.right)<-1) {
			//right unbalanced
			if(height(node.right.left)-height(node.right.right)<0) {
				//right right case
				return rotateLeft(node);
			}
			if(height(node.right.left)-height(node.right.left)>0) {
				//right left case
				node.right = rotateRight(node.right);
				return rotateLeft(node);
			}
		}
		return node;
	}

	private Node rotateLeft(Node p) {
		
		Node c = p.right;
		Node g = c.left;
		
		c.left = p;
		p.right = g;
		
		p.height = Math.max(height(p.left), height(p.right))+1;
		c.height = Math.max(height(c.left), height(c.right))+1;
		
		return c;
	}

	private Node rotateRight(Node p) {
		
		Node c = p.left;
		Node g = c.right;
		
		c.right = p;
		p.left = g;
		
		//recalculate the height for the new tree formed.
		p.height = Math.max(height(p.left), height(p.right))+1;
		c.height = Math.max(height(c.left), height(c.right))+1;
		
		return c;
	}
	private void display() {
		display(root,0);

	}
	
	private void display(Node node, int level) {
		if(node == null) {
			return;
		}
		display(node.right,level+1);
		if(level>0) {
			for(int i=0;i<level-1;i++) {
				System.out.print("|\t");
			}
			System.out.println(node.value);
		}else {
			System.out.println(node.value);
		}
		display(node.left,level+1);
	}

	public static void main(String[] args) {
		A a = new A();
		for(int i=0;i<1000;i++) {
			a.insert(i);
		}
		a.display();
		System.out.println(a.height());
	}
	
}

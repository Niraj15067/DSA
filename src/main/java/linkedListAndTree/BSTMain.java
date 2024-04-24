package linkedListAndTree;

public class BSTMain {

	public static void main(String[] args) {

		BinarySearchTree bst = new BinarySearchTree();
		int[] nums = {1,2,3,4,5,6,7,8};
		bst.populate(nums);
//		bst.display();
////		bst.preOrder();
//		bst.inOrder();
		int ans = bst.diameter();
		System.out.println(ans);
		
	}

}

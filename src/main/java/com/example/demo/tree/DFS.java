package com.example.demo.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

import javax.management.monitor.CounterMonitorMBean;

public class DFS {

	TreeNode root;

	private class TreeNode {
		int val;
		int height;
		TreeNode left;
		TreeNode right;
		TreeNode next;

		TreeNode(int value) {
			this.val = value;
		}

		@Override
		public String toString() {
			return "TreeNode [val=" + val + ", height=" + height + ", left=" + left + ", right=" + right + ", next="
					+ next + "]";
		}

	}

	public int getHeight() {
		return root.height;
	}

//	public int height(TreeNode node) {
//		if (node == null) {
//			return -1;
//		}
//		return node.height;
//	}

	public void constructTree(Scanner sc) {
		System.out.println("Enter the root node: ");
		root = new TreeNode(sc.nextInt());
		constructTree(sc, root);
	}

	public void constructTree(Scanner sc, TreeNode node) {
		System.out.println("Do you want to enter the left of : " + node.val);
		boolean left = sc.nextBoolean();
		if (left) {
			System.out.println("Enter the value for left of " + node.val + " : ");
			int value = sc.nextInt();
			node.left = new TreeNode(value);
			constructTree(sc, node.left);
		}

		System.out.println("Do you want to enter the right of : " + node.val);
		boolean right = sc.nextBoolean();
		if (right) {
			System.out.println("Enter the value for right of : " + node.val);
			int value = sc.nextInt();
			node.right = new TreeNode(value);
			constructTree(sc, node.right);
		}
		if (node.left != null && node.right != null) {
			node.height = Math.max(node.left.height, node.right.height) + 1;
		}
	}

	public void construct(int[] arr) {
		construct(arr, 0, arr.length);
	}

	private void construct(int[] arr, int start, int end) {
		if (start >= end) {
			return;
		}

		int mid = (start + end) / 2;
		construct(arr, start, mid);
		construct(arr, mid + 1, end);

	}

	private void display() {
		Queue<TreeNode> q = new ArrayDeque<>();
		q.add(root);
		display(root, q);
		System.out.println();
		display(root, 0);
	}

	private void display(TreeNode node, int level) {

		if (node == null) {
			return;
		}

		display(node.right, level + 1);
		if (level > 0) {
			for (int i = 0; i < level; i++) {
				System.out.print("|\t");
			}
			System.out.println("|---->" + node.val);
		} else {
			System.out.println(node.val);
		}
		display(node.left, level + 1);

	}

	private void display(TreeNode node, Queue<TreeNode> q) {

		if (node == null || q.isEmpty()) {
			return;
		}

		while (!q.isEmpty()) {
			TreeNode poll = q.poll();
			System.out.print(poll.val + "-->");
			if (poll.left != null) {
				q.add(poll.left);
			}
			if (poll.right != null) {
				q.add(poll.right);
			}
		}
		display(node.left, q);
	}

	public TreeNode invertTree(TreeNode root) {
		if (root == null) {
			return root;
		}
		// in order traversal
		invertTree(root.left);
		invertTree(root.right);
		swap(root);

		return root;
	}

	private void swap(TreeNode node) {
		TreeNode temp = node.left;
		node.left = node.right;
		node.right = temp;
	}

	public int maxDepth(TreeNode root) {
		int height = height(root);
		return height + 1;
	}

	public int height(TreeNode node) {
		if (node == null) {
			return 0;
		}
		int leftH = height(node.left);
		int rightH = height(node.right);
		return Math.max(leftH, rightH) + 1;
	}

	public TreeNode sortedArrayToBST(int[] nums) {
		return middle(nums, 0, nums.length - 1);
	}

	public TreeNode middle(int[] nums, int start, int end) {
		if (start > end) {
			return null;
		}
		int mid = start + (end - start) / 2;
		TreeNode node = new TreeNode(nums[mid]);
		node.left = middle(nums, start, mid - 1);
		node.right = middle(nums, mid + 1, end);
		return node;
	}

	public int maxDepth1(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int leftH = maxDepth(root.left);
		int rightH = maxDepth(root.right);
		return Math.max(leftH, rightH) + 1;
	}

	Queue<TreeNode> q = new LinkedList<>();

	// O(n) in o(n) space
	public void flatten(TreeNode root) {
		if (root == null) {
			return;
		}
		generateQ(root);
		TreeNode r = q.poll();
		while (!q.isEmpty()) {
			r.right = q.poll();
			r.left = null;
			r = r.right;
		}
		root.left = null;
	}

	public void generateQ(TreeNode node) {
		if (node == null) {
			return;
		}
		q.offer(node);
		generateQ(node.left);
		generateQ(node.right);
	}

	// faster in O(1) space and turning a tree into right skewed tree with pre order
	// traversal.
	public void flatten1(TreeNode root) {
		TreeNode current = root;
		while (current != null) {
			if (current.left != null) {
				TreeNode rightMost = current.left;
				while (rightMost.right != null) {
					rightMost = rightMost.right;
				}
				rightMost.right = current.right;
				current.right = current.left;
				current.left = null;
			}
			current = current.right;
		}
	}

	public boolean isValidBST(TreeNode root) {
		return isValid(root, null, null);
	}

	public boolean isValid(TreeNode node, Integer low, Integer hi) {
		if (node == null) {
			return true;
		}
		// we are checking the current node first and then going left and then right
		// hence pre order.
		// at each level the right sub tree each value should be less than the right
		// parent.
		if (low != null && node.val <= low) {
			return false;
		}
		if (hi != null && node.val >= hi) {
			return false;
		}
		boolean left = isValid(node.left, low, node.val);
		boolean right = isValid(node.right, node.val, hi);

		return left && right;
	}

	List<TreeNode> list = new ArrayList<>();

	public int kthSmallest(TreeNode root, int k) {
		place(root);
		TreeNode node = list.get(k);
		return node.val;
	}

	public void place(TreeNode node) {
		if (node == null) {
			return;
		}
		place(node.left);
		list.add(node);
		place(node.right);
	}

	// without using list
	int count = 0;

	public int kthSmallest1(TreeNode root, int k) {
		return place(root, k).val;
	}

	public TreeNode place(TreeNode node, int k) {
		if (node == null) {
			return null;
		}
		TreeNode left = place(node.left, k);
		if (left != null) {
			return left;
		}
		count++;
		if (count == k) {
			return node;
		}
		return place(node.right, k);
	}

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if (preorder.length == 0) {
			return null;
		}
		int root = preorder[0];
		int index = 0;
		for (int i = 0; i < inorder.length; i++) {
			if (root == inorder[i]) {
				break;
			}
			index++;
		}
		TreeNode node = new TreeNode(root);
		node.left = buildTree(Arrays.copyOfRange(preorder, 1, index + 1), Arrays.copyOfRange(inorder, 0, index));
		node.right = buildTree(Arrays.copyOfRange(preorder, index + 1, preorder.length),
				Arrays.copyOfRange(inorder, index + 1, inorder.length));

		return node;
	}

	// build from inorder and postorder
	public TreeNode buildTree1(int[] inorder, int[] postorder) {
		if (inorder.length == 0) {
			return null;
		}
		int root = postorder[postorder.length - 1];
		int index = 0, lCount = 0;
		for (int i = 0; i < inorder.length; i++) {
			if (root == inorder[i]) {
				break;
			}
			lCount++;
			index++;
		}
		TreeNode node = new TreeNode(root);
		node.left = buildTree1(Arrays.copyOfRange(inorder, 0, index), Arrays.copyOfRange(postorder, 0, lCount));
		node.right = buildTree1(Arrays.copyOfRange(inorder, index + 1, inorder.length),
				Arrays.copyOfRange(postorder, lCount, postorder.length - 1));
		return node;
	}

	public TreeNode buildTree2(int[] inorder, int[] postorder) {
		return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
	}

	public TreeNode buildTree(int[] inorder, int inorderS, int inorderE, int[] postorder, int postorderS,
			int postorderE) {
		if (inorderS > inorderE || postorderS > postorderE) {
			return null;
		}
		TreeNode root = new TreeNode(postorder[postorderE]);
		int rootIndex = 0;
		for (int i = 0; i < inorder.length; i++) {
			if (inorder[i] == root.val) {
				rootIndex = i;
				break;
			}
		}
		root.left = buildTree(inorder, inorderS, rootIndex - 1, postorder, postorderS,
				postorderS + rootIndex - inorderS - 1);
		root.right = buildTree(inorder, rootIndex + 1, inorderE, postorder, postorderS + rootIndex - inorderS,
				postorderE - 1);
		return root;
	}

	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		List<String> list = new ArrayList<>();
		createList(root, list);
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < list.size(); i++) {
			if (i == list.size() - 1) {
				sb.append(list.get(i));
			} else {
				sb.append(list.get(i) + ",");
			}
		}
		return sb.toString();
	}

	private void createList(TreeNode node, List<String> list) {
		if (node == null) {
			list.add("null");
			return;
		}
		list.add(String.valueOf(node.val));
		createList(node.left, list);
		createList(node.right, list);
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		String[] str = data.split(",");
		List<String> list = new ArrayList<>();
		for (String s : str) {
			list.add(s);
		}
		Collections.reverse(list);
		return deserialize(list);
	}

	private TreeNode deserialize(List<String> list) {
		String s = list.remove(list.size() - 1);
		if (s.equals("null")) {
			return null;
		}
		int val = Integer.valueOf(s);
		TreeNode node = new TreeNode(val);
		node.left = deserialize(list);
		node.right = deserialize(list);
		return node;
	}

	public boolean hasPathSum(TreeNode root, int targetSum) {
		if (root == null) {
			return false;
		}
		return hasPathSum(root, targetSum, 0);
	}

	public boolean hasPathSum(TreeNode node, int target, int current) {
		if (node == null) {
			return false;
		}
		if (node.left == null && node.right == null) {
			current += node.val;
			return target == current ? true : false;
		}
//          boolean left = hasPathSum(node.left,target,current+node.val);
//          if(left){
//              return left;
//          }
//          boolean right = hasPathSum(node.right,target,current+node.val);
//          return right;
		// this can be made short like this:
		return hasPathSum(node.left, target, current + node.val) || hasPathSum(node.right, target, current + node.val);
	}

	// here we don't need the sum variable we just need to minus the current node
	// value from the node value
	// if leaf node value is equal to the target at that point then we have found
	// the path return true else false.
	public boolean hasPathSum1(TreeNode node, int target) {
		if (node == null) {
			return false;
		}
		if (node.val == target && node.left == null && node.right == null) {
			return true;
		}
		return hasPathSum1(node.left, target - node.val) || hasPathSum1(node.right, target - node.val);
	}

	List<Integer> sumList = new ArrayList<>();
	int sum = 0;

	public int sumNumbers(TreeNode root) {
		if (root == null) {
			return 0;
		}
		StringBuilder sb = new StringBuilder();
		sumNumbers(root, sb);
		for (int n : sumList) {
			sum += n;
		}
		return sum;
	}

	public void sumNumbers(TreeNode node, StringBuilder sb) {
		if (node == null) {
			return;
		}
		if (node.left == null && node.right == null) {
			sb.append(node.val);
			int val = Integer.parseInt(sb.toString());
			sumList.add(val);
			sb.deleteCharAt(sb.length() - 1);// backtracking when we are returning up as we dont need the below added
			return;
		}
		sb.append(node.val);
		sumNumbers(node.left, sb);
		sumNumbers(node.right, sb);
		sb.deleteCharAt(sb.length() - 1);// left and right execution done backtrack before going up.
	}

	// the above code for Sum Root to Leaf Numbers code is a bit difficult because
	// of backtracking we can make it simpler.
	public int sumNumbers1(TreeNode root) {
		return sumNumber(root, 0);
	}

	private int sumNumber(TreeNode node, int sum) {
		if (node == null) {
			return 0;
		}
		sum = sum * 10 + node.val;
		if (node.left == null && node.right == null) {
			return sum;
		}
		return sumNumber(node.left, sum) + sumNumber(node.right, sum);
	}

	/*
	 * for below code logic is: 1. We use post order traversal and find the left
	 * best path and right best path and then add the current node val. 2. The
	 * totalPath contains the whole path from left to right with the current node as
	 * the medium or left to right through current. 3. We always compare the
	 * currently acquired totalpath with the global max path which is the ans. 4.
	 * The return method returns either the left or right path + the current node
	 * val, this is because when we go up and calculate the path through the current
	 * node for the below paths we can't be like I want the left and right as well
	 * it will lead only to the end of the left or the right subtree so this decides
	 * whether the left or the right path is the bigger one and then add the current
	 * node.val to it. 5. Suppose the tree is 2,-1 here ans should be 2 right so to
	 * do this suppose the left or the right subtree is giving a path less than 0 we
	 * don't need it right so just make it 0 so that the above ans won't get
	 * affected by this, otherwise the negative values will be added up in the total
	 * path which will lead to wrong ans.
	 */

	int max = Integer.MIN_VALUE;
	private static int countAllPathSum;

	public int maxPathSum(TreeNode root) {
		maxPath(root);
		return max;
	}

	int maxPath(TreeNode node) {
		if (node == null) {
			return 0;
		}

		int left = maxPath(node.left);
		int right = maxPath(node.right);
		left = Math.max(0, left);
		right = Math.max(0, right);

		int totalPath = left + right + node.val;
		max = Math.max(max, totalPath);
		return Math.max(left, right) + node.val;
	}

	// whether contains path from the source to destination which is given inside
	// the array.
	public boolean hasPath(int[] nums) { // this is the array which contains all the nodes in the path.
		return hasPath(nums, root, 0);
	}

	private boolean hasPath(int[] nums, TreeNode node, int index) {
		if (node == null) {
			return false;
		}
		if (index >= nums.length || node.val != nums[index]) {
			return false;
		}
		if (index == nums.length - 1 && node.left == null && node.right == null) {
			return true;
		}

		return hasPath(nums, node.left, index + 1) || hasPath(nums, node.right, index + 1);
	}

	// all paths whose sum is equal to the given target.
	public List<List<Integer>> allSumPaths(int target) {
		List<List<Integer>> ans = new ArrayList<>();
		if (root == null) {
			return ans;
		}
//		allSumPaths(ans,root,target,new ArrayList<>());
		allSumPaths1(ans, root, target, new ArrayList<>());
		return ans;
	}

	// only root till leaf node paths.
	private void allSumPaths(List<List<Integer>> ans, TreeNode node, int target, List<Integer> current) {
		if (node == null) {
			return;
		}
		current.add(node.val);

		if (node.left == null && node.right == null && node.val == target) {
			ans.add(new ArrayList<>(current));
		} else {
			allSumPaths(ans, node.left, target - node.val, current);
			allSumPaths(ans, node.right, target - node.val, current);
		}

		current.remove(current.size() - 1);

	}

	// all possible sums of target including underlying paths which may not finish
	// on the leaf node.
	private void allSumPaths1(List<List<Integer>> ans, TreeNode node, int target, List<Integer> current) {
		if (node == null) {
			return;
		}

		current.add(node.val);
		// after adding each ele to the current list check if we have a path backwards.
		// reason is if we do check back we ensure that only the needed part is covered,
		// because if
		// we had a path earlier it would have been already discovered so.
		int sum = 0;
		for (int i = current.size() - 1; i >= 0; i--) {
			sum += current.get(i);
			if (sum == target) {
				// we need the particular list which is making up the sum not the entire list.
				ans.add(new ArrayList<>(current.subList(i, current.size())));
			}
		}

		// recursive search for paths.
		allSumPaths1(ans, node.left, target, current);
		allSumPaths1(ans, node.right, target, current);

		// backtracking to remove the used elements from the list.
		current.remove(current.size() - 1);
	}

	private int countAllPathSum(int target) {
		return countAllPathSum(root, new ArrayList<>(), target);

	}

	// now instead of finding all the underlying path sums just return a count of it
	// i.e how many paths are there.
	private int countAllPathSum(TreeNode node, List<Integer> current, int target) {
		if (node == null) {
			return 0;
		}
		current.add(node.val);
		int c = 0;
		int sum = 0;
		for (int i = current.size() - 1; i >= 0; i--) {
			sum += current.get(i);
			if (sum == target) {
				c++;
			}
		}

		c += countAllPathSum(node.left, current, target) + countAllPathSum(node.right, current, target);
		current.remove(current.size() - 1);
		return c;
	}

	private int maxBinTreeGCD(ArrayList<ArrayList<Integer>> arr, int N) {
		Collections.sort(arr, (l1, l2) -> l1.get(0) - l2.get(0));
		int maxGcd = Integer.MIN_VALUE;
		for (int i = 0; i < N - 1; i++) {
			if (i + 1 < N - 1 && arr.get(i).get(0) == arr.get(i + 1).get(0)) {
				maxGcd = Math.max(maxGcd, findGCD(arr.get(i).get(1), arr.get(i + 1).get(1)));
			}
		}
		if (maxGcd == Integer.MIN_VALUE)
			return 0;
		return maxGcd;
	}

	private int findGCD(int a, int b) {
		int result = Math.min(a, b);
		while (result > 0) {
			if (a % result == 0 && b % result == 0) {
				break;
			}
			result--;
		}
		return result;
	}

	public TreeNode inorderSuccessor(TreeNode root, TreeNode x) {
		ArrayList<TreeNode> ans = new ArrayList<>();
		inorder(ans, root);
		for (int i = 0; i < ans.size(); i++) {
			if (ans.get(i).val == x.val && i + 1 < ans.size()) {
				return ans.get(i + 1);
			}
		}
		return null;
	}

	public void inorder(ArrayList<TreeNode> ans, TreeNode node) {
		if (node == null) {
			return;
		}

		inorder(ans, node.left);
		ans.add(node);
		inorder(ans, node.right);
	}

	// morris inorder traversal
	public ArrayList<Integer> morrisInorderTraversal(TreeNode node) {
		ArrayList<Integer> ans = new ArrayList<>();
		TreeNode cur, pre;
		cur = node;
		while (cur != null) {
			if (cur.left == null) {
				ans.add(cur.val);
				cur = cur.right;
			} else {
				pre = cur.left;
				while (pre.right != null && pre.right != cur) {
					pre = pre.right;
				}
				if (pre.right == null) {
					pre.right = cur;
					cur = cur.left;
				} else {
					pre.right = null;
					ans.add(cur.val);
					cur = cur.right;
				}
			}
		}
		return ans;
	}

	// preorder constant space traversal.
	public ArrayList<Integer> morrispreorderTraversal(TreeNode node) {

		ArrayList<Integer> ans = new ArrayList<>();
		TreeNode current, pre;
		current = node;
		while (current != null) {
			if (current.left == null) {
				ans.add(current.val);
				current = current.right;
			} else {
				pre = current.left;
				while (pre.right != null && pre.right != current) {
					pre = pre.right;
				}

				if (pre.right == null) {
					pre.right = current;
					ans.add(current.val);
					current = current.left;
				} else {
					pre.right = null;
					current = current.right;
				}
			}
		}
		return ans;
	}
	
	private ArrayList<Integer> inorderUsingStack(TreeNode node){
		ArrayList<Integer> ans = new  ArrayList<>();
		if(node==null)
			return ans;
		Stack<TreeNode> stack = new Stack<>();
		while(!stack.isEmpty() || node!=null) { //need the node condition as we need to enter the loop.
			//add all the nodes in the stack as you go to the left until you reach null
			
			while(node!=null) {
				stack.push(node);
				node = node.left;
			}
			//here you have reached the left most node which is null. So pop the last ele from stack which is the
			//left most and then add it to ans and now move to the right of the popped which at first will be null
			// as it's a leaf node. so again pop and add to ans and go to right and repeat the process.
			TreeNode current = stack.pop();
			ans.add(current.val);
			node = current.right;
		}
		return ans;
	}
	private ArrayList<Integer> preorderUsingStack(TreeNode node){
		ArrayList<Integer> ans = new ArrayList<>();
		if(node==null) {
			return ans;
		}
		Stack<TreeNode> stack = new Stack<>();
		while(node!=null || !stack.isEmpty()) {
			
			while(node!=null) {
				ans.add(node.val);
				stack.push(node);
				node = node.left;
			}
			TreeNode current = stack.pop();
			node = current.right;	
		}
		return ans;
	}
	/* Using 2 stacks.
	 * 1. First if null directly return if not then
	 * 2. Declare 2 stacks.
	 * 3. Add the root to the stack 1.
	 * 4. Pop from stack 1 and add right first then left of tree into the stack 1 while the popped ele will be in 
	 *    stack 2.
	 * 5. Continue this till the stack 1 is not empty when it gets empty stack 2 will be having the ans. Pop all and
	 *    add to the ans list.
	 * 
	 */
	private ArrayList<Integer> postOrderUsingStack(TreeNode node){
		ArrayList<Integer> ans = new ArrayList<>();
		if(node==null)
			return ans;
		Stack<TreeNode> s1 = new Stack<>();
		Stack<TreeNode> s2 = new Stack<>();
		s1.push(node);
		while(!s1.isEmpty()) {
			TreeNode current = s1.pop();
			if(current.left!=null)
				s1.push(current.left);
			if(current.right!=null)
				s1.push(current.right);
			s2.push(current);
		}
		while(!s2.isEmpty())
			ans.add(s2.pop().val);
		return ans;
	}
	public ArrayList<Integer> morrispostorderTraversal(TreeNode node) {

		ArrayList<Integer> res = new ArrayList<>();
		TreeNode current = root;

		while (current != null) {
			if(current.right==null) {
				res.add(current.val);
				current = current.left;
			}else {
				TreeNode prev = current.right;
				while(prev.left!=null && prev.left!=current) {
					prev = prev.left;
				}
				if(prev.left==null) {
					prev.left = current;
					res.add(current.val);
					current = current.right;
				}else {
					prev.left = null;
					current = current.left;
				}
			}
			
		}
		// reverse the res
		Collections.reverse(res);
		return res;
	}
	
	public static boolean isSubtree(TreeNode T, TreeNode S) {
        if(T==null){
            return false;
        }
        if(S==null){
            return true;
        }
        if(traverse(T,S)){
            return true;
        }
       
		return isSubtree(T.left,S) || isSubtree(T.right,S);
    }
    private static boolean traverse(TreeNode t, TreeNode s) {
		
		if(t==null && s==null) {
			return true;
		}
		if(t==null || s==null){
		    return false;
		}
		if (t.val != s.val) {
			return false;
		}

		boolean left = traverse(t.left, s.left);
		boolean right = traverse(t.right, s.right);
		return left && right;
	}
    class Count{
		int c;
	}
    private int singleValuedSubtree(TreeNode node) {
    	
    	Count c = new Count();
    	
    	singleValuedSubtree(node, c);
    	return c.c;
    }

	private boolean singleValuedSubtree(TreeNode node, Count c) {
		if(node==null) {
			return true;
		}
		boolean left = singleValuedSubtree(node.left, c);
		boolean right = singleValuedSubtree(node.right, c);
		
		if(!left || !right) {
			return false;
		}
		if(node.left!=null && node.val!=node.left.val) {
			return false;
		}
		if(node.right!=null && node.val!=node.right.val) {
			return false;
		}
		c.c+=1;
		return true;
	}

	public static void main(String[] args) {
		DFS dfs = new DFS();
		Scanner sc = new Scanner(System.in);
		dfs.constructTree(sc);
		int single = dfs.singleValuedSubtree(dfs.root);
		System.out.println(single);
//		int postOrder[] = { 9, 15, 7, 20, 3 };
//		int inorder[] = { 9, 3, 15, 20, 7 };
//		dfs.buildTree2(inorder, postOrder);
//		int ans = dfs.sumNumbers(dfs.root);
//		System.out.println("Sum is: "+ans);
//		int ans = dfs.sumNumbers1(dfs.root);
//		System.out.println(ans);
//		int maxPath = dfs.maxPathSum(dfs.root);
//		int arr[] = {3,9,12,8};
//		boolean hasPath = dfs.hasPath(arr);
//		System.out.println(hasPath);
//		List<List<Integer>> allSumPaths = dfs.allSumPaths(7);
//		System.out.println(allSumPaths);
//		countAllPathSum = dfs.countAllPathSum(7);
//		System.out.println(countAllPathSum);
		
//		ArrayList<Integer> morrisInorderTraversal = dfs.morrisInorderTraversal(dfs.root);
//		ArrayList<Integer> morrispreorderTraversal = dfs.morrispreorderTraversal(dfs.root);
//		ArrayList<Integer> morrispostorderTraversal = dfs.morrispostorderTraversal(dfs.root);
//		System.out.println(morrisInorderTraversal);
//		System.out.println(morrispreorderTraversal);
//		System.out.println(morrispostorderTraversal);
//		int ans = dfs.singleValuedSubtree(dfs.root);
//		System.out.println(ans);
//		ArrayList<Integer> inorderUsingStack = dfs.inorderUsingStack(dfs.root);
//		System.out.println(inorderUsingStack);
//		ArrayList<Integer> preorderUsingStack = dfs.preorderUsingStack(dfs.root);
//		System.out.println(preorderUsingStack);
//		ArrayList<Integer> postOrderUsingStack = dfs.postOrderUsingStack(dfs.root);
//		System.out.println(postOrderUsingStack);
	}

}

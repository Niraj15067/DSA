package com.example.demo.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.TreeMap;

public class BFS {

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

	public int height(TreeNode node) {
		if (node == null) {
			return -1;
		}
		return node.height;
	}

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

		int mid = start + (end-start) / 2;
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

	public List<List<Integer>> levelOrder() {
		List<List<Integer>> order = new ArrayList<>();
		if (root == null) {
			return order;
		}
		Queue<TreeNode> q = new ArrayDeque<>();
		q.add(root);
		while (!q.isEmpty()) {
			List<Integer> currLevel = new ArrayList<>();
			int level = q.size();
			for (int i = 0; i < level; i++) {
				TreeNode node = q.poll();
				if (node.left != null) {
					q.add(node.left);
				}
				if (node.right != null) {
					q.add(node.right);
				}
				currLevel.add(node.val);
			}
			order.add(currLevel);
		}
		return order;
	}

	public List<Double> averageOfLevels(TreeNode root) {
		List<Double> average = new ArrayList<>();
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		while (!q.isEmpty()) {
			int lvlSize = q.size();
			double sum = 0;
			for (int i = 0; i < lvlSize; i++) {
				TreeNode node = q.poll();
				sum += node.val;
				if (node.left != null) {
					q.add(node.left);
				}
				if (node.right != null) {
					q.add(node.right);
				}
			}
			average.add(sum / lvlSize);
		}

		return average;
	}

	public int nextRight(int value) {
		if (root == null) {
			return -1;
		}
		Queue<TreeNode> q = new ArrayDeque<>();
		q.add(root);
		while (!q.isEmpty()) {
			TreeNode node = q.poll();
			if (node.left != null) {
				q.add(node.left);
			}
			if (node.right != null) {
				q.add(node.right);
			}
			if (node.val == value && !q.isEmpty()) {
				return q.peek().val;
			}
		}
		return -1;
	}

	public List<List<Integer>> zigzagLevelOrder() {
		List<List<Integer>> order = new ArrayList<>();
		if (root == null) {
			return order;
		}
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		boolean leftToRight = true;
		while (!q.isEmpty()) {
			List<Integer> currentLevel = new ArrayList<>();
			int levelSize = q.size();
			for (int i = 0; i < levelSize; i++) {
				TreeNode node = q.poll();
				if (node.left != null) {
					q.offer(node.left);
				}
				if (node.right != null) {
					q.offer(node.right);
				}
				currentLevel.add(node.val);
			}
			if (!leftToRight) {
				Collections.reverse(currentLevel);
			}
			leftToRight = leftToRight ? false : true;
			order.add(currentLevel);
		}
		return order;
	}

	// without using reverse function of collection.
	public List<List<Integer>> zigzagLevelOrder1() {
		List<List<Integer>> order = new ArrayList<>();
		if (root == null) {
			return order;
		}
		Deque<TreeNode> q = new ArrayDeque<>();
		q.add(root);
		boolean leftToRight = true;
		while (!q.isEmpty()) {
			List<Integer> currentLevel = new ArrayList<>();
			int levelSize = q.size();
			for (int i = 0; i < levelSize; i++) {
				TreeNode node = null;
				// normal order remove from front add in back normal queue processing.
				if (leftToRight) {
					node = q.poll();
					if (node.left != null) {
						q.offer(node.left);
					}
					if (node.right != null) {
						q.offer(node.right);
					}
				}
				// rev order remove back add in front of the queue.
				else {
					node = q.pollLast();
					if (node.right != null) {
						q.push(node.right);
					}
					if (node.left != null) {
						q.push(node.left);
					}
				}
				currentLevel.add(node.val);
			}
			leftToRight = leftToRight ? false : true; // or leftToRight = !leftToRight;
			order.add(currentLevel);
		}
		return order;
	}

	// connect each one to its next in the right on the same level;
	public void connect() {
		if (root == null) {
			return;
		}
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);
		while (!q.isEmpty()) {
			int levelSize = q.size();
			for (int i = 0; i < levelSize; i++) {
				TreeNode node = q.poll();
				if (node.left != null) {
					q.offer(node.left);
				}
				if (node.right != null) {
					q.offer(node.right);
				}
				if (i == levelSize - 1) {
					node.next = null;
				} else {
					node.next = q.peek();
				}
			}
		}
	}

	// same connect without using queue. Faster as well than the above one.
	public void connect1() {

		TreeNode leftMost = root;
		while (leftMost.left != null) {
			TreeNode current = leftMost;
			// at each node we are filling the pointers of its below level.
			while (current != null) {// fill all the brides and its children and move on to the next node to do the
										// same.
				current.left.next = current.right;
				if (current.next != null) {
					current.right.next = current.next.left;
				}
				current = current.next;
			}
			leftMost = leftMost.left;
		}
	}

	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> view = new ArrayList<>();
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);
		if (root == null) {
			return view;
		}
		while (!q.isEmpty()) {
			List<Integer> currLevel = new ArrayList<>();
			int size = q.size();
			for (int i = 0; i < size; i++) {
				TreeNode node = q.poll();
				if (node.left != null) {
					q.offer(node.left);
				}
				if (node.right != null) {
					q.offer(node.right);
				}
				currLevel.add(node.val);
			}
			view.add(currLevel.get(currLevel.size() - 1));
		}
		return view;
	}

	// cousins if they are on the same depth or level and do not have the same
	// parent. 0 ms runtime.
	public boolean isCousins(TreeNode root, int x, int y) {
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);
		while (!q.isEmpty()) {
			int size = q.size();
			boolean containsX = false;
			boolean containsY = false;
			for (int i = 0; i < size; i++) {
				TreeNode node = q.poll();
				if (node.left != null && node.right != null
						&& ((node.left.val == x && node.right.val == y) || node.right.val == x && node.left.val == y)) {
					return false;
				}
				if (node.val == x) {
					containsX = true;
				}
				if (node.val == y) {
					containsY = true;
				}
				if (containsX && containsY) {
					return true;
				}
				if (node.left != null) {
					q.offer(node.left);
				}
				if (node.right != null) {
					q.offer(node.right);
				}
			}
		}
		return false;
	}

	// same try doing without using queue.
	public boolean isCousins1(int x, int y) {
		TreeNode xx = findNode(root, x);
		TreeNode yy = findNode(root, y);

		int xLevel = level(root, xx, 0);
		int yLevel = level(root, yy, 0);

		if (xLevel == yLevel && !siblings(root, xx, yy)) {
			return true;
		}
		return false;
	}

	private boolean siblings(TreeNode node, TreeNode xx, TreeNode yy) {
		if (node == null) {
			return false;
		}
		return ((node.left == xx && node.right == yy) || (node.right == xx && node.left == yy)
				|| siblings(node.left, xx, yy) || siblings(node.right, xx, yy));
	}

	private int level(TreeNode node, TreeNode yy, int lvl) {
		if (root == null) {
			return 0;
		}
		if (node.val == yy.val) {
			return lvl;
		}
		int l = level(node.left, yy, lvl + 1);
		// not zero means we found our levl so return it.
		if (l != 0) {
			return l;
		}
		l = level(node.right, yy, lvl + 1);
		return l;
	}

	private TreeNode findNode(TreeNode node, int x) {
		if (node == null) {
			return null;
		}
		if (node.val == x) {
			return node;
		}
		TreeNode xx = findNode(node.left, x);
		if (xx != null) {
			return xx;
		}
		xx = findNode(node.right, x);
		return xx;
	}

	TreeMap<List<Integer>, List<Integer>> map = new TreeMap<>((a, b) -> {
		int result = a.get(1) - b.get(1);
		if (result == 0) {
			return a.get(0) - b.get(0);
		}
		return result;
	});

	public List<List<Integer>> verticalTraversal() {
		List<List<Integer>> vertical = new ArrayList<>();
		buildMap(root, 0, 0);
		int prevKey = Integer.MIN_VALUE;
		List<Integer> current = null;
		for (Entry<List<Integer>, List<Integer>> entry : map.entrySet()) {
			int key = entry.getKey().get(1);
			List<Integer> value = entry.getValue();
			if (key != prevKey) {
				current = new ArrayList<>();
				vertical.add(current);
			}
			// here we are getting values for the same column so add them to the current
			// list.
			for(int val:value) {
				current.add(val);
			}
			// upate the prevkey to the latest key(in case for we encounter a new col then
			// this will change
			// as well so need it for that.
			prevKey = key;

		}
		return vertical;
	}

	public void buildMap(TreeNode node, int r, int c) {
		if (node == null) {
			return;
		}
		List<Integer> key = new ArrayList<>();
		key.add(0, r);
		key.add(1, c);
		List<Integer> list = new ArrayList<>();
		if(map.containsKey(key)) {
			list = map.get(key);
			list.add(node.val);
			map.put(key, list);
		}else {
			list.add(node.val);
			map.put(key, list);
		}
		buildMap(node.left, r + 1, c - 1);
		buildMap(node.right, r + 1, c + 1);
	}
	
	public boolean isSymmetric() {
		if (root == null) {
			return false;
		}
		Queue<TreeNode> q = new LinkedList<>();
		if (root.left != null && root.right != null &&(root.left.val==root.right.val)) {
			q.add(root.left);
			q.add(root.right);
		}
		while (!q.isEmpty()) {
			TreeNode left = q.poll();
			TreeNode right = q.poll();
			if(left==null && right==null){
                continue;
            }else if(left==null || right==null){
                return false;
            }
			if (left.val != right.val) {
				return false;
			}
			q.add(left.left);
			q.add(right.right);
			q.add(left.right);
			q.add(right.left);
		}
		return true;
	}
	public TreeNode invertTree(TreeNode root) {
		
        if(root==null){
            return root;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                TreeNode node = q.poll();
                swap(node);
                if(node.left!=null){
                    q.offer(node.left);
                }
                if(node.right!=null){
                    q.offer(node.right);
                }
            } 
        }
        return root;
    }
    public void swap(TreeNode node){
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
    }
    
    private int maxBinTreeGCD(ArrayList<ArrayList<Integer>> arr, int N) {
		Collections.sort(arr, (l1, l2) -> l1.get(0) - l2.get(0));
		int maxGcd = Integer.MIN_VALUE;
		for (int i = 0; i < N - 1; i++) {
			if(i+1<N-1 && arr.get(i).get(0)==arr.get(i+1).get(0)) {
				maxGcd = Math.max(maxGcd, findGCD(arr.get(i).get(1), arr.get(i+1).get(1)));
			}
		}
		if(maxGcd==Integer.MIN_VALUE)
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



	public static void main(String[] args) {
		BFS bfs = new BFS();
		Scanner sc = new Scanner(System.in);
		bfs.constructTree(sc);
//		List<List<Integer>> ans = bfs.levelOrder();
//		System.out.println(ans);
//		bfs.display();
//		System.out.println(bfs.getHeight());
//		List<Double> avg = bfs.averageOfLevels(bfs.root);
//		System.out.println(avg);
//		System.out.println(bfs.nextRight(8));
//		List<List<Integer>> ans = bfs.zigzagLevelOrder1();
//		Collections.reverse(ans);
//		System.out.println(ans);
//		bfs.connect();
		System.out.println(bfs.isCousins1(8, 9));
		System.out.println(bfs.isSymmetric());

	}
}

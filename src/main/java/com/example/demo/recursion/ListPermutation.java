package com.example.demo.recursion;

import java.util.ArrayList;
import java.util.List;

public class ListPermutation {
	public static void main(String[] args) {
		int[] nums = { 1, 2, 3 };
		List<List<Integer>> permutations = permute1(nums);
		System.out.println("Permutations: " + permutations);
	}

	private static List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> list = new ArrayList<>();
		List<Integer> current = new ArrayList<>();
		boolean[] used = new boolean[nums.length];
		permute(list, used, current, nums);
		return list;
	}

	private static void permute(List<List<Integer>> list, boolean[] used, List<Integer> current, int[] nums) {
		if (current.size() == nums.length) {
			list.add(new ArrayList<>(current));
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			if (!used[i]) {
				current.add(nums[i]);
				used[i] = true;
				permute(list, used, current, nums);
				used[i] = false; // backtracking to make this element unused again.
				current.remove(current.size() - 1);
			}
		}

	}

	public static List<List<Integer>> permute1(int[] nums) {
		List<List<Integer>> list = new ArrayList<>();
		// Arrays.sort(nums); // not necessary
		backtrack(list, new ArrayList<>(), nums);
		return list;
	}

	private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums) {
		if (tempList.size() == nums.length) {
			list.add(new ArrayList<>(tempList));
		} else {
			for (int i = 0; i < nums.length; i++) {
				if (tempList.contains(nums[i]))
					continue; // element already exists, skip
				tempList.add(nums[i]);
				backtrack(list, tempList, nums);
				tempList.remove(tempList.size() - 1);
			}
		}
	}

}

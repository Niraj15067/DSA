package com.example.demo.arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MaxHeap1 {

	public static void main(String[] args) {

		ArrayList<Integer> maxHeap = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("Do you want to insert ? : ");
			if (!sc.nextBoolean())
				break;
			System.out.println("Enter the value : ");
			int val = sc.nextInt();
			insertInMaxHeap(val, maxHeap);
		}
		while (true) {
			System.out.println("Do you want to remove ? : ");
			if (!sc.nextBoolean())
				break;
			int removeMinFromHeap = removeMaxFromHeap(maxHeap);
			if(removeMinFromHeap==-1)
				break;
			System.out.println(removeMinFromHeap);
		}
		System.out.println(maxHeap);
		sc.close();
	}

	private static void insertInMaxHeap(int val, ArrayList<Integer> minHeap) {
		int idx = minHeap.size();
		minHeap.add(val);
		while (true) {
			int pIdx = (idx - 1) / 2;
			int pval = minHeap.get(pIdx);
			if (pval < val) {
				minHeap.set(pIdx, val);
				minHeap.set(idx, pval);
				idx = pIdx;
			} else {
				break;
			}
		}
	}

	private static int removeMaxFromHeap(ArrayList<Integer> minHeap) {
		int size = minHeap.size();
		if (size == 0) {
			return -1;
		}
		if(size==1) {
			return minHeap.remove(0);
		}
		int remove = minHeap.get(0);
		int current = minHeap.get(minHeap.size() - 1);
		minHeap.set(0, current);
		minHeap.remove(minHeap.size() - 1);
		int idx = 0;
		size -= 1;
		while (true) {
			current = minHeap.get(idx);
			int left = idx * 2 + 1;
			int right = idx * 2 + 2;
			int leftv = Integer.MIN_VALUE;
			int rightv = Integer.MIN_VALUE;
			if (left < size && current < minHeap.get(left)) {
				leftv = minHeap.get(left);
				minHeap.set(idx, leftv);
				minHeap.set(left, current);
				idx = left;

			} else if (right < size && current < minHeap.get(right)) {
				rightv = minHeap.get(right);
				minHeap.set(idx, rightv);
				minHeap.set(right, current);
				idx = right;
			} else {
				break;
			}
		}
		return remove;
	}
}

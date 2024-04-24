package com.example.demo.arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MinHeap {

	public static void main(String[] args) {
		ArrayList<Integer> minHeap = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("Do you want to insert ? : ");
			if (!sc.nextBoolean())
				break;
			System.out.println("Enter the value : ");
			int val = sc.nextInt();
			insertInMinHeap(val, minHeap);
			System.out.println(minHeap);
		}
		while (true) {
			System.out.println("Do you want to remove ? : ");
			if (!sc.nextBoolean())
				break;
			int removeMinFromHeap = removeMinFromHeap(minHeap);
			if (removeMinFromHeap == -1)
				break;
			System.out.println(removeMinFromHeap);
		}
		System.out.println(minHeap);
		sc.close();
	}

	private static void insertInMinHeap(int val, ArrayList<Integer> minHeap) {
		int idx = minHeap.size();
		minHeap.add(val);
		while (idx>0) {
			int pIdx = (idx - 1) / 2;
			int pval = minHeap.get(pIdx);
			if (pval > val) {
				minHeap.set(pIdx, val);
				minHeap.set(idx, pval);
				idx = pIdx;
			} else {
				break;
			}
		}
	}

	private static int removeMinFromHeap(ArrayList<Integer> minHeap) {
		int size = minHeap.size();
	    if (size == 0) {
	        return -1;
	    }
	    int remove = minHeap.get(0);
	    int current = minHeap.remove(size - 1);
	    if (size == 1) {
	        return remove;
	    }
	    minHeap.set(0, current);
	    int idx = 0;
	    while (true) {
	        int left = 2 * idx + 1;
	        int right = 2 * idx + 2;
	        int minIdx = idx;
	        if (left < minHeap.size() && minHeap.get(left) < minHeap.get(minIdx)) {
	            minIdx = left;
	        }
	        if (right < minHeap.size() && minHeap.get(right) < minHeap.get(minIdx)) {
	            minIdx = right;
	        }
	        if (minIdx != idx) {
	            int temp = minHeap.get(idx);
	            minHeap.set(idx, minHeap.get(minIdx));
	            minHeap.set(minIdx, temp);
	            idx = minIdx;
	        } else {
	            break;
	        }
	    }
	    return remove;
	}
}

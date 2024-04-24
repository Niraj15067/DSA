package com.example.demo.heap;

import java.util.ArrayList;

public class MaxHeapGeneric<T extends Comparable> {

	ArrayList<T> list ;
	public MaxHeapGeneric() {
		list = new ArrayList<>();
	}
	
	private int parent(int idx) {
		return (idx - 1) / 2;
	}

	private int left(int idx) {
		return idx * 2 + 1;
	}

	private int right(int idx) {
		return idx * 2 + 2;
	}
	private void swap(int first, int second) {
		T temp = list.get(first);
		list.set(first, list.get(second));
		list.set(second, temp);
		
	}
	private void insert(T value) {
		list.add(value);
		heapifyUp(list.size()-1);
	}
	
	
	private void heapifyUp(int index) {
		if(index ==0) {
			return;
		}
		int p = parent(index);
		if(list.get(p).compareTo(list.get(index))<0) {
			swap(index, p);
			heapifyUp(p);
		}
		
	}
	private T remove() throws Exception{
		if(list.isEmpty()) {
			throw new Exception("Cannot remove from empty list");
		}
		T remove = list.get(0);
		T last = list.remove(list.size()-1);
		if(!list.isEmpty()) {
			list.set(0, last);
			heapifyDown(0);
		}
		return remove;
		
	}

	private void heapifyDown(int index) {
		int max = index;
		int left = left(max);
		int right = right(max);
		
		if(left < list.size() && list.get(max).compareTo(list.get(left))<0) {
			max = left;
		}
		if(right < list.size() && list.get(max).compareTo(list.get(right))<0) {
			max = right;
		}
		if(max!=index) {
			swap(index,max);
			heapifyDown(max);
		}
		
	}

	public static void main(String[] args) throws Exception {
		MaxHeapGeneric<Integer> max = new MaxHeapGeneric<>();
		max.insert(10);
		max.insert(12);
		max.insert(8);
		max.insert(4);
		max.insert(20);
		
		System.out.println(max.remove());
		System.out.println(max.remove());
		System.out.println(max.remove());
		System.out.println(max.remove());

	}

}

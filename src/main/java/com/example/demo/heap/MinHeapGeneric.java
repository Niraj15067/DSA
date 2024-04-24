package com.example.demo.heap;

import java.util.ArrayList;

public class MinHeapGeneric<T extends Comparable<T>> {

	ArrayList<T> list;

	public MinHeapGeneric() {
		list = new ArrayList<>();
	}

	private void swap(int first, int second) {
		T temp = list.get(first);
		list.set(first, list.get(second));
		list.set(second, temp);
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

	private void insert(T value) {
		list.add(value);
		upHeap(list.size() - 1);
	}

	private void upHeap(int idx) {
		if (idx == 0) {
			return;
		}
		int p = parent(idx);
		if (list.get(idx).compareTo(list.get(p)) < 0) {
			swap(idx, p);
			upHeap(p);
		}
	}

	public T remove() throws Exception {
		if (list.isEmpty()) {
			throw new Exception("Cannot remove from an empty list.");
		}
		T remove = list.get(0);
		T last = list.remove(list.size() - 1);
		if (!list.isEmpty()) {
			list.set(0, last);
			downHeap(0);
		}

		return remove;
	}

	private void downHeap(int idx) {
		int l = left(idx);
		int r = right(idx);
		int min = idx;
		
		if(l<list.size() && list.get(min).compareTo(list.get(l))>0) {
			min = l;
		}
		if(r<list.size() && list.get(min).compareTo(list.get(r))>0) {
			min = r;
		}
		if(min!=idx) {
			swap(min,idx);
			downHeap(min);
		}
	}
	
	public ArrayList<T> heapSort() throws Exception{
		ArrayList<T> data = new ArrayList<>();
		while(!list.isEmpty()) {
			data.add(this.remove());
		}
		return data;
	}
	
	public static void main(String[] args) throws Exception {
		MinHeapGeneric<String> min = new MinHeapGeneric<>();
		min.insert("Siddhu");
		min.insert("Zoheb");
		min.insert("Niraj");
		min.insert("Palak");
		min.insert("Kabir");
		min.insert("Lucy");
		ArrayList<String> heapSort = min.heapSort();
		System.out.println(heapSort);
		System.out.println(min.remove());
		System.out.println(min.remove());
		System.out.println(min.remove());
		System.out.println(min.remove());
		System.out.println(min.remove());
		System.out.println(min.remove());
		System.out.println(min.remove());
	}
}

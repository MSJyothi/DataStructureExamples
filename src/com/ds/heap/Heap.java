package com.ds.heap;

import java.util.Arrays;

public class Heap {

	int[] items;
	int size;

	public Heap(int capacity) {
		items = new int[capacity];
	}

	public void insert(int value) {
		if (isFull()) {
			throw new IllegalStateException();
		}
		items[size++] = value;
		bubbleup();

	}

	public boolean isFull() {
		return size == items.length;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int remove() {
		if (isEmpty())
			throw new IllegalStateException();
        int root= items[0];
		items[0] = items[--size];
		items[size] = 0;
		bubbledown();
		return root;
	}
	
	

	private void bubbledown() {
		int index = 0;
		while (index <= size && !isValidParent(index)) {

			int largerChildIndex = largerChildIndex(index);

			swap(index, largerChildIndex);
			index = largerChildIndex;

		}

	}
	
	public int max() {
		if (isEmpty())
			throw new IllegalStateException();
        return items[0];
	}
	
	private int largerChildIndex(int index) {
		
		if(!hasLeftChild(index))
			return index;
		
		if(!hasRightChild(index))
			return leftChildIndex(index);
		
		return leftChild(index) >= rightChild(index) ? leftChildIndex(index)
				: rightChildIndex(index);
	}
	
	

	private boolean isValidParent(int index) {
		if(!hasLeftChild(index))
			return true;
		
		if(!hasRightChild(index))
			return items[index] >= leftChild(index);
		
		return (items[index] >= leftChild(index)) && (items[index] >= rightChild(index));

	}

	private int leftChild(int index) {
		return items[leftChildIndex(index)];
	}

	private int rightChild(int index) {
		return items[rightChildIndex(index)];

	}
	
	private boolean hasLeftChild(int index) {
		return leftChildIndex(index) <=size;
	}
	
	private boolean hasRightChild(int index) {
		return rightChildIndex(index) <=size;
	}

	private int leftChildIndex(int index) {
		return index * 2 + 1;
	}

	private int rightChildIndex(int index) {
		return index * 2 + 2;
	}

	private void bubbleup() {
		int index = size - 1;
		while (index > 0 && items[index] > items[parent(index)]) {
			swap(index, parent(index));
			index = parent(index);
		}

	}

	private int parent(int index) {
		return (index - 1) / 2;
	}

	private void swap(int first, int second) {
		int temp = items[second];
		items[second] = items[first];
		items[first] = temp;
	}

	public String toString() {
		return Arrays.toString(items);
	}
	
	public static void main(String[] args) {
		Heap heap = new Heap(6);
		heap.insert(1);
		heap.insert(2);
		heap.insert(3);
		heap.insert(4);
		heap.insert(5);
		heap.insert(6);
		System.out.println(heap);
		// the root node is always removed in heap
		System.out.println("item removed "+ heap.remove());
		System.out.println(heap);
	
	}

}

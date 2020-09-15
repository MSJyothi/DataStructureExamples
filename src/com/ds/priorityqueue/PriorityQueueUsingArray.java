package com.ds.priorityqueue;

import java.util.Arrays;

public class PriorityQueueUsingArray {

	int[] items;
	int size;

	public PriorityQueueUsingArray(int capacity) {
		items = new int[capacity];

	}

	public void add(int element) {

		if (isFull()) {
			throw new IllegalStateException();
		}

		int i;
		for (i = size - 1; i >= 0; i--) {
			if (element < items[i])
				items[i + 1] = items[i];
			else
				break;
		}

		items[i + 1] = element;
		size++;
		System.out.println();
	}

	public int remove() {
		if (isEmpty())
			throw new IllegalStateException();
		return items[--size];

	}

	public boolean isEmpty() {
		return size == 0;

	}

	public boolean isFull() {
		return size == items.length;

	}

	public String toString() {
		return Arrays.toString(items);
	}

	public static void main(String args[]) {

		PriorityQueueUsingArray queue = new PriorityQueueUsingArray(5);
		queue.add(5);
		queue.add(3);
		queue.add(6);
		queue.add(1);
		queue.add(2);
		System.out.println("Queue using Array : " + queue);
		System.out.println("Item removed : " + queue.remove());

	}

}

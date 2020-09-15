package com.ds.priorityqueue;

import com.ds.heap.Heap;

public class PriorityQueueUsingHeap {

	private Heap heap;

	public PriorityQueueUsingHeap(int capacity) {
		heap = new Heap(capacity);
	}

	public void enqueue(int value) {
		heap.insert(value);

	}

	public void dequeue() {
		heap.remove();

	}

	public boolean isEmpty() {
		return heap.isEmpty();
	}

	public String toString() {
		return heap.toString();
	}

	public static void main(String args[]) {

		PriorityQueueUsingHeap queue = new PriorityQueueUsingHeap(4);
		queue.enqueue(20);
		queue.enqueue(10);
		queue.enqueue(30);
		queue.enqueue(5);
		System.out.println("Queue using heap : " + queue);

	}

}

package cn.heap;

import cn.stack.Queue;

public class PriorityQueue<E extends Comparable<E>> implements Queue<E> {
	private MaxHeap<E> maxHeap;
	public PriorityQueue() {
		maxHeap = new MaxHeap<E>();
	}
	@Override
	public int getSize() {
		return maxHeap.size();
	}
	@Override
	public boolean isEmpty() {
		return maxHeap.isEmpty();
	}
	@Override
	public E dequence() {
		return maxHeap.extractMax();
	}
	@Override
	public E getFront() {
		return maxHeap.findMax();
	}
	@Override
	public void enquence(E e) {
		maxHeap.add(e);	
	}
}

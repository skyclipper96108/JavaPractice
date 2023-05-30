package cn.heap;

import cn.itsource.arraylist.Array;

public class MinHeap <E extends Comparable<E>>{
	private Array<E> data;
	public MinHeap(){
		data = new Array<>();
	}
	public MinHeap(int capacity){
		data = new Array<>(capacity);
	}
	// 返回堆中元素个数
	public int size() {
		return data.getSize();
	}
	public boolean isEmpty() {
		return data.isEmpty();
	}
	// 找某个索引的父亲结点
	private int parent(int index) {
		if(index==0)
			throw new IllegalArgumentException("index doesn't have parent");
		return (index-1)/2;
	}
	// 左孩子索引
	private int leftChild(int index) {
		return 2*index+1;
	}
	//右孩子索引
	private int rightChild(int index) {
		return 2*index+2;
	}
	// 向堆中添加元素
	public void add(E e) {
		data.addLast(e);
		siftUp(data.getSize()-1);
	}
	private void siftUp(int k) {
		while(k>0&&data.get(parent(k)).compareTo(data.get(k))>0) {
			data.swap(k, parent(k));
			k=parent(k);
		}
	}
	// 从堆中取出元素
	public E findMin() {
		if(data.getSize()==0)
			throw new IllegalArgumentException("The heap is empty");
		return data.get(0);
	}
	public E extractMin() {
		data.swap(0, data.getSize()-1);
		E ret = data.removeLast();
		siftDown(0);
		return ret;
	}
	private void siftDown(int k) {
		while(leftChild(k)<data.getSize()) {
			int j=leftChild(k);
			if(j+1<data.getSize()&&data.get(j+1).compareTo(data.get(j))<0)
				j=rightChild(k);
			if(data.get(k).compareTo(data.get(k))<=0)break;
			data.swap(k, j);
			k=j;
		}
	}
	public E replace(E e) {
		E ret=findMin();
		data.set(0, e);
		siftDown(0);
		return ret;
	}
}

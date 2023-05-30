package cn.heap;

import cn.itsource.arraylist.Array;

public class MaxHeap<E extends Comparable<E>> {
	private Array<E> data;
	public MaxHeap(){
		data=new Array<>();
	};
	public MaxHeap(int capacity) {
		data=new Array<>(capacity);
	}
	public MaxHeap(E[] arr) {
		data=new Array<>(arr);
		//对于最后一个叶子节点的父亲节点之前的元素进行下沉操作
		for(int i=parent(arr.length-1);i>=0;i--)
			siftDown(i);
	}
	// 返回堆中元素个数
	public int size() {
		return data.getSize();
	}
	public boolean isEmpty() {
		return data.isEmpty();
	}
	// 返回完全二叉树的数组表示中，一个索引所表示的父亲节点的索引
	private int parent(int index) {
		if(index==0)
			throw new IllegalArgumentException("index doesn't have parent");
		return (index-1)/2;
	}
	// 返回完全二叉树的数组表示中，一个索引所表示的元素左孩子节点索引
	private int leftChild(int index) {
		return index*2+1;
	}
	// 右孩子
	private int rightChild(int index) {
		return index*2+2;
	}
	// 向堆中添加元素，元素上浮
	public void add(E e) {
		data.addLast(e);
		siftUp(data.getSize()-1);
	}
	private void siftUp(int k) {
		while(k>0&&data.get(parent(k)).compareTo(data.get(k))<0) {
			data.swap(k, parent(k));
			k = parent(k);
		}
	}
	public E findMax(){
		if(data.getSize()==0)
			throw new IllegalArgumentException("the heap is empty");
		return data.get(0);
	}
	//从堆中取出元素，元素下沉
	public E extractMax() {
		E ret = findMax();
		data.swap(0, data.getSize()-1);
		data.removeLast();
		siftDown(0);
		return ret;
	}
	//实现堆中元素下称的方法
	private void siftDown(int k) {
		while(leftChild(k)<data.getSize()) {
			int j =leftChild(k);
			if(j+1<data.getSize()&&data.get(j+1).compareTo(data.get(j))>0)
				j=rightChild(k); // data[j]是leftChild和rightChild的最大值ֵ
			if(data.get(k).compareTo(data.get(j))>=0)break;
			data.swap(k, j);
			k=j;
		}
	}
	//取出堆中的最大元素，并且替换成元素e
	public E replace(E e) {
		E ret=findMax();
		data.set(0, e);
		siftDown(0);
		return ret;
	}

}

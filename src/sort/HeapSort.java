package sort;

import cn.heap.MaxHeap;

public class HeapSort implements SortMethod{
	public HeapSort(){}

	public <E extends Comparable<E>> void sort2(E[] data) {
		MaxHeap<E> maxHeap=new MaxHeap<>();
		for(E e: data)
			maxHeap.add(e);
		for(int i =data.length-1;i>=0;i--)
			data[i]=maxHeap.extractMax();
	}
	// ʹ��heapifyԭ�ض�����
	@Override
	public <E extends Comparable<E>> void sort(E[] data) {
		if(data.length<=1)return;
		//����һ��heapify����
		for(int i=(data.length-2)/2;i>=0;i--)
			siftDown(data, i, data.length);
		//���ν����Ѷ����Ԫ��[0]�����Ԫ��[i]��֮���³���Ԫ��
		for(int i=data.length-1;i>=0;i--) {
			swap(data,0,i);
			siftDown(data, 0, i);
		}
	}
	// ��data[0,n)�γɵ������У�����Ϊk��Ԫ�أ�ִ��siftDown
	private static<E extends Comparable<E>> void siftDown(E[] data, int k, int n) {
		while(2*k+1<n) {
			int j =2*k+1;
			if(j+1<n&&data[j+1].compareTo(data[j])>0)
				j++; // data[j]��leftChild��rightChild�����ֵ
			if(data[k].compareTo(data[j])>=0)break;
			swap(data,k, j);
			k=j;
		}
	}
	private static<E> void swap(E[] arr, int i, int j) {
		E t=arr[i];
		arr[i] = arr[j];
		arr[j]=t;
	}

}

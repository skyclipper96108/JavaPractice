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
	// 使用heapify原地堆排序
	@Override
	public <E extends Comparable<E>> void sort(E[] data) {
		if(data.length<=1)return;
		//进行一次heapify操作
		for(int i=(data.length-2)/2;i>=0;i--)
			siftDown(data, i, data.length);
		//依次交换堆顶最大元素[0]与最后元素[i]，之后下沉该元素
		for(int i=data.length-1;i>=0;i--) {
			swap(data,0,i);
			siftDown(data, 0, i);
		}
	}
	// 对data[0,n)形成的最大堆中，索引为k的元素，执行siftDown
	private static<E extends Comparable<E>> void siftDown(E[] data, int k, int n) {
		while(2*k+1<n) {
			int j =2*k+1;
			if(j+1<n&&data[j+1].compareTo(data[j])>0)
				j++; // data[j]是leftChild和rightChild的最大值
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

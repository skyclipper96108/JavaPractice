package cn.itsource.arraylist;

public class Array <E>{
	private E[] data;
	private int size;
	//构造函数，传入数组的容量capacity构造array
	@SuppressWarnings("unchecked")
	public Array(int capacity) {
		data = (E [])new Object[capacity];
		size = 0;
	}
	@SuppressWarnings("unchecked")
	public Array(E[] arr) {
		data=(E[])new Object[arr.length];
		for (int i=0; i<arr.length; i++)
			data[i]=arr[i];
		size=arr.length;
	}
	// 无参数的构造函数，默认数组的容量capacity=16
	public Array() {
		this(16);
	}

	public int getSize() {
		return size;
	}
	// 获取数组的容量
	public int getCapacity() {
		return data.length;
	}
	//返回数组是否为空
	public boolean isEmpty() {
		return size==0;
	}
	//向所有元素后添加新元素 O(1)
	public void addLast(E e) {
//		if(size == data.length)
//			throw new IllegalArgumentException("AddLast failed. Array is full.");
//		data[size] = e;
//		size ++;
		add(size, e);
	}
	// 向数组所有元素前添加新元素  O(n)
	public void addFirst(E e) {
		add(0, e);
	}
	// 向第index位置插入新元素e   O(n/2)=O(n)
	public void add(int index, E e) {
		if(size == data.length)
			resize(2*data.length);
		if(index<0||index>size)
			throw new IllegalArgumentException("AddLast failed. Require index>=0 and index<=size.");
		for(int i= size-1; i>=index; i--)
			data[i+1] = data[i];
		data[index]=e;
		size++;
	}
	//获取index索引位置的元素    O(1)
	public E get(int index) {
		if (index<0||index>=size)
			throw new IllegalArgumentException("Get failed. Index is illegal");
		return data[index];
	}
	public E getLast() {
		return get(size-1);
	}
	public E getFirst() {
		return get(0);
	}
	// 修改index索引位置的元素为e   O(1)
	public void set(int index, E e) {
		if (index<0||index>=size)
			throw new IllegalArgumentException("Get failed. Index is illegal");
		data[index] = e;
	}
	// 未知索引查找数组中是否有元素e  O(n)
	public boolean contains(E e) {
		for(E i: data) {
			if(i.equals(e))
				return true;
		}
		return false;
	}
	// 未知索引查找数组中元素e所在的索引，若没有返回-1  O(n)
	public int find(E e) {
		for(int i =0; i<size; i++) {
			if(data[i].equals(e))
				return i;
		}
		return -1;
	}

	// 从数组中删除指定索引的元素
	public E remove(int index) {
		if (index<0||index>=size)
			throw new IllegalArgumentException("Get failed. Index is illegal");
		E ret = data[index];
		for(int i =index+1; i<size; i++)
			data[i-1]=data[i];
		size--;
		if(size==data.length/4&&data.length/2!=0)  // Lazy策略
			resize(data.length/2);
		return ret;
	}
	//从数组中删除第一个元素和最后一个元素
	public E removeFirst() {
		return remove(0);
	}
	public E removeLast() {
		return remove(size-1);
	}
	// 从数组中删除元素e
	public void removeElement(E e) {
		int index = find(e);
		if(index!=-1)
			remove(index);
	}
	@Override
	public String toString(){
		StringBuilder res =new StringBuilder();
		res.append(String.format("Array:size=%d, capacity=%d\n", size, data.length));
		res.append('[');
		for(int i =0; i<size; i++) {
			res.append(data[i]);
			if(i!=size-1)
				res.append(",");
		}
		res.append(']');
		return res.toString();
	}
	public void swap(int i, int j) {
		if(i<0 || i>=size || j<0 || j>=size)
			throw new IllegalArgumentException("Index is illegal");
		E temp = 	data[i];
		data[i]=data[j];
		data[j]=temp;
	}

	// 实现动态数据arraylist
	@SuppressWarnings("unchecked")
	private void resize(int newCapacity) {
		E[] newData = (E[])new Object[newCapacity];
		for(int i=0; i<size;i++)
			newData[i] = data[i];
		data = newData;
	}
}

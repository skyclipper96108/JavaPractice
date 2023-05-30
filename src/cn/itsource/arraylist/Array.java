package cn.itsource.arraylist;

public class Array <E>{
	private E[] data;
	private int size;
	//���캯�����������������capacity����array
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
	// �޲����Ĺ��캯����Ĭ�����������capacity=16
	public Array() {
		this(16);
	}

	public int getSize() {
		return size;
	}
	// ��ȡ���������
	public int getCapacity() {
		return data.length;
	}
	//���������Ƿ�Ϊ��
	public boolean isEmpty() {
		return size==0;
	}
	//������Ԫ�غ������Ԫ�� O(1)
	public void addLast(E e) {
//		if(size == data.length)
//			throw new IllegalArgumentException("AddLast failed. Array is full.");
//		data[size] = e;
//		size ++;
		add(size, e);
	}
	// ����������Ԫ��ǰ�����Ԫ��  O(n)
	public void addFirst(E e) {
		add(0, e);
	}
	// ���indexλ�ò�����Ԫ��e   O(n/2)=O(n)
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
	//��ȡindex����λ�õ�Ԫ��    O(1)
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
	// �޸�index����λ�õ�Ԫ��Ϊe   O(1)
	public void set(int index, E e) {
		if (index<0||index>=size)
			throw new IllegalArgumentException("Get failed. Index is illegal");
		data[index] = e;
	}
	// δ֪���������������Ƿ���Ԫ��e  O(n)
	public boolean contains(E e) {
		for(E i: data) {
			if(i.equals(e))
				return true;
		}
		return false;
	}
	// δ֪��������������Ԫ��e���ڵ���������û�з���-1  O(n)
	public int find(E e) {
		for(int i =0; i<size; i++) {
			if(data[i].equals(e))
				return i;
		}
		return -1;
	}

	// ��������ɾ��ָ��������Ԫ��
	public E remove(int index) {
		if (index<0||index>=size)
			throw new IllegalArgumentException("Get failed. Index is illegal");
		E ret = data[index];
		for(int i =index+1; i<size; i++)
			data[i-1]=data[i];
		size--;
		if(size==data.length/4&&data.length/2!=0)  // Lazy����
			resize(data.length/2);
		return ret;
	}
	//��������ɾ����һ��Ԫ�غ����һ��Ԫ��
	public E removeFirst() {
		return remove(0);
	}
	public E removeLast() {
		return remove(size-1);
	}
	// ��������ɾ��Ԫ��e
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

	// ʵ�ֶ�̬����arraylist
	@SuppressWarnings("unchecked")
	private void resize(int newCapacity) {
		E[] newData = (E[])new Object[newCapacity];
		for(int i=0; i<size;i++)
			newData[i] = data[i];
		data = newData;
	}
}

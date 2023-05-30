package cn.stack;

public class ArrayDeque<E> implements Deque<E> {
	private E[] data;
	private int front, tail;
	private int size;
	// 由于使用 size，Deque实现不浪费空间
	@SuppressWarnings("unchecked")
	public ArrayDeque(int capacity) {
		data = (E[])new Object[capacity];
		front =0;
		tail =0;
		size=0;
	}
	public ArrayDeque() {
		this(8);
	}
	public int getCapacity() {
		return data.length;
	}
	@Override
	public int getSize() {
		return size;
	}
	@Override
	public boolean isEmpty() {
		return size==0;
	}
	@SuppressWarnings("unchecked")
	private void resize(int newCapacity) {
		E[] newData = (E[])new Object[newCapacity];
		for (int i=0; i<size; i++)
			newData[i]=data[(i+front)%data.length];
		data = newData;
		front =0;
		tail = size;
	}
	@Override
	public void addLast(E e) {
		if(size==getCapacity())
			resize(getCapacity()*2);
		data[tail] = e;
		tail = (tail+1)%data.length;
		size++;	
	}
	@Override
	public E removeLast() {
		if(isEmpty())
			throw new IllegalArgumentException("Cannot dequene from an empty queue.");
		E ret = data[tail-1];
		data[tail-1] = null;
		tail = tail==0?data.length-1:tail-1;
		size --;
		if(size<=getCapacity()/4&&getCapacity()/2!=0)
			resize(getCapacity()/2);
		return ret;
	}
	@Override
	public void addFront(E e) {
		if(size==getCapacity())
			resize(getCapacity()*2);
		front = front==0?data.length-1:front-1;
//		如果 front == 0，新的位置是 data.length - 1 的位置
		data[front]=e;
		size++;
	}
	@Override
	public E removeFront() {
		if(isEmpty())
			throw new IllegalArgumentException("Cannot dequene from an empty queue.");
		E ret = data[front];
		data[front] = null;
		front = (front+1)%data.length;
		size --;
		if(size<=getCapacity()/4&&getCapacity()/2!=0)
			resize(getCapacity()/2);
		return ret;
	}
	@Override
	public E getFront() {
		if(isEmpty())
			throw new IllegalArgumentException("The queue is empty.");
		return data[front];
	}
	@Override
	public E getLast() {
		if(isEmpty())
			throw new IllegalArgumentException("The queue is empty.");
		int index = tail==0?data.length-1:tail-1;
		return data[index];
	}
	@Override
	public String toString(){
		StringBuilder res =new StringBuilder();
		res.append(String.format("Queue: size=%d, capacity=%d\n", size, getCapacity()));
		res.append("front[");
		for(int i=0; i<size; i++) {
			res.append(data[(i+front)%data.length]);
			if(i!=size-1)
				res.append(",");
		}
		res.append("]tail");
		return res.toString();
	}
	
	
	
}

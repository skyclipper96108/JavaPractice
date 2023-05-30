package cn.stack;

public class LoopQueue<E> implements Queue<E>{
	private E[] data;
	private int front, tail;
	private int size;
	@SuppressWarnings("unchecked")
	public LoopQueue(int capacity) {
		data = (E[])new Object[capacity+1];
		front =0;
		tail =0;
		size=0;
	}
	public LoopQueue() {
		this(8);
	}
	public int getCapacity() {
		return data.length-1;
	}
	@Override
	public int getSize() {
		/**
		 * 完全不使用size，只使用front和tail来完成LoopQueue的所有逻辑
		 * if(tail>=front)return tail-front;
		 * if(tail<front)return data.length-(front-tail);
		 */
		return size;
	}
	@Override
	public boolean isEmpty() {
		return front==tail; //return size==0;
	}
	@SuppressWarnings("unchecked")
	private void resize(int newCapacity) {
		E[] newData = (E[])new Object[newCapacity+1];
		for (int i=0; i<size; i++)
			newData[i]=data[(i+front)%data.length];
		data = newData;
		front =0;
		tail = size;
	}
	@Override
	public void enquence(E e) {
		if((tail+1)%data.length==front)
			resize(getCapacity()*2);
		data[tail] = e;
		tail = (tail+1)%data.length;
		size++;	
	}
	@Override
	public E dequence() {
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
	public String toString(){
		StringBuilder res =new StringBuilder();
		res.append(String.format("Queue: size=%d, capacity=%d\n", size, getCapacity()));
		res.append("front[");
		for(int i =front; i!=tail; i=(i+1)%data.length) {
			res.append(data[i]);
			if((i+1)%data.length!=tail)
				res.append(",");
		}
		res.append("]tail");
		return res.toString();
	}
}

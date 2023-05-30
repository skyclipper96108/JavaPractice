package cn.stack;

import cn.itsource.arraylist.Array;
//���˳���dequenceΪO(n), ����ΪO(1)��ͨ������frontָ�������͸��Ӷ�(ת��Ϊѭ������)
public class ArrayQueue<E> implements Queue<E> {
	private Array<E> array;
	public ArrayQueue() {
		array = new Array<>();
	}
	public ArrayQueue(int capacity) {
		array = new Array<E>(capacity);
	}
	@Override
	public int getSize() {
		return array.getSize();
	}

	@Override
	public boolean isEmpty() {
		return array.isEmpty();
	}
	public int getCapacity() {
		return array.getCapacity();
	}
	
	@Override
	public void enquence(E e) {
		array.addLast(e);
		
	}

	@Override
	public E dequence() {
		return array.removeFirst();
	}

	@Override
	public E getFront() {
		return array.getFirst();
	}
	@Override
	public String toString() {
		StringBuilder res = new StringBuilder();
		res.append("Queue: ");
		res.append("head[");
		for(int i=0; i<array.getSize(); i++) {
			res.append(array.get(i));
			if(i!=array.getSize()-1)
				res.append(", ");
		}
		res.append("]tail");
		return res.toString();
	}
}

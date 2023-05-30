package cn.stack;

public interface Deque<E> {
	int getSize();
	boolean isEmpty();
	void addLast(E e);
	E removeFront();
	void addFront(E e);
	E removeLast();
	E getFront();
	E getLast();

}
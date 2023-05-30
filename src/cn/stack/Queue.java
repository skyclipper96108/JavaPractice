package cn.stack;

public interface Queue<E> {
	int getSize();
	boolean isEmpty();
	E dequence();
	E getFront();
	void enquence(E e);

}

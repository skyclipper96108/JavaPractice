package cn.stack;

/**
 * 后进先出的数据结构
 * Last In First Out
 * @param <E>
 */
public interface Stack<E> {
	int getSize();

	boolean isEmpty();
	//入栈
	void push(E e);
	//出栈
	E pop();
	//查看栈顶的元素
	E peek();

}

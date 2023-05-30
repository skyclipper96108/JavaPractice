package cn.stack;

/**
 * ����ȳ������ݽṹ
 * Last In First Out
 * @param <E>
 */
public interface Stack<E> {
	int getSize();

	boolean isEmpty();
	//��ջ
	void push(E e);
	//��ջ
	E pop();
	//�鿴ջ����Ԫ��
	E peek();

}

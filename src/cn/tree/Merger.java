package cn.tree;

/**
 * ����ʽ�ӿڣ�����������Ԫ�ص��ںϷ�ʽ
 * @param <E>
 */
public interface Merger<E> {


	E merge(E a, E b);
}

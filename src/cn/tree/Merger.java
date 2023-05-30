package cn.tree;

/**
 * 函数式接口，定义了两个元素的融合方式
 * @param <E>
 */
public interface Merger<E> {


	E merge(E a, E b);
}

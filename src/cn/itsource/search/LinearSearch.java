package cn.itsource.search;

public class LinearSearch {
	private LinearSearch() {}
	// 泛型接受的数据类型不可以是基本数据类型，只能是类对象
	public static <E> int search(E[] data, E target) {
		for(int i=0; i<data.length; i++)
			if(data[i].equals(target))
				return i;
		return -1;
	}
	/*
	 * 循环体的目的就是要维持循环不变量
	 * 复杂度分析：表示算法的性能
	 * 通常看最差的情况
	 * 算法运行的上界
	 */
}

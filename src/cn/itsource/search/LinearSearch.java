package cn.itsource.search;

public class LinearSearch {
	private LinearSearch() {}
	// ���ͽ��ܵ��������Ͳ������ǻ����������ͣ�ֻ���������
	public static <E> int search(E[] data, E target) {
		for(int i=0; i<data.length; i++)
			if(data[i].equals(target))
				return i;
		return -1;
	}
	/*
	 * ѭ�����Ŀ�ľ���Ҫά��ѭ��������
	 * ���Ӷȷ�������ʾ�㷨������
	 * ͨ�����������
	 * �㷨���е��Ͻ�
	 */
}

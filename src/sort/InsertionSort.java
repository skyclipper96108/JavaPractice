package sort;
/**
 * �����������飬��������ĸ��Ӷ���O(n)��
 * ���壬��������ĸ��Ӷ���Ȼ��O(n^2)��
 * ��˸��ʺϽ���Խ����������ݵ�����
 * @author zhangchujie
 *
 */
public class InsertionSort implements SortMethod{
	public InsertionSort() {}
//	public static <E extends Comparable<E>> void sort1(E[] arr) {
//		for(int i=0; i<arr.length; i++) {
//			// ��arr[i] ���뵽���ʵ�λ��
//			for(int j=i; j-1>=0 && arr[j].compareTo(arr[j-1])<0; j --)
//				swap(arr, j, j-1);		
//		}
//	}
		// ���������Ż���������Ԫ�ظ�Ϊ��ǰһ��Ԫ�ظ�ֵ������
		@Override
	public <E extends Comparable<E>> void sort(E[] arr) {
		for (int i=0; i<arr.length; i++) {
			E t = arr[i];
			int j;
			for(j=i; j-1>=0 && t.compareTo(arr[j-1])<0; j--)
				arr[j]=arr[j-1];
			arr[j] = t;
		}
	}
	public <E extends Comparable<E>> void sort2(E[] arr, int l, int r) {
		for (int i=l; i<=r; i++) {
			E t = arr[i];
			int j;
			for(j=i; j-1>=l && t.compareTo(arr[j-1])<0; j--)
				arr[j]=arr[j-1];
			arr[j] = t;
		}
	}
//	private static <E> void swap(E[] arr, int i, int j) {
//		// ��������
//		E x = arr[i];
//		arr[i]=arr[j];
//		arr[j] = x;
//	}

}

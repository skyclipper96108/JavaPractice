package sort;
/**
 * 对于有序数组，插入排序的复杂度是O(n)的
 * 整体，插入排序的复杂度依然是O(n^2)的
 * 因此更适合解决对近乎有序数据的排列
 * @author zhangchujie
 *
 */
public class InsertionSort implements SortMethod{
	public InsertionSort() {}
//	public static <E extends Comparable<E>> void sort1(E[] arr) {
//		for(int i=0; i<arr.length; i++) {
//			// 将arr[i] 插入到合适的位置
//			for(int j=i; j-1>=0 && arr[j].compareTo(arr[j-1])<0; j --)
//				swap(arr, j, j-1);		
//		}
//	}
		// 插入排序优化，将交换元素改为将前一个元素赋值到后面
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
//		// 交换方法
//		E x = arr[i];
//		arr[i]=arr[j];
//		arr[j] = x;
//	}

}

package sort;
/**
 * 基于比较的排序算法
 * @author zhangchujie
 * 复杂度分析：总共运行了i+(i-1)+...+3+2+1次
 * 时间复杂度O(n^2)
 */
public class SelectionSort implements SortMethod{
	public SelectionSort() {}

	@Override
	public <E extends Comparable<E>> void sort(E[] arr) {
		for(int i=0;i<arr.length;i++) {
			// 选择arr[i,,,n)中最小值的索引
			int minIndex = i;
			for(int j=i;j<arr.length;j++) {
           // if(arr[j]<arr[minIndex])
				if(arr[j].compareTo(arr[minIndex])<0)
					minIndex = j;
				
			}
			swap(arr, i , minIndex);
		}
	}
	private static <E> void swap(E[] arr, int i, int j) {
		// 交换方法
		E x = arr[i];
		arr[i]=arr[j];
		arr[j] = x;
	}

}

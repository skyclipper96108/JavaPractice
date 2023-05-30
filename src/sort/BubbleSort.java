package sort;

public class BubbleSort implements SortMethod {
	public BubbleSort(){};
	@Override
	public <E extends Comparable<E>> void sort(E[] arr) {
		for(int i=0; i<arr.length-1;) {
			// arr[n-i,n)已排好序， 在arr[n-i-1]位置上放置合适元素
			int lastSwappedIndex=0;
			for(int j=0; j<arr.length-i-1; j++)
				if(arr[j].compareTo(arr[j+1])>0) {
					swap(arr,j,j+1);
					//j+1之后的元素已经有序
					lastSwappedIndex=j+1;
				}
			//此时有多少个元素排好
			i=arr.length-lastSwappedIndex;
		}
	}
	private static <E> void swap(E[] arr, int i, int j) {
		// 交换方法
		E x = arr[i];
		arr[i]=arr[j];
		arr[j] = x;
	}
}

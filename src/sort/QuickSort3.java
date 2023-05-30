package sort;

import java.util.Random;

public class QuickSort3 implements SortMethod {

	private static<E> void swap(E[] arr, int i, int j) {
		E t =arr[i];
		arr[i] = arr[j];
		arr[j] = t;
	}
	// 三路快排
	@Override
	public <E extends Comparable<E>> void sort(E[] arr) {
		Random rnd = new Random();
		sort(arr, 0, arr.length-1, rnd);
	}
	private static <E extends Comparable<E>> void sort(E[] arr, int l, int r, Random rnd) {
		if(r-l<=15) {
			(new InsertionSort()).sort2(arr, l, r);
			return;
		}
		// 对于有序数组排序的优化：生成[l,r]之间的随机索引
		int p = l+rnd.nextInt(r-l+1);
		swap(arr,l,p);
		// arr[l+1,lt]<v, arr[lt+1,i-1]==v, arr[gt, r]>v
		int i =l+1, lt =l, gt = r+1;
		while(i<gt) {
			if(arr[i].compareTo(arr[l])<0) {
				lt++;
				swap(arr, i, lt);
				i++;
			}else if(arr[i].compareTo(arr[l])>0) {
				gt--;
				swap(arr, i, gt);			
			}else //(arr[i].compareTo(arr[l])==0)
				i++;
		}
		swap(arr, l, lt);
		sort(arr, l, lt-1, rnd);
		sort(arr, gt, r, rnd);
	}
}

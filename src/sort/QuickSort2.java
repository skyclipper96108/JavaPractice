package sort;

import java.util.Random;

public class QuickSort2 implements SortMethod {


	public <E extends Comparable<E>> void sort0(E[] arr) {
		Random rnd = new Random();
		sort0(arr, 0, arr.length-1, rnd);
	}
	private static <E extends Comparable<E>> void sort0(E[] arr, int l, int r, Random rnd) {
		if(r-l<=15) {
			(new InsertionSort()).sort2(arr, l, r);
			return;
		}
		int p = partition0(arr, l, r, rnd);
		sort0(arr, l, p-1, rnd);
		sort0(arr,p+1,r, rnd);

	}
	private static <E extends Comparable<E>> int partition0(E[] arr, int l, int r, Random rnd) {
		// 对于有序数组排序的优化：生成[l,r]之间的随机索引，避免产生递归深度过大的问题
		// 生成一个[0,r-l]区间随机值
		int p = l+rnd.nextInt(r-l+1);
		swap(arr,l,p);
		// arr[l+1.....j]<v; arr[j+1...i]>v
		int j = l;
		for(int i = l+1; i<=r; i++)
			if(arr[i].compareTo(arr[l])<0) {
				j++;
				swap(arr, i, j);
			}
		swap(arr, l, j);
		return j;
	}
	private static<E> void swap(E[] arr, int i, int j) {
		E t =arr[i];
		arr[i] = arr[j];
		arr[j] = t;
	}
	// 双路快排
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
		int p = partition(arr, l, r, rnd);
		sort(arr, l, p-1, rnd);
		sort(arr,p+1,r, rnd);

	}
	private static <E extends Comparable<E>> int partition(E[] arr, int l, int r, Random rnd) {
		// 对于有序数组排序的优化：生成[l,r]之间的随机索引
		int p = l+rnd.nextInt(r-l+1);
		swap(arr,l,p);
		// arr[l+1.....i-1]<=v; arr[j+1...r]>=v
		int i = l+1; int j=r;
		while(true) {
			while(i<=j&&arr[i].compareTo(arr[l])<0)i++;
			while(j>=i&&arr[j].compareTo(arr[l])>0)j--;
			if(i>=j)break;
			swap(arr, i, j);
			i++;
			j--;
		}
		swap(arr, l, j);
		return j;
	}

}

package sort;

import java.util.Arrays;
/**
 * 自顶向下的归并排序
 * @author zhangchujie
 *
 */
public class MergeSort implements SortMethod {
	public MergeSort() {}
	@Override
	public <E extends Comparable<E>> void sort(E[] arr) {
		//优化3 提前开辟temp空间，以免后面重复开空间造成浪费
		E[] temp = Arrays.copyOf(arr, arr.length);
		sort(arr, 0, arr.length, temp);
	}
	private <E extends Comparable<E>> void sort(E[] arr, int l, int r, E [] temp) {
//		if(l>r)return;
		//优化2 当数组长度不大时，采用插入排序法
		if(r-l<=16) {
			(new InsertionSort()).sort2(arr, l, r-1);
			return;
		}
		int mid = l+(r-l)/2;
		sort(arr, l, mid, temp);
		sort(arr, mid, r, temp);
		//优化1 归并前两个数组已经有序
		if(arr[mid-1].compareTo(arr[mid])>0)
			merge(arr, l, mid, r, temp);
	}
	// 合并两个有序的区间arr[l,mid]和arr[mid+l,r]
	private static<E extends Comparable<E>> void merge(E[] arr, int l, int mid, int r, E[] temp) {
		System.arraycopy(arr, l, temp, l, r-l);
		int i =l; int j = mid;
		for(int k=l; k<r; k++) {
			if(i>=mid) {
				arr[k] = temp[j];j++;
			}else if(j>=r) {
				arr[k]=temp[i];i++;
			}else if(temp[i].compareTo(temp[j])<=0) {
				arr[k] = temp[i]; i++;
			}else {
				arr[k] = temp[j]; j++;
			}
		}
	}
	// 自底向上的归并排序
	public <E extends Comparable<E>> void sortBU(E[] arr) {
		E[] temp = Arrays.copyOf(arr, arr.length);
		int n = arr.length;
		// 遍历合并的区间长度
		for(int sz = 1;sz<n;sz+=sz) {
			// 遍历合并的两个区间的起始位置i
			// 合并[i,i+sz-1]和[i+sz,i+sz+sz-1]
			for(int i =0;i+sz<n ;i+=sz+sz)
				if(arr[i+sz-1].compareTo(arr[i+sz])>0)
					merge(arr, i, i+sz-1, Math.min(i+sz+sz-1,n-1),temp);
		}
	}
}

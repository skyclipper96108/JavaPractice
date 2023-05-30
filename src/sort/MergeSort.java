package sort;

import java.util.Arrays;
/**
 * �Զ����µĹ鲢����
 * @author zhangchujie
 *
 */
public class MergeSort implements SortMethod {
	public MergeSort() {}
	@Override
	public <E extends Comparable<E>> void sort(E[] arr) {
		//�Ż�3 ��ǰ����temp�ռ䣬��������ظ����ռ�����˷�
		E[] temp = Arrays.copyOf(arr, arr.length);
		sort(arr, 0, arr.length, temp);
	}
	private <E extends Comparable<E>> void sort(E[] arr, int l, int r, E [] temp) {
//		if(l>r)return;
		//�Ż�2 �����鳤�Ȳ���ʱ�����ò�������
		if(r-l<=16) {
			(new InsertionSort()).sort2(arr, l, r-1);
			return;
		}
		int mid = l+(r-l)/2;
		sort(arr, l, mid, temp);
		sort(arr, mid, r, temp);
		//�Ż�1 �鲢ǰ���������Ѿ�����
		if(arr[mid-1].compareTo(arr[mid])>0)
			merge(arr, l, mid, r, temp);
	}
	// �ϲ��������������arr[l,mid]��arr[mid+l,r]
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
	// �Ե����ϵĹ鲢����
	public <E extends Comparable<E>> void sortBU(E[] arr) {
		E[] temp = Arrays.copyOf(arr, arr.length);
		int n = arr.length;
		// �����ϲ������䳤��
		for(int sz = 1;sz<n;sz+=sz) {
			// �����ϲ��������������ʼλ��i
			// �ϲ�[i,i+sz-1]��[i+sz,i+sz+sz-1]
			for(int i =0;i+sz<n ;i+=sz+sz)
				if(arr[i+sz-1].compareTo(arr[i+sz])>0)
					merge(arr, i, i+sz-1, Math.min(i+sz+sz-1,n-1),temp);
		}
	}
}

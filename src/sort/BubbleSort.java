package sort;

public class BubbleSort implements SortMethod {
	public BubbleSort(){};
	@Override
	public <E extends Comparable<E>> void sort(E[] arr) {
		for(int i=0; i<arr.length-1;) {
			// arr[n-i,n)���ź��� ��arr[n-i-1]λ���Ϸ��ú���Ԫ��
			int lastSwappedIndex=0;
			for(int j=0; j<arr.length-i-1; j++)
				if(arr[j].compareTo(arr[j+1])>0) {
					swap(arr,j,j+1);
					//j+1֮���Ԫ���Ѿ�����
					lastSwappedIndex=j+1;
				}
			//��ʱ�ж��ٸ�Ԫ���ź�
			i=arr.length-lastSwappedIndex;
		}
	}
	private static <E> void swap(E[] arr, int i, int j) {
		// ��������
		E x = arr[i];
		arr[i]=arr[j];
		arr[j] = x;
	}
}

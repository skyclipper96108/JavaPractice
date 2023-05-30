package sort;

/**
 * 对元素间距为n/2的所有数组做插入排序
 * 对元素间距为n/4的所有数组做插入排序
 * 对元素间距为n/8的所有数组做插入排序
 * 对元素间距为1的所有数组做插入排序
 * 完全使用循环的方法实现的高性能排序算法
 */
public class ShellSort implements SortMethod{

	public <E extends Comparable<E>> void sort0(E[] arr) {
		int h=arr.length/2;
		while(h>=1) {
			// 对data[start,start+h,start+2h,start+3h,...],进行插入排序
			for(int start=0; start<h; start++) {
				//对以start为起始，间隔为h的数组进行插入排序
				for(int i= start+h;i<arr.length;i+=h){
					E t = arr[i];
					int j;
					for(j=i;j-h>=0&&t.compareTo(arr[j-h])<0;j-=h){
						arr[j]=arr[j-h];
					}
					arr[j] = t;
				}
			}

			h/=2;
		}

	}

	@Override
	public <E extends Comparable<E>> void sort(E[] arr) {
		int h=arr.length/2; //可使用不同的步长序列来实现希尔排序（超参数）
		while(h>=1) {
			// 对data[start,start+h,start+2h,start+3h,...],进行插入排序
		    // 从h开始判断是否需要进行插入排序
				for(int i=h; i<arr.length; i++) {
					E t=arr[i];
					int j;
					for(j=i; j-h>=0&&t.compareTo(arr[j-h])<0;j-=h)
						arr[j]=arr[j-h];
					arr[j]=t;
				}

			h/=2;
		}

	}

}

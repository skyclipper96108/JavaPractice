package cn.itsource.search;


public class BinarySearch {
	private BinarySearch() {}
	public static <E extends Comparable<E>> int search(E[] data, E target) {
		
		// 查找区间为[l, r] 
		return search(data, 0, data.length-1, target);
		
	}
	private static <E extends Comparable<E>> int search(E[] data, int l, int r, E target) {
		if(l>r) return -1;
		int mid = l+(r-l/2);
		if(data[mid].compareTo(target)==0)return mid;
		else if(data[mid].compareTo(target)<0)return search(data,mid+1,r,target);
		else return search(data, l, mid-1, target);
	}
	// 非递归写法
	public static <E extends Comparable<E>> int search2(E[] data, E target) {
		int l = 0, r = data.length;
		while(l<=r) {
			int mid = l+(l-r)/2;
			if(data[mid].compareTo(target)==0)return mid;
			else if(data[mid].compareTo(target)<0)l=mid+1;
			else r = mid-1;
		}
		return -1;
		
	}
	// 大于target的最小索引 即// 查找区间为[l, r]
	public static <E extends Comparable<E>> int upper(E[] data, E target) {
		int l = 0, r=data.length;
		// 查找区间为[l, r) 
		while(l<r) {
			int mid = l+(r-l)/2;
			if(data[mid].compareTo(target)<=0)l=mid+1;
			else r=mid;
		}
		return l;		
	}
	/**
	 * ceil 如果数组中存在元素则返回最大索引
	 * 如果数组中不存在元素则返回upper
	 */
	public static <E extends Comparable<E>> int ceil(E[] data, E target) {
		int u = upper(data, target);
		if(u-1>=0&&data[u-1].compareTo(target)==0)
			return u-1;
		return u;
	}
	// lower_ceil 大于等于target的最小索引
	public static <E extends Comparable<E>> int lower_ceil(E[] data, E target) {
		int u = upper(data, target);
		while(u-1>=0&&data[u-1].compareTo(target)==0)u--;
		return u;
	}
	// 小于target的最大索引
	public static <E extends Comparable<E>> int lower(E[] data, E target) {
		int l=-1, r=data.length-1;
		while(l<r) {
			// 计算机默认取左边界，要改为取右边界 要保证左边界一定会增加
			int mid=l+(r-l+1)/2;
			if(data[mid].compareTo(target)>=0)r=mid-1;
			else l =mid;
		}
		return r;
	}
	/**
	 * ceil 如果数组中存在元素则返回最大索引
	 * 如果数组中不存在元素则返回upper
	 */
	public static <E extends Comparable<E>> int lower_floor(E[] data, E target) {
		int l = lower(data, target);
		if(l+1<data.length&&data[l+1].compareTo(target)==0)
			return l+1;
		return l;
	}
	// upper_floor 小于等于target的最大索引
	public static <E extends Comparable<E>> int upper_floor(E[] data, E target) {
		int l = lower(data, target);
		while(l+1<data.length&&data[l+1].compareTo(target)==0)l++;
		return l;
	}
}

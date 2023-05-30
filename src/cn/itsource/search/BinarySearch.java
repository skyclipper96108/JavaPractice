package cn.itsource.search;


public class BinarySearch {
	private BinarySearch() {}
	public static <E extends Comparable<E>> int search(E[] data, E target) {
		
		// ��������Ϊ[l, r] 
		return search(data, 0, data.length-1, target);
		
	}
	private static <E extends Comparable<E>> int search(E[] data, int l, int r, E target) {
		if(l>r) return -1;
		int mid = l+(r-l/2);
		if(data[mid].compareTo(target)==0)return mid;
		else if(data[mid].compareTo(target)<0)return search(data,mid+1,r,target);
		else return search(data, l, mid-1, target);
	}
	// �ǵݹ�д��
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
	// ����target����С���� ��// ��������Ϊ[l, r]
	public static <E extends Comparable<E>> int upper(E[] data, E target) {
		int l = 0, r=data.length;
		// ��������Ϊ[l, r) 
		while(l<r) {
			int mid = l+(r-l)/2;
			if(data[mid].compareTo(target)<=0)l=mid+1;
			else r=mid;
		}
		return l;		
	}
	/**
	 * ceil ��������д���Ԫ���򷵻��������
	 * ��������в�����Ԫ���򷵻�upper
	 */
	public static <E extends Comparable<E>> int ceil(E[] data, E target) {
		int u = upper(data, target);
		if(u-1>=0&&data[u-1].compareTo(target)==0)
			return u-1;
		return u;
	}
	// lower_ceil ���ڵ���target����С����
	public static <E extends Comparable<E>> int lower_ceil(E[] data, E target) {
		int u = upper(data, target);
		while(u-1>=0&&data[u-1].compareTo(target)==0)u--;
		return u;
	}
	// С��target���������
	public static <E extends Comparable<E>> int lower(E[] data, E target) {
		int l=-1, r=data.length-1;
		while(l<r) {
			// �����Ĭ��ȡ��߽磬Ҫ��Ϊȡ�ұ߽� Ҫ��֤��߽�һ��������
			int mid=l+(r-l+1)/2;
			if(data[mid].compareTo(target)>=0)r=mid-1;
			else l =mid;
		}
		return r;
	}
	/**
	 * ceil ��������д���Ԫ���򷵻��������
	 * ��������в�����Ԫ���򷵻�upper
	 */
	public static <E extends Comparable<E>> int lower_floor(E[] data, E target) {
		int l = lower(data, target);
		if(l+1<data.length&&data[l+1].compareTo(target)==0)
			return l+1;
		return l;
	}
	// upper_floor С�ڵ���target���������
	public static <E extends Comparable<E>> int upper_floor(E[] data, E target) {
		int l = lower(data, target);
		while(l+1<data.length&&data[l+1].compareTo(target)==0)l++;
		return l;
	}
}

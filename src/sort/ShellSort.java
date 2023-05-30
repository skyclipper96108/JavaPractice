package sort;

/**
 * ��Ԫ�ؼ��Ϊn/2��������������������
 * ��Ԫ�ؼ��Ϊn/4��������������������
 * ��Ԫ�ؼ��Ϊn/8��������������������
 * ��Ԫ�ؼ��Ϊ1��������������������
 * ��ȫʹ��ѭ���ķ���ʵ�ֵĸ����������㷨
 */
public class ShellSort implements SortMethod{

	public <E extends Comparable<E>> void sort0(E[] arr) {
		int h=arr.length/2;
		while(h>=1) {
			// ��data[start,start+h,start+2h,start+3h,...],���в�������
			for(int start=0; start<h; start++) {
				//����startΪ��ʼ�����Ϊh��������в�������
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
		int h=arr.length/2; //��ʹ�ò�ͬ�Ĳ���������ʵ��ϣ�����򣨳�������
		while(h>=1) {
			// ��data[start,start+h,start+2h,start+3h,...],���в�������
		    // ��h��ʼ�ж��Ƿ���Ҫ���в�������
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

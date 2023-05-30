package sort;


public class SortingHelper {

	public SortingHelper() {}
	public static <E extends Comparable<E>> boolean isSorted(E[] arr) {
		for(int i=1; i<arr.length; i++)
			if(arr[i-1].compareTo(arr[i])>0) {
				System.out.println("出错了————————"+i);
				System.out.println("出错了————————"+arr[i]);
				return false;
			}
		return true;
	}
	
	public static <E extends Comparable<E>>void sortTest(String sortname, E[] arr) throws InstantiationException, IllegalAccessException, ClassNotFoundException  {
		long startTime = System.nanoTime();
		
		SortMethod sortmethod = (SortMethod)Class.forName("sort."+sortname).newInstance();
		sortmethod.sort(arr);
//		if(sortname.equals("SelectionSort"))
//			SelectionSort.sort(arr);
//		else if(sortname.equals("InsertionSort"))
//			InsertionSort.sort2(arr);
		long endTime = System.nanoTime();
		double time = (endTime-startTime)/1000000000.0;
		if( !SortingHelper.isSorted(arr)) {
			for(int i=0; i<arr.length; i++)
				System.out.println(arr[i]);
			throw new RuntimeException(sortname+" failed");
		}
		System.out.println(String.format("%s, n=%d, time: %f s",sortname, arr.length,time));
	}
}

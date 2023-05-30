package cn.itsource.search;

public class Main_test {
	public static void main(String[] args) {
//		Integer[] data= {24,54,75,15,28,16,34,26,17,39};
//		int res1 = LinearSearch.search(data, 16);
//		System.out.println(res1);
//		Student[] stuList= {new Student("kevin", 1),
//									  new Student("bobo", 2),
//									  new Student("baba", 3),
//									  new Student("kevin", 5)};
//		Student sb = new Student("kevin",4);
//		int res2 = LinearSearch.search(stuList, sb);
//		System.out.println(res2);
		int n = 23143320;
		Integer[] data = ArrayGenerator.generateOrderedArray(n);
		long startTime = System.nanoTime();
		for(int k =0;k<100;k++)
			LinearSearch.search(data, n);
		long endTime = System.nanoTime();
	    double time =  (endTime-startTime)/1000000000.0;
		System.out.println("n="+n+",100 runs"+time+"s");
		long startTime2 = System.nanoTime();
		for(int k =0;k<100;k++)
			BinarySearch.search(data, n);
		long endTime2 = System.nanoTime();
	    double time2 =  (endTime2-startTime2)/1000000000.0;
		System.out.println("n="+n+",100 runs"+time2+"s");
		Integer[] arr = {1,1,3,3,5,5};
		for(int i=0; i<=6; i++)
			System.out.print(BinarySearch.lower(arr, i)+" ");
		System.out.println();
		}
}

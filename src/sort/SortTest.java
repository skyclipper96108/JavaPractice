package sort;

import java.util.Arrays;

public class SortTest {

	public static void main(String[] args) {
		Integer[] arr1= {1,4,2,3,6,5};
		try {
			SortingHelper.sortTest("SelectionSort", arr1);
			for(int e: arr1)
				System.out.print(e+" ");
			System.out.println();
			
			
			Student[] stuList= {new Student("kevin", 4534),
					new Student("bobo", 2643),
					new Student("baba",1364),
					new Student("kevin", 3463)};
			SortingHelper.sortTest("SelectionSort", stuList);
			for(Student student: stuList)
				System.out.print(student+" ");
			System.out.println();
			
			//≤‚ ‘À„∑®–‘ƒ‹
			int [] dataSize = {10000, 100000};
			for(int n:dataSize) {
				Integer[] arr2 = ArrayGenerator.generateRandomArray(n, n);
				Integer[] arr3 = Arrays.copyOf(arr2, arr2.length);
				Integer[] arr4 = Arrays.copyOf(arr2, arr2.length);
				Integer[] arr5 = Arrays.copyOf(arr2, arr2.length);
				Integer[] arr6 = Arrays.copyOf(arr2, arr2.length);
				Integer[] arr7 = Arrays.copyOf(arr2, arr2.length);
				SortingHelper.sortTest("SelectionSort", arr2);
				SortingHelper.sortTest("InsertionSort", arr3);
				SortingHelper.sortTest("MergeSort", arr4);
				SortingHelper.sortTest("QuickSort2", arr5);
				SortingHelper.sortTest("HeapSort", arr6);
				SortingHelper.sortTest("ShellSort", arr7);
				}
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		
		
	}

}

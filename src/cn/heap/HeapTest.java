package cn.heap;

import java.util.Random;

import org.junit.Test;

public class HeapTest {
	private static double testHeap(Integer[] testData, boolean isHeapify) {
		long startTime = System.nanoTime();
		MaxHeap<Integer>maxHeap;
		if(isHeapify)
			maxHeap=new MaxHeap<>(testData);
		else {
			maxHeap=new MaxHeap<>();
			for(int num: testData)
				maxHeap.add(num);
		}
		//验证是否正常排序
		int[] arr=new int[testData.length];
		for(int i=0; i<testData.length; i++)
			arr[i]=maxHeap.extractMax();
		for(int i=1; i<testData.length; i++)
			if(arr[i-1]<arr[i])
				throw new IllegalArgumentException("Error");
		System.out.println("Test completed");
		long endTime= System.nanoTime();
		return (endTime-startTime)/1000000000.0;
	}
	@Test
	public void testHeap() throws Exception{
		int n = 1000000;
		Random random = new Random();
		Integer[] testData = new Integer[n];
		for(int i=0; i<n; i++)
			testData[i] = random.nextInt(Integer.MAX_VALUE);
		double time1 = testHeap(testData, false);
		System.out.println("without heapify:"+time1);
		double time2 = testHeap(testData, true);
		System.out.println("with heapify:"+time2);
	}

}

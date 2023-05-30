package cn.stack;

import java.util.Random;

public class StackTest {
	// 测试使用q运行opCount个enqueue和dequeue操作所需要的时间
	private static double testQueue(Queue<Integer> q, int opCount) {
		long startTime = System.nanoTime();
		Random random = new Random();
		for(int i=0; i<opCount; i++)
			q.enquence(random.nextInt(Integer.MAX_VALUE));
		for(int i=0;i<opCount;i++)
			q.dequence();
		long endTime =System.nanoTime();
		return (endTime-startTime)/1000000000.0;		
	}

	public static void main(String[] args) {
	 ArrayStack<Integer> stack = new ArrayStack<>();
		for(int i =0; i<7; i++) {
			stack.push(i);
			System.out.println(stack);
		}
		stack.pop();
		System.out.println(stack);
		
		ArrayQueue<Integer> queue1 = new ArrayQueue<>();
		for(int i =0; i<10; i++) {
			queue1.enquence(i);
			System.out.println(queue1);
			if(i%3 == 2) {
				queue1.dequence();
				System.out.println(queue1);
			}
		}
		LoopQueue<Integer> queue2 = new LoopQueue<>();
		for(int i =0; i<20; i++) {
			queue2.enquence(i);
			System.out.println(queue2);
			if(i%3 == 2) {
				queue2.dequence();
				System.out.println(queue2);
			}
		}
		LinkedListQueue<Integer> queue3 = new LinkedListQueue<>();
		for(int i =0; i<20; i++) {
			queue3.enquence(i);
			System.out.println(queue3);
			System.out.println(queue3.isEmpty());
			if(i%3 == 2) {
				queue3.dequence();
				System.out.println(queue3);
			}
		}
		int opCount = 100000;
		double time1 = testQueue(queue1, opCount);
		System.out.println("ArrayQueue, time: "+time1+"s");
		double time2 = testQueue(queue2, opCount);
		System.out.println("LoopQueue, time: "+time2+"s");
		double time3 = testQueue(queue3, opCount);
		System.out.println("LinkedListQueue, time: "+time3+"s");
	}

}

package cn.linkedlist;

public class LinkedListTest {

	public static void main(String[] args) {
		LinkedList<Integer> L1 = new LinkedList<>();
		for(int i=0; i<7; i++) {
			L1.addFirst(i);
			System.out.println(L1);
		}
		L1.add(3, 325);
		System.out.println(L1);
		L1.remove(2);
		System.out.println(L1);
		L1.removeFirst();
		L1.removeLast();
		System.out.println(L1);
	}

}

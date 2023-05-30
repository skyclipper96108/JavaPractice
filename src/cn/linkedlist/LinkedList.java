package cn.linkedlist;
public class LinkedList<E> {
	private class Node{
		public E e;
		public Node next;
		public Node(E e, Node next) {
			this.e = e;
			this.next = next;
		}
		public Node(E e) {
			this(e, null);
		}
		public Node() {
			this(null, null);
		}
		@Override
		public String toString() {
			return e.toString();
		}
	}
	private Node dummyhead;
	private int size;
	public LinkedList() {
		dummyhead = new Node();
		// ʹ������ͷ���
		size = 0;
	}
	// ��ȡ�����е�Ԫ�ظ���
	public int getSize() {
		return size;
	}
	// ���������Ƿ�Ϊ��
	public boolean isEmpty() {
		return size==0;
	}
	//����ͷ�����Ԫ��
	public void addFirst(E e) {
		
//		Node node = new Node(e);
//		node.next = head;
//		head = node;
		add(0,e);
	}
	// �������indexλ������µ�Ԫ��
	public void add(int index, E e) {
		if(index<0||index>size)
			throw new IllegalArgumentException("Add failed. Illegal index");
		
		Node prev =dummyhead;
		for(int i=0; i<index; i++)
			prev = prev.next;
		Node node =new Node(e);
		node.next = prev.next;
		prev.next = node;
//		prev.next = new Node(e, prev.next);
		size++;
		
	}
	public void addLast(E e) {
		add(size, e);
	}
	// ���������ҵ�ָ��������Ԫ��
	public E get(int index) {
		if(index<0 || index>=size)
			throw new IllegalArgumentException("Get failed. Illegal index. ");
		Node cur = dummyhead.next;
		for(int i=0; i<index; i++)
			cur = cur.next;
		return cur.e;
	}
	public E getFirst() {
		return get(0);
	}
	public E getLast() {
		return get(size-1);
	}
	// �޸�����ĵ�index��λ��Ԫ��
	public void set(int index, E e) {
		if(index<0 || index>=size)
			throw new IllegalArgumentException("Get failed. Illegal index. ");
		Node cur = dummyhead.next;
		for(int i=0; i<index; i++)
			cur = cur.next;
		cur.e = e;
	}
	// ���������Ƿ���Ԫ��e
	public boolean contains(E e) {
		Node cur = dummyhead.next;
		while(cur!=null){
			if(cur.e.equals(e))
				return true;
			cur=cur.next;
		}
		return false;
	}
	@Override
	public String toString() {
		StringBuilder res = new StringBuilder();
//		Node cur = dummyhead.next;
//		while(cur!=null){
//				res.append(cur+"��");
//				cur = cur.next;
//		}
		for(Node cur = dummyhead.next; cur!=null; cur=cur.next)
			res.append(cur+"��");
		res.append("Null");
		return res.toString();			
	}
	// ��������ɾ��Ԫ��
	public E remove(int index) {
		if(index<0 || index>=size)
			throw new IllegalArgumentException("Get failed. Illegal index. ");
		Node prev = dummyhead;
		for(int i=0; i<index; i++)
			prev = prev.next;
		Node retNode = prev.next;
		prev.next = retNode.next;
		retNode.next = null;
		size --;
		return retNode.e;
	}
	public E removeFirst() {
		return remove(0);
	}
	public E removeLast() {
		return remove(size-1);
	}
	public void removeElement(E e) {
		Node cur = dummyhead.next;
		for(int i=0; i<size; i++) {
			if(cur.e==e) {
				remove(i);
				break;
			}
			cur= cur.next;
		}
	}
}

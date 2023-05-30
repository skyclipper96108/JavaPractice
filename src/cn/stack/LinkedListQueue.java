package cn.stack;



public class LinkedListQueue<E>implements Queue<E>{
	private class Node{
		public E e;
		public Node next;
		public Node(E e, Node next) {
			this.e = e;
			this.next = next;
		}
		public Node(E e) {this(e,null);}
		@Override
		public String toString() {return e.toString();}
	}
	private Node head, tail;
	private int size;
	public LinkedListQueue() {
		head=null;
		tail=null;
		size=0;
	}
	@Override
	public int getSize() {
		return size;
	}
	@Override
	public boolean isEmpty() {
		return size==0;
	}
	@Override
	public void enquence(E e) {
		if(tail==null){
			tail=new Node(e);
			head = tail;
		}else {
			tail.next=new Node(e);
			tail = tail.next;
		}
		size++;
	}
	@Override
	public E dequence() {
		if(isEmpty())
			throw new IllegalArgumentException("can't dequence from an empty queue");
		Node retNode = head;
		head = head.next;
		retNode.next = null;
		if(head == null)
			tail =null;
		size --;
		return retNode.e;
	}
	@Override
	public E getFront() {
		if(isEmpty())
			throw new IllegalArgumentException("can't get from an empty queue");
		return head.e;
	}
	@Override
	public String toString() {
		StringBuilder res = new StringBuilder();
		res.append("Queue:front");
		for(Node cur = head; cur!=null; cur=cur.next)
			res.append(cur+"��");
		res.append("Null tail");
		return res.toString();			
		
	}
}

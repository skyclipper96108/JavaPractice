package cn.itsource.search;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinarySearchTree<E extends Comparable<E>> {
	private class Node{
		public E e;
		public Node left, right;
		public Node(E e) {
			this.e=e;
			left=null;
			right=null;
		}
	}
	private Node root;
	private int size;
	public BinarySearchTree() {
		root = null;
		size = 0;
	}
	public int size() {
		return size;
	}
	public boolean isEmpty() {
		return size==0;
	}
	// �����������������µ�Ԫ��e
	public void add(E e) {
		root = add(root, e);
	}
	// ����nodeΪ���Ķ����������в���Ԫ��E���ݹ��㷨
	private Node add(Node node, E e) {
		if(node==null) {
			size++;
			return new Node(e);
		}
		if(e.compareTo(node.e)<0)
			node.left = add(node.left, e);
		else if(e.compareTo(node.e)>0)
			node.right = add(node.right, e);
		return node;
	}
	// ��ѯ�����������Ƿ����Ԫ��e
	public boolean contains(E e) {
		return contains(root, e);
	}
	// ����nodeΪ���Ķ����������Ƿ����Ԫ��e
	private boolean contains(Node node, E e) {
		if(node==null)return false;
		if(e.compareTo(node.e)==0)return true;
		else if(e.compareTo(node.e)<0)return contains(node.left, e);
		else return contains(node.right, e);
	}
	// ǰ�������nodeΪ���Ķ������������ݹ��㷨
	public void preOrder() {
		preOrder(root);
	}
	private void preOrder(Node node) {
		if(node==null)return;
		System.out.println(node.e);
		preOrder(node.left);
		preOrder(node.right);
	}
	// �����������ǵݹ�ǰ�����
	public void preOrderR() {
		Stack<Node> stack = new Stack<>();
		stack.push(root);
		while(!stack.isEmpty()) {
			Node cur = stack.pop();
			System.out.println(cur.e);
			if(cur.right!=null)stack.push(cur.right);
			if(cur.left!=null)stack.push(cur.left);
		}
	}
	// �����������������
	public void levelOrder() {
		Queue<Node> queue=new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()) {
			Node cur=queue.remove();
			System.out.println(cur.e);
			if(cur.left!=null)queue.add(cur.left);
			if(cur.right!=null)queue.add(cur.right);
		}
	}
	// �������
	public void inOrder() {
		inOrder(root);
	}
	// ����������ǰ���С˳���źŵ����
	private void inOrder(Node node) {
		if(node==null)return;
		inOrder(node.left);
		System.out.println(node.e);
		inOrder(node.right);
	}
	public void postOrder() {
		postOrder(root);
	}
	// ���������һ�����ã��ö����������ͷ��ڴ�
	private void postOrder(Node node) {
		if(node==null)return;
		postOrder(node.left);
		postOrder(node.right);
		System.out.print(node.e);
	}
	// Ѱ����СԪ�� ��������
	public E minimum() {
		if(size==0)throw new IllegalArgumentException("BST is empty");
		return minimum(root).e;
		
	}
	private Node minimum(Node node) {
		if(node.left==null)return node;
		return minimum(node.left);
	}
	public E maximum() {
		if(size==0)throw new IllegalArgumentException("BST is empty");
		return maximum(root).e;
		
	}
	private Node maximum(Node node) {
		if(node.right==null)return node;
		return maximum(node.right);
	}
	// ɾ����������������С��Ԫ��
	public E removeMin() {
		E ret = minimum();
		root = removeMin(root);
		return ret;
	}
	private Node removeMin(Node node) {
		if(node.left==null) {
			Node rightnode=node.right;
			node.right=null;
			size--;
			return rightnode;
		}
		node.left=removeMin(node.left);
		return node;
	}
	public E removeMax() {
		E ret = maximum();
		root = removeMax(root);
		return ret;
	}
	private Node removeMax(Node node) {
		if(node.left==null) {
			Node leftnode=node.left;
			node.left=null;
			size--;
			return leftnode;
		}
		node.right=removeMin(node.right);
		return node;
	}
	// ɾ����nodeΪ���Ķ�����������ֵΪe�Ľڵ㣬�ݹ��㷨
	public void remove(E e) {
		root=remove(root,e);
	}
	// ����ɾ���ڵ���µĶ����������ĸ�
	private Node remove(Node node, E e) {
		if(node==null)return null;
		if(e.compareTo(node.e)<0) {
			node.left=remove(node.left, e);
			return node;
		}else if(e.compareTo(node.e)>0) {
			node.right=remove(node.right, e);	
			return node;
		}else {
			if(node.left==null) {
				Node rightnode=node.right;
				node.right=null;
				size--;
				return rightnode;
			}
			if(node.right==null) {
				Node leftnode=node.left;
				node.left=null;
				size--;
				return leftnode;
			}
			// ��ɾ���Ľڵ����ҽڵ����Ϊ��
			// �ҵ��ȴ�ɾ���ڵ�����С�ڵ㣬����ɾ���ڵ�����������С�ڵ�
			Node successor =minimum(node.right);
			successor.right=removeMin(node.right);
			successor.left=node.left;
			node.left=node.right=null;
			return successor;
		}
	}
	@Override
	public String toString() {
		StringBuilder res=new StringBuilder();
		generateBSTString(root, 0, res);
		return res.toString();
	}
	
	// ������nodeΪ�ڵ㣬���Ϊdepth���������������ַ���
	private void generateBSTString(Node node, int depth, StringBuilder res) {
		if(node==null){
			res.append(generateDepthString(depth)+"null\n");
			return;
		}
		res.append(generateDepthString(depth)+node.e+"\n");
		generateBSTString(node.left, depth+1, res);
		generateBSTString(node.right, depth+1, res);
	}
	private  String generateDepthString(int depth) {
		StringBuilder res = new StringBuilder();
		for(int i=0; i<depth; i++)res.append("--");
		return res.toString();
	}
}

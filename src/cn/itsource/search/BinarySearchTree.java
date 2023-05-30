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
	// 向二分搜索树中添加新的元素e
	public void add(E e) {
		root = add(root, e);
	}
	// 向以node为根的二分搜索树中插入元素E，递归算法
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
	// 查询二分搜索树是否包含元素e
	public boolean contains(E e) {
		return contains(root, e);
	}
	// 看以node为根的二分搜索树是否包含元素e
	private boolean contains(Node node, E e) {
		if(node==null)return false;
		if(e.compareTo(node.e)==0)return true;
		else if(e.compareTo(node.e)<0)return contains(node.left, e);
		else return contains(node.right, e);
	}
	// 前序遍历以node为根的二分搜索树，递归算法
	public void preOrder() {
		preOrder(root);
	}
	private void preOrder(Node node) {
		if(node==null)return;
		System.out.println(node.e);
		preOrder(node.left);
		preOrder(node.right);
	}
	// 二分搜索树非递归前序遍历
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
	// 二分搜索树层序遍历
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
	// 中序遍历
	public void inOrder() {
		inOrder(root);
	}
	// 中序遍历就是按大小顺序排号的情况
	private void inOrder(Node node) {
		if(node==null)return;
		inOrder(node.left);
		System.out.println(node.e);
		inOrder(node.right);
	}
	public void postOrder() {
		postOrder(root);
	}
	// 后序遍历的一个引用，用二分搜索树释放内存
	private void postOrder(Node node) {
		if(node==null)return;
		postOrder(node.left);
		postOrder(node.right);
		System.out.print(node.e);
	}
	// 寻找最小元素 类似链表
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
	// 删除二分搜索树中最小的元素
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
	// 删除以node为根的二分搜索树中值为e的节点，递归算法
	public void remove(E e) {
		root=remove(root,e);
	}
	// 返回删除节点后新的二分搜索树的根
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
			// 待删除的节点左右节点均不为空
			// 找到比待删除节点大的最小节点，即待删除节点右子树的最小节点
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
	
	// 生成以node为节点，深度为depth的描述二叉树的字符串
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

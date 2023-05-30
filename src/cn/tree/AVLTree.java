package cn.tree;
import cn.set.map;

import java.util.ArrayList;

public class AVLTree<K extends Comparable<K>,V> implements map<K, V> {

	private class Node{
		public K key;
		public V value;
		public Node left, right;
		public int height;

		public Node(K key, V value) {
			this.key=key;
			this.value=value;
			left=null;
			right=null;
		}
	}
	private Node root;
	private int size;
	public AVLTree() {
		root=null;
		size=0;
	}
	//�ж϶������Ƿ���һ�ö���������
	public boolean isBST(){
		ArrayList<K> keys = new ArrayList<>();
		inOrder(root, keys);
		for(int i=1; i<keys.size();i++){
			if(keys.get(i-1).compareTo(keys.get(i))>0){
				return false;
			}
		}
		return true;
	}

	public boolean isBalanced(){
		return isBalanced(root);
	}

	private boolean isBalanced(Node node){
		if(node==null){
			return true;
		}
		//����������ֵ
		int balanceFactor = getBalanceFactor(node);
		if(Math.abs(balanceFactor)>1)
			return false;
		return isBalanced(node.left)&&isBalanced(node.right);
	}

	private void inOrder(Node node, ArrayList<K> keys) {
		//�����������������Ϊ���������
		if(node == null){
			return;
		}
		inOrder(node.left, keys);
		keys.add(node.key);
		inOrder(node.right,keys);

	}

	//��ýڵ�node�ĸ߶�
	private int getHeight(Node node){
		if(node==null){
			return 0;
		}
		return node.height;
	}
	//��ýڵ�node��ƽ������
	private int getBalanceFactor(Node node){
		if(node==null){
			return 0;
		}
		return getHeight(node.left)-getHeight(node.right);
	}
	@Override
	public void add(K key, V value) {
		root = add(root, key, value);

	}
	private Node add(Node node, K key, V value) {
		if(node==null) {
			size++;
			return new Node(key, value);
		}
		if(key.compareTo(node.key)<0)
			node.left=add(node.left, key, value);
		else if(key.compareTo(node.key)>0)
			node.right=add(node.right,key, value);
		else node.value=value;

		//����height
		node.height = 1 +Math.max(getHeight(node.left),getHeight(node.right));

		//����ƽ������
		int balanceFactor = getBalanceFactor(node);
		if(Math.abs(balanceFactor)>1){
			System.out.println("unbalanced: "+balanceFactor);
		}
		//LL
		if(balanceFactor>1&&getBalanceFactor(node.left)>=0){
			//��಻ƽ�� ����ת
			return rightRotate(node);
		}
		//RR
		if(balanceFactor<-1&&getBalanceFactor(node.right)<=0){
			//��಻ƽ�� ����ת
			return leftRotate(node);
		}
		//LR
		if(balanceFactor>1&&getBalanceFactor(node.left)<0){
			//ת��ΪLL����
			node.left = leftRotate(node.left);
			return rightRotate(node);
		}
		//RL
		if(balanceFactor<-1&&getBalanceFactor(node.right)<0){
			//ת��ΪRR����
			node.right = rightRotate(node.right);
			return leftRotate(node);
		}
		return node;
	}
	//�Խڵ�y����������ת������������ת����¸��ڵ�x
	//       y                          x
	//      / \                       /   \
	//     x   T4   ������ת��y��     z     y
	//	  / \     ----------------> / \    / \
	//   z   T3                    T1  T2 T3  T4
	//  / \
	// T1  T2
	private Node rightRotate(Node y){
		Node x = y.left;
		Node T3 = x.right;
		//������ת����
		x.right = y;
		y.left = T3;
		//����height
		y.height = Math.max(getHeight(y.left),getHeight(y.right))+1;
		x.height = Math.max(getHeight(x.left),getHeight(x.right))+1;
		return x;
	}

	private Node leftRotate(Node y){
		Node x = y.right;
		Node T3 = x.left;
		//������ת����
		x.left = y;
		y.right = T3;
		//����height
		y.height = Math.max(getHeight(y.left),getHeight(y.right))+1;
		x.height = Math.max(getHeight(x.left),getHeight(x.right))+1;
		return x;
	}
	// ������nodeΪ���ڵ�Ķ�����������key���ڽڵ�
	private Node getNode(Node node, K key) {
		if(node==null)return null;
		if(key.compareTo(node.key)==0)return node;
		else if(key.compareTo(node.key)<0)
			return getNode(node.left, key);
		else return getNode(node.right,key);
	}
	public K minimum() {
		if(size==0)throw new IllegalArgumentException("BST is empty");
		return minimum(root).key;

	}
	private Node minimum(Node node) {
		if(node.left==null)return node;
		return minimum(node.left);
	}
	public K removeMin() {
		K ret = minimum();
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
	// ����ɾ���ڵ���µĶ����������ĸ�
	private Node remove(Node node, K key) {
		if(node==null)return null;
		Node retNode;
		if(key.compareTo(node.key)<0) {
			node.left=remove(node.left, key);
			retNode = node;
		}else if(key.compareTo(node.key)>0) {
			node.right=remove(node.right, key);
			retNode = node;
		}else {
			if(node.left==null) {
				Node rightnode=node.right;
				node.right=null;
				size--;
				retNode = rightnode;
			}else if(node.right==null) {
				Node leftnode=node.left;
				node.left=null;
				size--;
				retNode = leftnode;
			}else {
				// ��ɾ���Ľڵ����ҽڵ����Ϊ��
				// �ҵ��ȴ�ɾ���ڵ�����С�ڵ㣬����ɾ���ڵ�����������С�ڵ�
				Node successor = minimum(node.right);
//				successor.right=removeMin(node.right);
				successor.right = remove(node.right, successor.key);
				successor.left = node.left;
				node.left = node.right = null;
				retNode = successor;
			}
		}
		if(retNode==null){
			return null;
		}
		//����height
		retNode.height = 1 +Math.max(getHeight(retNode.left),getHeight(retNode.right));

		//����ƽ������
		int balanceFactor = getBalanceFactor(retNode);
		if(Math.abs(balanceFactor)>1){
			System.out.println("unbalanced: "+balanceFactor);
		}
		//LL
		if(balanceFactor>1&&getBalanceFactor(retNode.left)>=0){
			//��಻ƽ�� ����ת
			return rightRotate(retNode);
		}
		//RR
		if(balanceFactor<-1&&getBalanceFactor(retNode.right)<=0){
			//��಻ƽ�� ����ת
			return leftRotate(retNode);
		}
		//LR
		if(balanceFactor>1&&getBalanceFactor(retNode.left)<0){
			//ת��ΪLL����
			retNode.left = leftRotate(retNode.left);
			return rightRotate(retNode);
		}
		//RL
		if(balanceFactor<-1&&getBalanceFactor(retNode.right)<0){
			//ת��ΪRR����
			retNode.right = rightRotate(retNode.right);
			return leftRotate(retNode);
		}
		return retNode;
	}
	@Override
	public V remove(K key) {
		Node node = getNode(root, key);
		if(node!=null) {
			root=remove(root, key);
			return node.value;
		}
		return null;
	}
	@Override
	public boolean contains(K key) {
		return getNode(root, key)!=null;
	}
	@Override
	public V get(K key) {
		Node node = getNode(root, key);
		return node==null?null:node.value;
	}
	@Override
	public void set(K key, V newValue) {
		Node node=getNode(root, key);
		if(node==null)throw new IllegalArgumentException(key+"doesn't exist");
		node.value=newValue;
	}
	@Override
	public int getSize() {
		return size;
	}
	@Override
	public boolean isEmpty() {
		return false;
	}



}

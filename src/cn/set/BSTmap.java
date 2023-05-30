package cn.set;
public class BSTmap<K extends Comparable<K>,V> implements map<K, V> {
	private class Node{
		public K key;
		public V value;
		public Node left, right;
		public Node(K key, V value) {
			this.key=key;
			this.value=value;
			left=null;
			right=null;
		}
	}
	private Node root;
	private int size;
	public BSTmap() {
		root=null;
		size=0;
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
		return node;
	}
	// 返回以node为根节点的二分搜索树中key所在节点
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
	// 返回删除节点后新的二分搜索树的根
	private Node remove(Node node, K key) {
		if(node==null)return null;
		if(key.compareTo(node.key)<0) {
			node.left=remove(node.left, key);
			return node;
		}else if(key.compareTo(node.key)>0) {
			node.right=remove(node.right, key);	
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

package cn.tree;

/**
 * 线段树不是完全二叉树 是平衡二叉树
 * @param <E>
 */
public class SegmentTree<E> {
	private E[] data;
	private E[] tree;
	private Merger<E> merger;

	public SegmentTree(E[] arr, Merger<E> merger) {
		this.merger=merger;
		data = (E[])new Object[arr.length];
		for(int i=0; i<arr.length; i++)
			data[i]=arr[i];
		tree = (E[])new Object[4*arr.length];//需要4n的空间的线段树
		buildSegmentTree(0,0,data.length-1);
	}
	// 在treeindex的位置创建表示区间[l...r]的线段树（根节点的索引）
	private void buildSegmentTree(int treeIndex, int l, int r) {
		if(l==r) {
			//节点存储的信息就是元素本身
			tree[treeIndex]=data[l];
			return;
		}
		int leftTreeIndex = leftChild(treeIndex);
		int rightTreeIndex = rightChild(treeIndex);
		//分成两个区间
		int mid=l+(r-l)/2;
		buildSegmentTree(leftTreeIndex,l,mid);
		buildSegmentTree(rightTreeIndex,mid+1,r);
		// 由业务逻辑决定的两个子树的信息和
		tree[treeIndex] = merger.merge(tree[leftTreeIndex],tree[rightTreeIndex]);
	}
	public int getSize() {
		return data.length;
	}
	public E get(int index) {
		if(index<0 || index>=data.length)
			throw new IllegalArgumentException("Index is illegal");
		return data[index];
	}
//	返回完全二叉树的数组表示中，索引表示的左右孩子的的索引
	private int leftChild(int index) {
		return 2*index+1;
	}
	private int rightChild(int index) {
		return 2*index+2;
	}
	// 返回区间[queryL, queryR]的值
	public E query(int queryL, int queryR) {
		if(queryL<0 || queryL>=data.length || queryR<0 || queryR>=data.length || queryL>queryR)
			throw new IllegalArgumentException("Index is illegal");
		return query(0,0,data.length-1, queryL,queryR);
	}
	private E query(int treeIndex, int l, int r, int queryL, int queryR) {
		if(l==queryL&&r==queryR)
			return tree[treeIndex];
		int mid=l+(r-l)/2;
		int leftTreeIndex = leftChild(treeIndex);
		int rightTreeIndex = rightChild(treeIndex);
		if(queryL>=mid+1)// 左边界大于中心，从右子树中查找
			return query(rightTreeIndex, mid+1, r, queryL, queryR);
		else if(queryR<=mid) //右边界大于中心，从左子树中查找
			return query(leftTreeIndex,l , mid, queryL, queryR);
		//若需要拆分查找区间的情况
		E leftResult = query(leftTreeIndex, l ,mid,queryL,mid);
		E rightResult = query(rightTreeIndex,mid+1,r,mid+1,queryR);
		return merger.merge(leftResult, rightResult);
	}
	// 将index的值 更新为e
	public void set(int index, E e) {
		if(index<0 || index>=data.length)
			throw new IllegalArgumentException("Index is illegal");
		data[index] = e;
		set(0,0,data.length-1,index,e);
	}
	//将index处的值更新为e
	private void set(int treeIndex, int l, int r, int index, E e) {
		if(l==r) {
			tree[treeIndex]=e;
			return;
		}
		int mid = l+(r-l)/2;
		int leftTreeIndex = leftChild(treeIndex);
		int rightTreeIndex = rightChild(treeIndex);
		if(index>=mid+1)
			set(rightTreeIndex, mid+1, r,index,e);
		else
			set(leftTreeIndex, l, mid, index, e);
		tree[treeIndex] = merger.merge(tree[leftTreeIndex], tree[rightTreeIndex]);
	}
	@Override
	public String toString() {
		StringBuilder res=new StringBuilder();
		res.append('[');
		for(int i=0;i<tree.length; i++) {
			if(tree[i]!=null)
				res.append(tree[i]);
			else
				res.append("null");
			if(i!=tree.length-1);
			res.append(",");

		}
		res.append(']');
		return res.toString();
	}

}

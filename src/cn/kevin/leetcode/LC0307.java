package cn.kevin.leetcode;

public class LC0307 {
    class NumArray {
        int [] tree;
        int [] nums;

        public NumArray(int[] nums) {
            this.nums = nums;
            this.tree = new int[nums.length*4];
            buildSegmentTree(0,0,nums.length-1);
        }

        public void update(int index, int val) {
            if(index<0 || index>=nums.length)
                throw new IllegalArgumentException("Index is illegal");
            nums[index] = val;
            update(0,0,nums.length-1,index,val);
        }

        //将index处的值更新为e
        private void update(int treeIndex, int l, int r, int index, int val) {
            if(l==r) {
                tree[treeIndex]=val;
                return;
            }
            int mid = l+(r-l)/2;
            int leftTreeIndex = leftChild(treeIndex);
            int rightTreeIndex = rightChild(treeIndex);
            if(index>=mid+1)
                update(rightTreeIndex, mid+1, r,index,val);
            else
                update(leftTreeIndex, l, mid, index, val);
            tree[treeIndex] = tree[leftTreeIndex]+tree[rightTreeIndex];
        }

        public int sumRange(int left, int right) {
            if(left<0 || left>=nums.length || right<0 || right>=nums.length || left>right)
                throw new IllegalArgumentException("Index is illegal");
            return query(0,0,nums.length-1, left, right);
        }

        private int query(int treeIndex, int l, int r, int queryL, int queryR) {
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
            int leftResult = query(leftTreeIndex, l ,mid,queryL,mid);
            int rightResult = query(rightTreeIndex,mid+1,r,mid+1,queryR);
            return leftResult+rightResult;
        }

        // 在treeindex的位置创建表示区间[l...r]的线段树（根节点的索引）
        private void buildSegmentTree(int treeIndex, int l, int r) {
            if(l==r) {
                //节点存储的信息就是元素本身
                tree[treeIndex]=nums[l];
                return;
            }
            int leftTreeIndex = leftChild(treeIndex);
            int rightTreeIndex = rightChild(treeIndex);
            //分成两个区间
            int mid=l+(r-l)/2;
            buildSegmentTree(leftTreeIndex,l,mid);
            buildSegmentTree(rightTreeIndex,mid+1,r);
            // 由业务逻辑决定的两个子树的信息和
            tree[treeIndex] = tree[leftTreeIndex]+tree[rightTreeIndex];
        }


        //	返回完全二叉树的数组表示中，索引表示的左右孩子的的索引
        private int leftChild(int index) {
            return 2*index+1;
        }
        private int rightChild(int index) {
            return 2*index+2;
        }
    }

}

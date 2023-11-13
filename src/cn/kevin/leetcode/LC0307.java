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

        //��index����ֵ����Ϊe
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
            if(queryL>=mid+1)// ��߽�������ģ����������в���
                return query(rightTreeIndex, mid+1, r, queryL, queryR);
            else if(queryR<=mid) //�ұ߽�������ģ����������в���
                return query(leftTreeIndex,l , mid, queryL, queryR);
            //����Ҫ��ֲ�����������
            int leftResult = query(leftTreeIndex, l ,mid,queryL,mid);
            int rightResult = query(rightTreeIndex,mid+1,r,mid+1,queryR);
            return leftResult+rightResult;
        }

        // ��treeindex��λ�ô�����ʾ����[l...r]���߶��������ڵ��������
        private void buildSegmentTree(int treeIndex, int l, int r) {
            if(l==r) {
                //�ڵ�洢����Ϣ����Ԫ�ر���
                tree[treeIndex]=nums[l];
                return;
            }
            int leftTreeIndex = leftChild(treeIndex);
            int rightTreeIndex = rightChild(treeIndex);
            //�ֳ���������
            int mid=l+(r-l)/2;
            buildSegmentTree(leftTreeIndex,l,mid);
            buildSegmentTree(rightTreeIndex,mid+1,r);
            // ��ҵ���߼�������������������Ϣ��
            tree[treeIndex] = tree[leftTreeIndex]+tree[rightTreeIndex];
        }


        //	������ȫ�������������ʾ�У�������ʾ�����Һ��ӵĵ�����
        private int leftChild(int index) {
            return 2*index+1;
        }
        private int rightChild(int index) {
            return 2*index+2;
        }
    }

}

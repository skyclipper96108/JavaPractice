package cn.kevin.leetcode;

import javax.swing.tree.TreeNode;

/**
 * �������е� ·�� ������Ϊһ���ڵ����У�������ÿ�����ڽڵ�֮�䶼����һ���ߡ�ͬһ���ڵ���һ��·�������� �������һ�� ����·�� ���ٰ���һ�� �ڵ㣬�Ҳ�һ���������ڵ㡣
 *
 * ·���� ��·���и��ڵ�ֵ���ܺ͡�
 *
 * ����һ���������ĸ��ڵ� root �������� ���·���� ��
 */
public class LC124 {

//    Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int maxPath = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        findMaxPath(root);
        return maxPath;
    }

    /**
     * ֻ����ڵ㵽Ҷ�ӽڵ㵥�����·��
     * @param root
     */
    private int findMaxPath(TreeNode root) {
        if(root==null){
            return 0;
        }
        //��ѡ��ֵ·��
        int left =  Math.max(findMaxPath(root.left),0);
        int right =  Math.max(findMaxPath(root.right),0);
        int newSum = left+root.val+right;
        maxPath = Math.max(maxPath,newSum);
        return root.val+Math.max(left,right);
    }
}

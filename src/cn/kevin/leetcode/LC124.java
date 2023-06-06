package cn.kevin.leetcode;

import javax.swing.tree.TreeNode;

/**
 * 二叉树中的 路径 被定义为一条节点序列，序列中每对相邻节点之间都存在一条边。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
 *
 * 路径和 是路径中各节点值的总和。
 *
 * 给你一个二叉树的根节点 root ，返回其 最大路径和 。
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
     * 只求根节点到叶子节点单向最大路径
     * @param root
     */
    private int findMaxPath(TreeNode root) {
        if(root==null){
            return 0;
        }
        //不选择负值路径
        int left =  Math.max(findMaxPath(root.left),0);
        int right =  Math.max(findMaxPath(root.right),0);
        int newSum = left+root.val+right;
        maxPath = Math.max(maxPath,newSum);
        return root.val+Math.max(left,right);
    }
}

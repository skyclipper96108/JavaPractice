package cn.kevin.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC095 {
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
    public List<TreeNode> generateTrees(int n) {
        if(n==0){
            return new ArrayList<>();
        }
        return generateBST(1,n);
    }

    private List<TreeNode> generateBST(int start, int end) {
        List<TreeNode> res = new ArrayList<>();
        if(start>end){
            res.add(null);
            return res;
        }
        for(int i=start;i<end;i++){
            List<TreeNode> leftNodes = generateBST(start, i-1);
            List<TreeNode> rightNodes = generateBST(i + 1, end);
            for(TreeNode leftRoot:leftNodes){
                for(TreeNode rightRoot:rightNodes){
                    TreeNode root = new TreeNode(i);
                    root.left=leftRoot;
                    root.right=rightRoot;
                    res.add(root);
                }
            }
        }
        return res;
    }


    /**
     * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
     *
     * 有效 二叉搜索树定义如下：
     *
     * 节点的左子树只包含 小于 当前节点的数。
     * 节点的右子树只包含 大于 当前节点的数。
     * 所有左子树和右子树自身必须也是二叉搜索树。
     *
     */
    public boolean isValidBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inOrder(root,list);
        for(int i=1;i<list.size();i++){
            if(list.get(i)<=list.get(i-1)){
                return false;
            }
        }
        return true;
    }

    private void inOrder(TreeNode root, List<Integer> list) {
        if(root==null){
            return;
        }
        inOrder(root.left,list);
        list.add(root.val);
        inOrder(root.right,list);
    }

    private TreeNode pre=null;
    private TreeNode x=null;
    private TreeNode y=null;
    public void recoverTree(TreeNode root) {
        middleOrder(root);
        if(x!=null&&y!=null){
            int temp=x.val;
            x.val=y.val;
            y.val=temp;
        }
    }

    private void middleOrder(TreeNode root) {
        if(root==null){
            return;
        }
        middleOrder(root.left);
        if(pre!=null&&pre.val>root.val){
            y=root;
            if(x==null){
                x=pre;
            }
        }
        pre=root;
        middleOrder(root.right);
    }


    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null&&q==null){
            return true;
        }
        if(p==null||q==null){
            return false;
        }
        if (p.val!=q.val){
            return false;
        }
        return isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);

    }

}

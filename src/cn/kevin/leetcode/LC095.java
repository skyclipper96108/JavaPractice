package cn.kevin.leetcode;

import java.util.*;

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


    public boolean isSymmetric(TreeNode root) {

        return isChildSymmetric(root.left,root.right);
    }

    private boolean isChildSymmetric(TreeNode left, TreeNode right) {
        if(left==null&&right==null){
            return true;
        }
        if(left==null||right==null){
            return false;
        }
        if (left.val!=right.val){
            return false;
        }
        return isChildSymmetric(left.left,right.right)&&isChildSymmetric(left.right,right.left);
    }



    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        getLevelOrder(res,queue);
        return res;
    }

    private void getLevelOrder(List<List<Integer>> res, Queue<TreeNode> queue) {
        Queue<TreeNode> queue2 = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()){
            TreeNode poll = queue.poll();
            if(poll!=null){
                list.add(poll.val);
                queue2.offer(poll.left);
                queue2.offer(poll.right);
            }
        }
        if(!queue2.isEmpty()){
            res.add(list);
            getLevelOrder(res,queue2);
        }
    }


    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Stack<TreeNode> queue = new Stack<>();
        queue.add(root);
        getLevelOrder1(res,queue,1);
        return res;
    }

    private void getLevelOrder1(List<List<Integer>> res, Stack<TreeNode> queue, int i) {
        Stack<TreeNode> queue2 = new Stack<>();
        List<Integer> list = new ArrayList<>();
        if(i==1){
            while (!queue.isEmpty()){
                TreeNode poll = queue.pop();
                if(poll!=null){
                    list.add(poll.val);
                    queue2.add(poll.left);
                    queue2.add(poll.right);
                }
            }
            i=0;
        }else {
            while (!queue.isEmpty()){
                TreeNode poll = queue.pop();
                if(poll!=null){
                    list.add(poll.val);
                    queue2.add(poll.right);
                    queue2.add(poll.left);
                }
            }
            i=1;
        }

        if(!queue2.isEmpty()){
            res.add(list);
            getLevelOrder1(res,queue2,i);
        }
    }

    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }



}

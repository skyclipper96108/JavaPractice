package cn.kevin.leetcode;

public class LC0162 {
    public int findPeakElement(int[] nums) {
        int l=0,r=nums.length-1;
        while (l<r){
            int mid = l+(r-l)/2;
            if(nums[mid]>nums[mid+1]){
                //舍弃mid右边
                r=mid;
            }else{
                l=mid+1;
            }
        }
        return l;
    }
    /**
     * 一个 2D 网格中的 峰值 是指那些 严格大于 其相邻格子(上、下、左、右)的元素。
     *
     * 给你一个 从 0 开始编号 的 m x n 矩阵 mat ，其中任意两个相邻格子的值都 不相同 。找出 任意一个 峰值 mat[i][j] 并 返回其位置 [i,j] 。
     *
     * 你可以假设整个矩阵周边环绕着一圈值为 -1 的格子。
     *
     * 要求必须写出时间复杂度为 O(m log(n)) 或 O(n log(m)) 的算法
     */
    public int[] findPeakGrid(int[][] mat) {
        int m = mat.length ;
        int l=0,r=m-1;
        while (l<r){
            int mid = l+(r-l)/2;
            int peak = findMaxElement(mat[mid]);
            if(mat[mid][peak]>mat[mid+1][peak]){
                //舍弃mid右边
                r=mid;
            }else{
                l=mid+1;
            }
        }
        return new int[]{l,findMaxElement(mat[l])};
    }
    public int findMaxElement(int[] arr){
        int k=0;
        for(int i=0;i<arr.length;i++){
            if(arr[k]<arr[i]){
                k=i;
            }
        }
        return k;
    }
}

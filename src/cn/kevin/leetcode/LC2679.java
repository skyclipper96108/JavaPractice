package cn.kevin.leetcode;


import java.util.*;

/**
 * 给你一个下标从 0开始的二维整数数组nums。一开始你的分数为0。你需要执行以下操作直到矩阵变为空：
 *
 * 矩阵中每一行选取最大的一个数，并删除它。如果一行中有多个最大的数，选择任意一个并删除。
 * 在步骤 1 删除的所有数字中找到最大的一个数字，将它添加到你的 分数中。
 * 请你返回最后的 分数。
 *
 */
public class LC2679 {


    public int matrixSum(int[][] nums) {
        Comparator<Integer> comparator = new Comparator<Integer>(){
            @Override
            public int compare(Integer i1, Integer i2) {
                if(Objects.equals(i1, i2)){
                    return 0;
                }else if(i1>i2){
                    return -1;
                }else {
                    return 1;
                }
            }
        };
        for(int[] arr:nums){
            Arrays.sort(arr);
        }
        int res = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>(comparator);
        for(int i=0;i<nums[0].length;i++){
            for(int[] arr:nums){
                queue.add(arr[i]);
            }
            if(!queue.isEmpty()){
                res+=queue.peek();
            }
            queue.clear();
        }
        return res;
    }
}

package cn.kevin.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个2行 n 列的二进制数组：
 *
 * 矩阵是一个二进制矩阵，这意味着矩阵中的每个元素不是0就是1。
 * 第 0 行的元素之和为upper。
 * 第 1 行的元素之和为 lower。
 * 第 i 列（从 0 开始编号）的元素之和为colsum[i]，colsum是一个长度为n的整数数组。
 * 你需要利用upper，lower和colsum来重构这个矩阵，并以二维整数数组的形式返回它。
 *
 * 如果有多个不同的答案，那么任意一个都可以通过本题。
 *
 * 如果不存在符合要求的答案，就请返回一个空的二维数组。
 *
 */
public class LC1253 {


    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        int n = colsum.length;
        int sum = 0;
        int count2 = 0;
        List<Integer> up = new ArrayList<>();
        List<Integer> down = new ArrayList<>();
        for (int j : colsum) {
            if(j==2){
                up.add(1);
                down.add(1);
                count2++;
            }else {
                up.add(0);
                down.add(0);
            }
            sum += j;
        }
        List<List<Integer>> res = new ArrayList<>();
        if(sum!=upper+lower||count2>Math.min(upper,lower)){
            return res;
        }
        int upper1 = upper-count2;
        for (int i=0;i<n;i++) {
            if(colsum[i]==1){
                if(upper1>0){
                    up.set(i,1);
                    down.set(i,0);
                    upper1--;
                }else {
                    up.set(i,0);
                    down.set(i,1);
                }
            }
        }
        res.add(up);
        res.add(down);
        return res;
    }
}

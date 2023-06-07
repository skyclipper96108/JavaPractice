package cn.kevin.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 */
public class LC054 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        //定义遍历的范围left,right,head,bottom
        int bottom = matrix.length;
        int head = 0;
        int left = 0;
        int right = matrix[0].length;
        while (left<right&&head<bottom){
            //定义双指针沿着范围走一圈
            int col = left;
            int row = head;
            while (col<right){
                res.add(matrix[row][col]);
                col++;
            }
            col--;
            row++;
            while (row<bottom){
                res.add(matrix[row][col]);
                row++;
            }
            row--;
            col--;
            if(head<bottom-1){
                while (col>=left){
                    res.add(matrix[row][col]);
                    col--;
                }
                col++;
                row--;
            }
            if(left<right-1){
                while (row>head){
                    res.add(matrix[row][col]);
                    row--;
                }
            }
            //范围缩小
            left++;
            right--;
            head++;
            bottom--;
        }
        return res;
    }
}

package cn.kevin.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * ����һ�� m �� n �еľ��� matrix ���밴�� ˳ʱ������˳�� �����ؾ����е�����Ԫ�ء�
 */
public class LC054 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        //��������ķ�Χleft,right,head,bottom
        int bottom = matrix.length;
        int head = 0;
        int left = 0;
        int right = matrix[0].length;
        while (left<right&&head<bottom){
            //����˫ָ�����ŷ�Χ��һȦ
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
            //��Χ��С
            left++;
            right--;
            head++;
            bottom--;
        }
        return res;
    }
}

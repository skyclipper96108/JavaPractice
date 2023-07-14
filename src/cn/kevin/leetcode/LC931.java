package cn.kevin.leetcode;

import java.util.Arrays;

/**
 * 给你一个 n x n 的 方形 整数数组?matrix ，请你找出并返回通过 matrix 的下降路径 的 最小和 。
 *
 * 下降路径 可以从第一行中的任何元素开始，并从每一行中选择一个元素。在下一行选择的元素和当前行所选元素最多相隔一列（即位于正下方或者沿对角线向左或者向右的第一个元素）。具体来说，位置 (row, col) 的下一个元素应当是 (row + 1, col - 1)、(row + 1, col) 或者 (row + 1, col + 1) 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/minimum-falling-path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LC931 {
    int res = Integer.MAX_VALUE;
    int n = 0;
    public int minFallingPathSum0(int[][] matrix) {
        n = matrix.length;
        int sum = 0;
        for(int i=0;i<n;i++){
            findMinPath(matrix, i, 0, sum);
        }
        return res;
    }


    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];
        System.arraycopy(matrix[0], 0, dp[0], 0, n);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int k=dp[i - 1][j];
                if (j > 0) {
                    k=Math.min(k, dp[i - 1][j - 1]);
                }
                if (j < n - 1) {
                    k=Math.min(k, dp[i - 1][j + 1]);
                }
                dp[i][j]= k+matrix[i][j];
            }
        }
        return Arrays.stream(dp[n - 1]).min().getAsInt();
    }

    private void findMinPath(int[][] matrix, int col, int row, int sum) {
        if(row>=n-1){
            res=Math.min(res,sum);
            return;
        }
        int[] arr = matrix[row];
        if(col>0){
            findMinPath(matrix,col-1,row+1,sum+arr[col-1]);
        }
        if(col<n-1){
            findMinPath(matrix,col+1,row+1,sum+arr[col+1]);
        }
        findMinPath(matrix,col,row+1,sum+arr[col]);
    }
}

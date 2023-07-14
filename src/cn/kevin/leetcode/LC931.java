package cn.kevin.leetcode;

import java.util.Arrays;

/**
 * ����һ�� n x n �� ���� ��������?matrix �������ҳ�������ͨ�� matrix ���½�·�� �� ��С�� ��
 *
 * �½�·�� ���Դӵ�һ���е��κ�Ԫ�ؿ�ʼ������ÿһ����ѡ��һ��Ԫ�ء�����һ��ѡ���Ԫ�غ͵�ǰ����ѡԪ��������һ�У���λ�����·������ضԽ�������������ҵĵ�һ��Ԫ�أ���������˵��λ�� (row, col) ����һ��Ԫ��Ӧ���� (row + 1, col - 1)��(row + 1, col) ���� (row + 1, col + 1) ��
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode.cn/problems/minimum-falling-path-sum
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
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

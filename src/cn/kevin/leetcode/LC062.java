package cn.kevin.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * һ��������λ��һ�� m x n��������Ͻ� ����ʼ������ͼ�б��Ϊ ��Start�� ����
 *
 * ������ÿ��ֻ�����»��������ƶ�һ������������ͼ�ﵽ��������½ǣ�����ͼ�б��Ϊ ��Finish�� ����
 *
 * ���ܹ��ж�������ͬ��·����
 *
 */
public class LC062 {

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++){
            dp[i][0]=1;
        }
        for(int i=0;i<n;i++){
            dp[0][i]=1;
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }


    /**
     * ����һ���Ǹ����� numRows�����ɡ�������ǡ���ǰ numRows �С�
     *
     * �ڡ�������ǡ��У�ÿ�����������Ϸ������Ϸ������ĺ͡�
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> dp = new ArrayList<>();
        for(int i=0;i<=numRows;i++){
            List<Integer> list = new ArrayList<>();
            for(int j=0;j<=i;j++){
                if(j==0||j==i){
                    list.add(1);
                }else {
                    list.add(dp.get(i-1).get(j-1)+dp.get(i-1).get(j));
                }
            }
            dp.add(list);
        }
        return dp;

    }
}

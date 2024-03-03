package cn.kevin.leetcode;

public class LC3000 {

    /**
     * ����һ�� �ϸ��������� ������������ arr ��һ������ k ��
     *
     * �����ҵ����������� k ��ȱʧ����������
     */
    public int findKthPositive(int[] arr, int k) {
        int miss = Integer.MIN_VALUE;
        int i = 1;
        int j = 0;
        for(int count=0; count<k; i++){
            if(i==arr[j]){
                if(j+1< arr.length){
                    j+=1;
                }
            }else {
                count++;
                miss=i;
            }
        }
        return miss;

    }


    /**
     * ����һ���������� prices ������ prices[i] ��ʾĳ֧��Ʊ�� i ��ļ۸�
     *
     * ��ÿһ�죬����Ծ����Ƿ����/����۹�Ʊ�������κ�ʱ�� ��� ֻ�ܳ��� һ�� ��Ʊ����Ҳ�����ȹ���Ȼ���� ͬһ�� ���ۡ�
     *
     * ���� ���ܻ�õ� ��� ���� ��
     */
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0]=0;
        dp[0][1]=-prices[0];
        for(int i=1;i<n;i++){
            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
            dp[i][1]=Math.max(dp[i-1][1],dp[i-1][0]-prices[i]);
        }
        return dp[n-1][0];
    }
}

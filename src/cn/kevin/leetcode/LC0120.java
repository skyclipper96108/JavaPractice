package cn.kevin.leetcode;

public class LC0120 {

    /**
     * ����һ������ prices �����ĵ� i ��Ԫ�� prices[i] ��ʾһ֧������Ʊ�� i ��ļ۸�
     *
     * ��ֻ��ѡ�� ĳһ�� ������ֻ��Ʊ����ѡ���� δ����ĳһ����ͬ������ �����ù�Ʊ�����һ���㷨�����������ܻ�ȡ���������
     *
     * ��������Դ���ʽ����л�ȡ�������������㲻�ܻ�ȡ�κ����󣬷��� 0 ��
     */
    public int maxProfit(int[] prices) {
        int cost=prices[0], profit = 0;
        for (int price : prices) {
            cost = Math.min(cost, price);
            profit = Math.max(profit, price - cost);
        }
        return profit;
    }

    /**
     * ����һ���������� prices ������ prices[i] ��ʾĳ֧��Ʊ�� i ��ļ۸�
     *
     * ��ÿһ�죬����Ծ����Ƿ����/����۹�Ʊ�������κ�ʱ�� ��� ֻ�ܳ��� һ�� ��Ʊ����Ҳ�����ȹ���Ȼ���� ͬһ�� ���ۡ�
     *
     * ���� ���ܻ�õ� ��� ���� ��
     */
    public int maxProfit2(int[] prices) {
        int n = prices.length;
        // ��ÿһ�죬�����й�Ʊ��Ϊ1�� ��δ������Ϊ0
        int[][] dp = new int[n][2];
        dp[0][0]=0;
        dp[0][1]=-prices[0];
        for(int i=1;i<n;i++){
            dp[i][0]=Math.max(dp[i-1][0], dp[i-1][1]+prices[i]);
            dp[i][1]=Math.max(dp[i-1][1], dp[i-1][0]-prices[i]);
        }
        return dp[n-1][0];
    }
}

package cn.kevin.leetcode;

public class LC3000 {

    /**
     * 给你一个 严格升序排列 的正整数数组 arr 和一个整数 k 。
     *
     * 请你找到这个数组里第 k 个缺失的正整数。
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
     * 给你一个整数数组 prices ，其中 prices[i] 表示某支股票第 i 天的价格。
     *
     * 在每一天，你可以决定是否购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票。你也可以先购买，然后在 同一天 出售。
     *
     * 返回 你能获得的 最大 利润 。
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

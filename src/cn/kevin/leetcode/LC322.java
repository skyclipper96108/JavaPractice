package cn.kevin.leetcode;

import java.util.Arrays;

/**
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 *
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回?-1 。
 *
 * 你可以认为每种硬币的数量是无限的
 *
 */
public class LC322 {

    public int coinChange(int[] coins, int amount) {
        //建立备忘录
        int[] memo = new int[amount + 1];
        Arrays.fill(memo,-666);
        return findLessCoins(coins, amount, memo);

    }

    private int findLessCoins(int[] coins, int amount, int[] memo) {
        if(amount==0){
            return 0;
        }
        if(amount<0){
            return -1;
        }
        //若备忘录被更新过则直接返回
        if(memo[amount]!=-666){
            return memo[amount];
        }
        int min = Integer.MAX_VALUE;
        for(int c:coins){
            int leaf = findLessCoins(coins,amount-c, memo);
            //如果不是返回-1且比记录的最小值小则返回
            if(leaf!=-1&&leaf+1<min){
                min=leaf+1;
            }
        }
        memo[amount]=min==Integer.MAX_VALUE?-1:min;
        return memo[amount];
    }
}

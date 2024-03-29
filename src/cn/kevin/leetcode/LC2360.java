package cn.kevin.leetcode;

import java.util.Arrays;

public class LC2360 {

    /**
     * 给你一个下标从 0 开始的整数数组 nums ，你必须将数组划分为一个或多个 连续 子数组。
     *
     * 如果获得的这些子数组中每个都能满足下述条件 之一 ，则可以称其为数组的一种 有效 划分：
     *
     * 子数组 恰 由 2 个相等元素组成，例如，子数组 [2,2] 。
     * 子数组 恰 由 3 个相等元素组成，例如，子数组 [4,4,4] 。
     * 子数组 恰 由 3 个连续递增元素组成，并且相邻元素之间的差值为 1 。例如，子数组 [3,4,5] ，但是子数组 [1,3,5] 不符合要求。
     * 如果数组 至少 存在一种有效划分，返回 true ，否则，返回 false 。
     *
     */
    public boolean validPartition(int[] nums) {

        int n = nums.length;
        // 定义dp数组 数组nums前n个元素是否存在等效划分
        boolean[] dp = new boolean[n+1];
        Arrays.fill(dp, false);
        dp[0]=true;
        for(int i=2; i<n+1; i++){
            dp[i]=dp[i-2]&&checkTwoNumbers(nums[i-2], nums[i-1]);
            if(i!=2){
                dp[i]=dp[i]||(dp[i-3]&&checkThreeNumbers(nums[i-3],nums[i-2],nums[i-1]));
            }
        }
        return dp[n];
    }

    private boolean checkTwoNumbers(int i, int j){
        return i==j;
    }

    private boolean checkThreeNumbers(int i, int j, int k){
        return (i + 1 == j && i + 2 == k)||(i==j&&i==k);
    }
}

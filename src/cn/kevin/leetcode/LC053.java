package cn.kevin.leetcode;

import java.util.Arrays;

/**
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 子数组 是数组中的一个连续部分。
 */
public class LC053 {

    public int maxSubArray(int[] nums) {
        int len = nums.length;
        //定义dp数组
        int[] dp = new int[len];
        dp[0]=nums[0];
        int res = dp[0];
        for(int i=1;i<len;i++){
            dp[i] = Math.max(dp[i-1]+nums[i],nums[i]);
            res = Math.max(res,dp[i]);
        }
        System.out.println(Arrays.toString(dp));
        return res;
    }
}

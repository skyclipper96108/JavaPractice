package cn.kevin.leetcode;

import java.util.Arrays;

/**
 * ����һ���������� nums �������ҳ�һ���������͵����������飨���������ٰ���һ��Ԫ�أ������������͡�
 *
 * ������ �������е�һ���������֡�
 */
public class LC053 {

    public int maxSubArray(int[] nums) {
        int len = nums.length;
        //����dp����
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

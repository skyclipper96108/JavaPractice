package cn.kevin.leetcode;

import java.util.Arrays;

/**
 * 给出一个含有不重复整数元素的数组 arr ，每个整数 arr[i] 均大于 1。
 *
 * 用这些整数来构建二叉树，每个整数可以使用任意次数。其中：每个非叶结点的值应等于它的两个子结点的值的乘积。
 *
 * 满足条件的二叉树一共有多少个？答案可能很大，返回 对 109 + 7 取余 的结果。
 */
public class LC823 {
    public int numFactoredBinaryTrees(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        long [] dp = new long[n];
        long res=0,mod=1000000007;
        for(int i=0; i<n;i++){
            dp[i]=1;
            for(int left=0,right=i-1;left<=right;left++){
                while (right>=left&&arr[right]*arr[left]>arr[i]){
                    right--;
                }
                if(right>=left&&arr[right]*arr[left]==arr[i]){
                    if(left==right){
                        dp[i]=(dp[i]+dp[left]*dp[right])%mod;
                    }else {
                        dp[i]=(dp[i]+dp[left]*dp[right]*2)%mod;
                    }
                }
            }
            res = (res+dp[i])%mod;
        }
        return (int) res;
    }
}

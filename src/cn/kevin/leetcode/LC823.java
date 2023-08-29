package cn.kevin.leetcode;

import java.util.Arrays;

/**
 * ����һ�����в��ظ�����Ԫ�ص����� arr ��ÿ������ arr[i] ������ 1��
 *
 * ����Щ������������������ÿ����������ʹ��������������У�ÿ����Ҷ����ֵӦ�������������ӽ���ֵ�ĳ˻���
 *
 * ���������Ķ�����һ���ж��ٸ����𰸿��ܴܺ󣬷��� �� 109 + 7 ȡ�� �Ľ����
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

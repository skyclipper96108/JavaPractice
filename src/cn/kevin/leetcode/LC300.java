package cn.kevin.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * ����һ���������� nums ���ҵ�������ϸ���������еĳ��ȡ�
 *
 * ���������������������������У�ɾ������ɾ���������е�Ԫ�ض����ı�����Ԫ�ص�˳�����磬[3,6,2,7] ������ [0,3,1,6,2,2,7] �������С�
 *
 */
public class LC300 {

    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        Arrays.fill(dp,1);
        int res = 0;
        for(int i=1;i<len;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    dp[i]=Math.max(dp[j]+1,dp[i]);
                }
            }
            System.out.println(Arrays.toString(dp));
            res = Math.max(res,dp[i]);
        }
        return res;
    }

    /**
     * ���������ַ���text1 ��text2�������������ַ������ ���������� �ĳ��ȡ���������� ���������� ������ 0 ��
     *
     * һ���ַ�������������ָ����һ���µ��ַ�����������ԭ�ַ����ڲ��ı��ַ������˳��������ɾ��ĳЩ�ַ���Ҳ���Բ�ɾ���κ��ַ�������ɵ����ַ�����
     *
     * ���磬"ace" �� "abcde" �������У��� "aec" ���� "abcde" �������С�
     * �����ַ����� ���������� ���������ַ�������ͬӵ�е������С�
     *
     */
    public int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        int[][] dp = new int[len1+1][len2+1];
        for(int i=1; i<len1+1; i++){
            for(int j=1;j<len2+1; j++){
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    //�����λ�ַ���ͬ ������ַ���+1
                    dp[i][j]=dp[i-1][j-1]+1;
                }else {
                    dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }
        return dp[len1][len2];
    }
}

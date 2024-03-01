package cn.kevin.leetcode;

import java.util.Arrays;

public class LC2360 {

    /**
     * ����һ���±�� 0 ��ʼ���������� nums ������뽫���黮��Ϊһ������ ���� �����顣
     *
     * �����õ���Щ��������ÿ������������������ ֮һ ������Գ���Ϊ�����һ�� ��Ч ���֣�
     *
     * ������ ǡ �� 2 �����Ԫ����ɣ����磬������ [2,2] ��
     * ������ ǡ �� 3 �����Ԫ����ɣ����磬������ [4,4,4] ��
     * ������ ǡ �� 3 ����������Ԫ����ɣ���������Ԫ��֮��Ĳ�ֵΪ 1 �����磬������ [3,4,5] ������������ [1,3,5] ������Ҫ��
     * ������� ���� ����һ����Ч���֣����� true �����򣬷��� false ��
     *
     */
    public boolean validPartition(int[] nums) {

        int n = nums.length;
        // ����dp���� ����numsǰn��Ԫ���Ƿ���ڵ�Ч����
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

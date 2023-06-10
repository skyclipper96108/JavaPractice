package cn.kevin.leetcode;

import java.util.Arrays;

/**
 * ����һ���������� coins ����ʾ��ͬ����Ӳ�ң��Լ�һ������ amount ����ʾ�ܽ�
 *
 * ���㲢���ؿ��Դճ��ܽ������� ���ٵ�Ӳ�Ҹ��� �����û���κ�һ��Ӳ�����������ܽ�����?-1 ��
 *
 * �������Ϊÿ��Ӳ�ҵ����������޵�
 *
 */
public class LC322 {

    public int coinChange(int[] coins, int amount) {
        //��������¼
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
        //������¼�����¹���ֱ�ӷ���
        if(memo[amount]!=-666){
            return memo[amount];
        }
        int min = Integer.MAX_VALUE;
        for(int c:coins){
            int leaf = findLessCoins(coins,amount-c, memo);
            //������Ƿ���-1�ұȼ�¼����СֵС�򷵻�
            if(leaf!=-1&&leaf+1<min){
                min=leaf+1;
            }
        }
        memo[amount]=min==Integer.MAX_VALUE?-1:min;
        return memo[amount];
    }
}

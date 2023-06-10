package cn.kevin.leetcode;

import java.util.Arrays;

/**
 * ����һ���ַ��� s���ҵ� s ����Ļ����Ӵ���
 *
 * ����ַ����ķ�����ԭʼ�ַ�����ͬ������ַ�����Ϊ�����ַ�����
 */
public class LC005 {
    public String longestPalindrome(String s) {
        int len = s.length();
        //����dp[i][j]Ϊs[i,j]�Ƿ�Ϊ�����ַ���
        boolean[][] dp = new boolean[len][len];
        //��ʼ��
        for(int i=0;i<len;i++){
            dp[i][i]=true;
        }
        String res = s.substring(0,1);
        int max = 0;
        //�ȱ�������2���Ӵ��ٱ�������Ϊ3���ִ�...����
        for(int l=2;l<=len;l++){
            for(int i=0;i<len-l+1;i++){
                int j=i+l-1;
                dp[i][j]=s.charAt(i)==s.charAt(j)&&(j-i<3||dp[i+1][j-1]);
                if(j-i>max&&dp[i][j]){
                    res=s.substring(i,j+1);
                    max=j-i;
                }
                System.out.println(i+","+j+"---"+dp[i][j]);

            }
        }
        return res;
    }
}

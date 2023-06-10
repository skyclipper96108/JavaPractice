package cn.kevin.leetcode;

import java.util.Arrays;

/**
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 *
 * 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。
 */
public class LC005 {
    public String longestPalindrome(String s) {
        int len = s.length();
        //定义dp[i][j]为s[i,j]是否为回文字符串
        boolean[][] dp = new boolean[len][len];
        //初始化
        for(int i=0;i<len;i++){
            dp[i][i]=true;
        }
        String res = s.substring(0,1);
        int max = 0;
        //先遍历长度2的子串再遍历长度为3的字串...依次
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

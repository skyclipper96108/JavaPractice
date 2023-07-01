package cn.kevin.leetcode;

import java.util.*;

public class test {
    public static void main(String[] args) {
        StringBuilder s =new StringBuilder();
        s.append("a".repeat(1000));
        System.out.println(s);
        System.out.println(findLongestLine(s.toString()));
    }

    private static String findLongestLine(String s) {
        int n = s.length();
        boolean [][] dp = new boolean[n][n];
        for(int i=0;i<n;i++){
            dp[i][i]=true;
        }
        String res = s.substring(0,1);
        int max = 0;
        for(int l=2;l<=n;l++){
            for(int i=0;i<n+1-l;i++){
                int j=i+l-1;
                dp[i][j]=(s.charAt(i)==s.charAt(j)&&dp[i+1][j-1])||(s.charAt(i)==s.charAt(j)&&j-i<3);
                if(j-i>max&&dp[i][j]){
                    res=s.substring(i,j+1);
                    max=j-i;
                }
            }
        }
        return res;
    }

}

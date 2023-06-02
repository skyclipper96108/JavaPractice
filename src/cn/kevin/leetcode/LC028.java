package cn.kevin.leetcode;

/**
 * 给你两个字符串?haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。如果?needle 不是 haystack 的一部分，则返回? -1 。
 */
public class LC028 {
    public int strStr(String haystack, String needle) {
        int i = haystack.length();
        int j = needle.length();
        if(i<j){
            return -1;
        }
        for(int k=0;k<i-j+1;k++){
            if(needle.equals(haystack.substring(k,k+j))){
                return k;
            }
        }
        return -1;
    }

    public int divide(int dividend, int divisor) {
        boolean flag = false;
        if(dividend<0){
            if(dividend==Integer.MIN_VALUE){
                dividend=Integer.MAX_VALUE;
            }else{
                dividend=-dividend;
            }
            flag =!flag;
        }
        if(divisor<0){
            if(divisor==Integer.MIN_VALUE){
                divisor=Integer.MAX_VALUE;
            }else{
                divisor=-divisor;
            }
            flag =!flag;
        }
        int res = 0;
        while(dividend>=divisor){
            dividend-=divisor;
            res++;
        }
        if(flag){
            res=-res;
        }
        return res;
    }
}

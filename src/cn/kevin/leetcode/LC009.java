package cn.kevin.leetcode;


/**
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 *
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 */
public class LC009 {
    public boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }
        int p = x;
        int res = 0;
        while (x!=0){
            int tmp = x%10;
            res=10*res+tmp;
            x/=10;
        }
        return res==p;
    }
}

package cn.kevin.leetcode;


/**
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 *
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 */
public class LC009 {
    public boolean isPalindrome2(int x) {
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

    public boolean isPalindrome(String s) {
        String str = s.replaceAll("[^a-zA-Z0-9]", "");
        int n = str.length();
        int l = 0, r=n-1;
        while(l<r){
            if(Character.toLowerCase(str.charAt(l))!=Character.toLowerCase(str.charAt(r))){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}

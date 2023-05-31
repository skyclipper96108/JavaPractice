package cn.kevin.leetcode;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 */
public class LC014 {
    public String longestCommonPrefix(String[] strs) {
        //取出第一个字符串
        char[] s0 = strs[0].toCharArray();
        for(int i=0; i<s0.length;i++){
            //遍历其他两个字符串
            for (int j=1;j<strs.length;j++){
                //若字符串越界 或 比较不相等则返回
                if(i==strs[j].length() || s0[i]!=strs[j].charAt(i)){
                    return strs[0].substring(0,i);
                }
            }
        }
        return strs[0];
    }
}
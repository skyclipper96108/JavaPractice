package cn.kevin.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 */
public class LC022 {

    public List<String> res;
    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        if(n==0){
            return res;
        }
        //dfs实现
        findBracketComb(new StringBuilder(),n,n);
        return res;
    }

    private void findBracketComb(StringBuilder str, int left, int right) {
        if(left==0&&right==0){
            res.add(str.toString());
        }
        if(left>right){
            //剪枝
            return;
        }
        if(left>0){
            //若放入左括号
            findBracketComb(str.append('('),left-1,right);
            str.deleteCharAt(str.length()-1);
        }
        if(right>0){
            //若放入右括号
            findBracketComb(str.append(')'),left,right-1);
            str.deleteCharAt(str.length()-1);
        }
    }
}

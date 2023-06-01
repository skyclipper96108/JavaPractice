package cn.kevin.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * ���� n �����������ŵĶ������������һ�������������ܹ��������п��ܵĲ��� ��Ч�� ������ϡ�
 */
public class LC022 {

    public List<String> res;
    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        if(n==0){
            return res;
        }
        //dfsʵ��
        findBracketComb(new StringBuilder(),n,n);
        return res;
    }

    private void findBracketComb(StringBuilder str, int left, int right) {
        if(left==0&&right==0){
            res.add(str.toString());
        }
        if(left>right){
            //��֦
            return;
        }
        if(left>0){
            //������������
            findBracketComb(str.append('('),left-1,right);
            str.deleteCharAt(str.length()-1);
        }
        if(right>0){
            //������������
            findBracketComb(str.append(')'),left,right-1);
            str.deleteCharAt(str.length()-1);
        }
    }
}

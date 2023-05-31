package cn.kevin.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ����һ������������?2-9?���ַ����������������ܱ�ʾ����ĸ��ϡ��𰸿��԰� ����˳�� ���ء�
 *
 * �������ֵ���ĸ��ӳ�����£���绰������ͬ����ע�� 1 ����Ӧ�κ���ĸ��
 *
 */
public class LC017 {
    private static final Map<Character, String> dict = new HashMap<>(){{
        put('0', " ");
        put('1', "");
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};
    public List<String> letterCombinations(String digits) {
        int len = digits.length();
        List<String> res = new ArrayList<>();
        if(len==0){
            return res;
        }
        transferCharacter(res, digits, 0, new StringBuilder());
        return res;
    }

    private void transferCharacter(List<String> res, String digits, int i, StringBuilder builder) {
        if(digits.length()==i){
            res.add(builder.toString());
        }else {
            //���ܵĽ����
            String s = dict.get(digits.charAt(i));
            for(char a:s.toCharArray()){
                builder.append(a);
                transferCharacter(res, digits, i+1, builder);
                //�ݹ������һ������
                builder.deleteCharAt(i);
            }
        }

    }
}

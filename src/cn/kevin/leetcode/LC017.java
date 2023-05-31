package cn.kevin.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个仅包含数字?2-9?的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
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
            //可能的结果集
            String s = dict.get(digits.charAt(i));
            for(char a:s.toCharArray()){
                builder.append(a);
                transferCharacter(res, digits, i+1, builder);
                //递归调用下一层后回溯
                builder.deleteCharAt(i);
            }
        }

    }
}

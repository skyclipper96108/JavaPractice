package cn.kevin.leetcode;

import java.util.*;

/**
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 *
 * 字母异位词 是由重新排列源单词的所有字母得到的一个新单词。
 */
public class LC049 {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String str:strs){
            int[] dict = new int[26];
            //相同字母出现次数相同的单词在同一组
            for(char s:str.toCharArray()){
                dict[s-'a']=dict[s-'a']+1;
            }
            StringBuilder key = new StringBuilder();
            //不同数组的hashcode是不同的，故转化为String进行匹配
            for(int i=0; i<dict.length; i++){
                if(dict[i]!=0){
                    key.append((char) ('a' + i)).append(dict[i]);
                }
            }
            List<String> list = map.getOrDefault(key.toString(), new ArrayList<>());
            list.add(str);
            map.put(key.toString(),list);
        }
        return new ArrayList<>(map.values());
    }

}

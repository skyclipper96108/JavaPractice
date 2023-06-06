package cn.kevin.leetcode;

import java.util.*;

/**
 * ����һ���ַ������飬���㽫 ��ĸ��λ�� �����һ�𡣿��԰�����˳�򷵻ؽ���б�
 *
 * ��ĸ��λ�� ������������Դ���ʵ�������ĸ�õ���һ���µ��ʡ�
 */
public class LC049 {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String str:strs){
            int[] dict = new int[26];
            //��ͬ��ĸ���ִ�����ͬ�ĵ�����ͬһ��
            for(char s:str.toCharArray()){
                dict[s-'a']=dict[s-'a']+1;
            }
            StringBuilder key = new StringBuilder();
            //��ͬ�����hashcode�ǲ�ͬ�ģ���ת��ΪString����ƥ��
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

package cn.kevin.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LC1976 {
    /**
     * ����һ������������� n ��·����ɣ�·�ڱ��Ϊ 0 �� n - 1 ��ĳЩ·��֮���� ˫�� ��·�����뱣֤����Դ�����·�ڳ���������������·�ڣ�����������·��֮�������һ��·��
     *
     * ����һ������ n �Ͷ�ά�������� roads ������ roads[i] = [ui, vi, timei] ��ʾ��·�� ui �� vi ֮����һ����Ҫ���� timei ʱ�����ͨ���ĵ�·������֪������ ����ʱ�� ��·�� 0 ��������·�� n - 1 �ķ�������
     *
     * �뷵�ػ��� ����ʱ�� ����Ŀ�ĵص� ·����Ŀ �����ڴ𰸿��ܴܺ󣬽������ 10^9 + 7 ȡ�� �󷵻ء�
     */
    public int countPaths(int n, int[][] roads) {
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for(int[] r :roads){
            if(map.containsKey(r[0])){
                Map<Integer, Integer> d = map.get(r[0]);
                d.put(r[1],r[2]);
                map.put(r[0],d);
            } else {
                Map<Integer, Integer> t = new HashMap<>();
                t.put(r[1],r[2]);
                map.put(r[0],t);
            }
        }
        return -1;
    }
}

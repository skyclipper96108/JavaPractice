package cn.kevin.leetcode;

import cn.linkedlist.LinkedList;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Queue;

/**
 * ������ intervals ��ʾ���ɸ�����ļ��ϣ����е�������Ϊ intervals[i] = [starti, endi] ��
 * ����ϲ������ص������䣬������һ�����ص����������飬��������ǡ�ø��������е��������䡣
 *
 */
public class LC056 {

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        Queue<int[]> res = new ArrayDeque<>();
        for(int i=0;i<intervals.length;i++){
            int t = intervals[i][1];
            int j = i+1;
            while (j<intervals.length&&t>=intervals[j][0]){
                t = Math.max(t,intervals[j][1]);
                j++;
            }
            res.offer(new int[]{intervals[i][0],t});
            i=j-1;
        }
        int n = res.size();
        int[][] ints = new int[n][2];
        for(int i = 0; i<n; i++){
            ints[i] = res.poll();
        }
        return ints;
    }
}

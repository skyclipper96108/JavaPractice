package cn.kevin.leetcode;

import cn.linkedlist.LinkedList;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Queue;

/**
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
 * 请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
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

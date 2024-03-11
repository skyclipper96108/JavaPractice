package cn.kevin.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LC1976 {
    /**
     * 你在一个城市里，城市由 n 个路口组成，路口编号为 0 到 n - 1 ，某些路口之间有 双向 道路。输入保证你可以从任意路口出发到达其他任意路口，且任意两个路口之间最多有一条路。
     *
     * 给你一个整数 n 和二维整数数组 roads ，其中 roads[i] = [ui, vi, timei] 表示在路口 ui 和 vi 之间有一条需要花费 timei 时间才能通过的道路。你想知道花费 最少时间 从路口 0 出发到达路口 n - 1 的方案数。
     *
     * 请返回花费 最少时间 到达目的地的 路径数目 。由于答案可能很大，将结果对 10^9 + 7 取余 后返回。
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

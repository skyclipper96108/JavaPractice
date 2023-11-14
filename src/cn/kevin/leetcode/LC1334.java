package cn.kevin.leetcode;

import java.util.Arrays;

public class LC1334 {
    /*
        有 n 个城市，按从 0 到 n-1 编号。给你一个边数组 edges，其中 edges[i] = [fromi, toi, weighti] 代表 fromi 和 toi 两个城市之间的双向加权边，距离阈值是一个整数 distanceThreshold。
        返回能通过某些路径到达其他城市数目最少、且路径距离 最大 为 distanceThreshold 的城市。如果有多个这样的城市，则返回编号最大的城市。
        注意，连接城市 i 和 j 的路径的距离等于沿该路径的所有边的权重之和。
     */
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        //Floyd算法 初始化距离为图结构graph
        int [][] graph = new int[n][n];
        for (int i=0; i<n; i++){
            Arrays.fill(graph[i], Integer.MAX_VALUE/2);
        }
        for(int[] ed:edges){
            int from = ed[0];
            int to = ed[1];
            int weight=ed[2];
            graph[from][to] =graph[to][from]= weight;
        }
        for(int k=0; k<n; k++){
            graph[k][k] = 0;
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    graph[i][j] = Math.min(graph[i][j], graph[i][k]+graph[k][j]);

                }
            }
        }
        // graph图中存放的是该城市去往各个城市的最小距离
        int[] ans = {Integer.MAX_VALUE, -1};
        for(int i=0; i<n; i++){
            int temp = 0;
            for(int j=0; j<n; j++){
                if(graph[i][j]<=distanceThreshold) {
                    temp++;
                }
            }
            if(temp<=ans[0]){
                ans[0] = temp;
                ans[1] = i;
            }
        }
        return ans[1];
    }
}

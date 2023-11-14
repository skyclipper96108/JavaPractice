package cn.kevin.leetcode;

import java.util.Arrays;

public class LC1334 {
    /*
        �� n �����У����� 0 �� n-1 ��š�����һ�������� edges������ edges[i] = [fromi, toi, weighti] ���� fromi �� toi ��������֮���˫���Ȩ�ߣ�������ֵ��һ������ distanceThreshold��
        ������ͨ��ĳЩ·����������������Ŀ���١���·������ ��� Ϊ distanceThreshold �ĳ��С�����ж�������ĳ��У��򷵻ر�����ĳ��С�
        ע�⣬���ӳ��� i �� j ��·���ľ�������ظ�·�������бߵ�Ȩ��֮�͡�
     */
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        //Floyd�㷨 ��ʼ������Ϊͼ�ṹgraph
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
        // graphͼ�д�ŵ��Ǹó���ȥ���������е���С����
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

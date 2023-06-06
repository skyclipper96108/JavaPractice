package cn.kevin.leetcode;

import java.util.Arrays;

public class LC2352 {
    public int equalPairs(int[][] grid) {
        int count = 0;
        int leng = grid.length;
        int[][] gridT = new int[leng][leng];
        for(int i=0;i<leng;i++){
            for(int j=0;j<leng;j++){
                gridT[j][i]=grid[i][j];
            }
        }
        System.out.println(Arrays.deepToString(gridT));
        for(int i=0;i<leng;i++){
            for(int j=0;j<leng;j++){
                if(Arrays.equals(gridT[j], grid[i])){
                    count++;
                }
            }
        }
        return count;
    }
}

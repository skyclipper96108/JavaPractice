package cn.kevin.test;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * 题目描述
 * 定义一个二维数组 N*M，如 5x 5 数组下所示
 * int maze[5](5] =
 * 0,1,0,0,0,0, 1, 1, 1, 0,0,0,0,0,0,0, 1, 1, 1,0,0,0,0,1,0,
 * 它表示一个迷言，其中的1表示墙壁，0表示可以走的路，只能横着走或竖着走，不能斜着走，要求编程序找出从左上角到右下角的路线。
 * 入口点为[0.01.既第一格是可以走的路。
 * 数据范周: 2sn,ms10，输入的内容只包含 0svals1。
 * 输入描述
 * 输入两个整数，分别表示二维数组的行数，列数。再输入相应的数组，其中的1表示墙壁，0表示可以走的路。数据保证有唯一解,不考虑有多解的情况，即迷真只有一条通道。
 * 输出描述
 * 左上角到右下角的最短路径，格式如样例所示
 */
public class Maze {

    static int[][] offsets = {{-1,0},{1,0},{0,-1},{0,1}};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] matrix = new int[n][m];
        for(int i=0; i<n;i++){
            for(int j=0;j<m;j++){
                matrix[i][j] = sc.nextInt();
            }
        }

        findPath(n,m,matrix);
    }

    private static void findPath(int n, int m, int[][] matrix) {
        LinkedList<String> ans = new LinkedList<>();

        dfs(0,0,new LinkedList<>(),ans,n,m,matrix);
        ans.add("("+(n-1)+","+(m-1)+")");
        for(String an:ans){
            System.out.println(an);
        }
    }

    private static void dfs(int x, int y, LinkedList<String> path, LinkedList<String> ans, int n, int m, int[][] matrix) {
        if(x==n-1&&y==m-1){
            ans.addAll(path);
            return;
        }
        for(int[] offset:offsets){
            int newX = x+offset[0];
            int newY = y+offset[1];
            if(newX>=0&&newX<n&&newY>=0&&newY<m&&matrix[newX][newY]==0){
                path.add("("+x+","+y+")");
                matrix[x][y]=2;
                dfs(newX,newY,path,ans,n,m,matrix);
                path.removeLast();
            }
        }
    }
}

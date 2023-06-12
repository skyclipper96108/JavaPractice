package cn.kevin.test;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * 题目描述
 * 存在一个mxn的二维数组，其成员取值范围为0或1。其中值为1的成员具备扩散性，每经过1S，将上下左右值为0的成员同化为1。维数组的成员初始值都为0，将第和k.两个个位置上元素修改成1后，求矩阵的所有元素变为1需要多长时间
 * 输入描述
 * 输入数据中的前2个数字表示这是一个mxn的矩阵，m和n不会超过1024大小;
 * 中间两个数字表示一个初始扩散点位置为ij;
 * 最后2个数字表示另一个扩散点位置为k,1.
 * 输出描述
 * 输出矩阵的所有元素变为1所需要秒数
 */
public class MatrixDiffusion {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer[] arr = Arrays.stream(sc.next().split(",")).map(Integer::parseInt).toArray(Integer[]::new);
        System.out.println(diffusion(arr[0],arr[1],arr[2],arr[3],arr[4],arr[5]));
    }

    /**
     * @param m  mxn的二维数组
     * @param n  mxn的二维数组
     * @param i 扩教点位置为i,j
     * @param j
     * @param k
     * @param l
     * @return 扩教所有点脂要的时同
     */
    private static int diffusion(Integer m, Integer n, Integer i, Integer j, Integer k, Integer l) {
        int[][] matrix = new int[m][n];
        matrix[i][j] = 1;
        matrix[k][l] = 1;
        // count记最未数扩教的点的数鱼
        int count = m * n - 2;

        // 多源BFS实现M列
        LinkedList<int[]> queue = new LinkedList<>();
        queue.addLast(new int[] {i, j});
        queue.addLast(new int[] {k, l});
        // 上下左右编移量
        int[][] offsets = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int day = 1;
        // 如果扩散点没有了，或者所有扩散点已被扩展则停止循环
        while (queue.size() > 0 && count > 0) {
            int[] tmp = queue.removeFirst();
            int x = tmp[0];
            int y = tmp[1];
            // 我们假设初始扩教点的1代表第1秒被扩教到的，则下一波她扩教点的值就是1+1，即第2秒被扩教司的
            day = matrix[x][y] + 1;
            for (int[] offset : offsets) {
                int newX = x + offset[0];
                int newY = y + offset[1];
                if (newX >= 0 && newX < m && newY >= 0 && newY < n && matrix[newX][newY] == 0){
                    // 将点她扩教的时同记录为该点的值
                    matrix[newX][newY] = day;
                    // 剑扩教司的点将变为斯的扩教源
                    queue.addLast(new int[]{newX, newY});
                    //未被扩教点的最量--
                    count--;
                }
            }
        }

        return day-1;
    }
}

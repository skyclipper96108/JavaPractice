package cn.kevin.test;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * ��Ŀ����
 * ����һ��mxn�Ķ�ά���飬���Աȡֵ��ΧΪ0��1������ֵΪ1�ĳ�Ա�߱���ɢ�ԣ�ÿ����1S������������ֵΪ0�ĳ�Աͬ��Ϊ1��ά����ĳ�Ա��ʼֵ��Ϊ0�����ں�k.������λ����Ԫ���޸ĳ�1������������Ԫ�ر�Ϊ1��Ҫ�೤ʱ��
 * ��������
 * ���������е�ǰ2�����ֱ�ʾ����һ��mxn�ľ���m��n���ᳬ��1024��С;
 * �м��������ֱ�ʾһ����ʼ��ɢ��λ��Ϊij;
 * ���2�����ֱ�ʾ��һ����ɢ��λ��Ϊk,1.
 * �������
 * ������������Ԫ�ر�Ϊ1����Ҫ����
 */
public class MatrixDiffusion {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer[] arr = Arrays.stream(sc.next().split(",")).map(Integer::parseInt).toArray(Integer[]::new);
        System.out.println(diffusion(arr[0],arr[1],arr[2],arr[3],arr[4],arr[5]));
    }

    /**
     * @param m  mxn�Ķ�ά����
     * @param n  mxn�Ķ�ά����
     * @param i ���̵�λ��Ϊi,j
     * @param j
     * @param k
     * @param l
     * @return �������е�֬Ҫ��ʱͬ
     */
    private static int diffusion(Integer m, Integer n, Integer i, Integer j, Integer k, Integer l) {
        int[][] matrix = new int[m][n];
        matrix[i][j] = 1;
        matrix[k][l] = 1;
        // count����δ�����̵ĵ������
        int count = m * n - 2;

        // ��ԴBFSʵ��M��
        LinkedList<int[]> queue = new LinkedList<>();
        queue.addLast(new int[] {i, j});
        queue.addLast(new int[] {k, l});
        // �������ұ�����
        int[][] offsets = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int day = 1;
        // �����ɢ��û���ˣ�����������ɢ���ѱ���չ��ֹͣѭ��
        while (queue.size() > 0 && count > 0) {
            int[] tmp = queue.removeFirst();
            int x = tmp[0];
            int y = tmp[1];
            // ���Ǽ����ʼ���̵��1�����1�뱻���̵��ģ�����һ�������̵��ֵ����1+1������2�뱻����˾��
            day = matrix[x][y] + 1;
            for (int[] offset : offsets) {
                int newX = x + offset[0];
                int newY = y + offset[1];
                if (newX >= 0 && newX < m && newY >= 0 && newY < n && matrix[newX][newY] == 0){
                    // ���������̵�ʱͬ��¼Ϊ�õ��ֵ
                    matrix[newX][newY] = day;
                    // ������˾�ĵ㽫��Ϊ˹������Դ
                    queue.addLast(new int[]{newX, newY});
                    //δ�����̵������--
                    count--;
                }
            }
        }

        return day-1;
    }
}

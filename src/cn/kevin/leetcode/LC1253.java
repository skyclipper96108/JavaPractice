package cn.kevin.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * ����һ��2�� n �еĶ��������飺
 *
 * ������һ�������ƾ�������ζ�ž����е�ÿ��Ԫ�ز���0����1��
 * �� 0 �е�Ԫ��֮��Ϊupper��
 * �� 1 �е�Ԫ��֮��Ϊ lower��
 * �� i �У��� 0 ��ʼ��ţ���Ԫ��֮��Ϊcolsum[i]��colsum��һ������Ϊn���������顣
 * ����Ҫ����upper��lower��colsum���ع�������󣬲��Զ�ά�����������ʽ��������
 *
 * ����ж����ͬ�Ĵ𰸣���ô����һ��������ͨ�����⡣
 *
 * ��������ڷ���Ҫ��Ĵ𰸣����뷵��һ���յĶ�ά���顣
 *
 */
public class LC1253 {


    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        int n = colsum.length;
        int sum = 0;
        int count2 = 0;
        List<Integer> up = new ArrayList<>();
        List<Integer> down = new ArrayList<>();
        for (int j : colsum) {
            if(j==2){
                up.add(1);
                down.add(1);
                count2++;
            }else {
                up.add(0);
                down.add(0);
            }
            sum += j;
        }
        List<List<Integer>> res = new ArrayList<>();
        if(sum!=upper+lower||count2>Math.min(upper,lower)){
            return res;
        }
        int upper1 = upper-count2;
        for (int i=0;i<n;i++) {
            if(colsum[i]==1){
                if(upper1>0){
                    up.set(i,1);
                    down.set(i,0);
                    upper1--;
                }else {
                    up.set(i,0);
                    down.set(i,1);
                }
            }
        }
        res.add(up);
        res.add(down);
        return res;
    }
}

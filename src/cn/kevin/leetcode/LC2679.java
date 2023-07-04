package cn.kevin.leetcode;


import java.util.*;

/**
 * ����һ���±�� 0��ʼ�Ķ�ά��������nums��һ��ʼ��ķ���Ϊ0������Ҫִ�����²���ֱ�������Ϊ�գ�
 *
 * ������ÿһ��ѡȡ����һ��������ɾ���������һ�����ж����������ѡ������һ����ɾ����
 * �ڲ��� 1 ɾ���������������ҵ�����һ�����֣�������ӵ���� �����С�
 * ���㷵������ ������
 *
 */
public class LC2679 {


    public int matrixSum(int[][] nums) {
        Comparator<Integer> comparator = new Comparator<Integer>(){
            @Override
            public int compare(Integer i1, Integer i2) {
                if(Objects.equals(i1, i2)){
                    return 0;
                }else if(i1>i2){
                    return -1;
                }else {
                    return 1;
                }
            }
        };
        for(int[] arr:nums){
            Arrays.sort(arr);
        }
        int res = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>(comparator);
        for(int i=0;i<nums[0].length;i++){
            for(int[] arr:nums){
                queue.add(arr[i]);
            }
            if(!queue.isEmpty()){
                res+=queue.peek();
            }
            queue.clear();
        }
        return res;
    }
}

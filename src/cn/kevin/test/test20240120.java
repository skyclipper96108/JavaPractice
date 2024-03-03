package cn.kevin.test;

import java.util.*;

/**
 * 给你两个数组，arr1 和 arr2，
 *
 * arr2 中的元素各不相同
 * arr2 中的每个元素都出现在 arr1 中
 * 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
 *
 * 输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 * 输出：[2,2,2,1,4,3,3,9,6,7,19]
 */
public class test20240120 {
    public List<Integer> sortList(int[] arr1, int[] arr2){
        List<Integer> list = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for(int i:arr2){
            for(int j:arr1){
                if(i==j){
                    list.add(i);
                }
            }
        }
        for(int i:arr1){
            boolean flag=false;
            for(int j:arr2){
                if (i == j) {
                    flag = true;
                    break;
                }
            }
            if(!flag){
                list2.add(i);
            }
        }
        list2.sort(Comparator.comparingInt(a -> a));
        list.addAll(list2);
        return list;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{2,3,1,3,2,4,6,7,9,2,19,18};
        int[] arr2 = new int[]{2,1,4,3,9,6};
        test20240120 k = new test20240120();
        List<Integer> integers = k.sortList(arr1, arr2);
        System.out.println(integers.toString());
    }
}

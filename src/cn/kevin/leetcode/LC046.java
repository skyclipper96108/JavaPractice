package cn.kevin.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * ����һ�������ظ����ֵ����� nums �������� ���п��ܵ�ȫ���� ������� ������˳�� ���ش𰸡�
 */
public class LC046 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length==0){
            return res;
        }
        getArrange(res,nums,new ArrayList<>());
        return res;
    }

    private void getArrange(List<List<Integer>> res, int[] nums, List<Integer> list) {
        if(nums.length==list.size()){
            res.add(list);
        }
        for(int i:nums){
            if(list.contains(i)){
                continue;
            }
            List<Integer> list2 = new ArrayList<>(list);
            list2.add(i);
            getArrange(res,nums,list2);
        }
    }
}

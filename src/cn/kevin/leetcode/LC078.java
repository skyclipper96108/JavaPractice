package cn.kevin.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * ����һ���������� nums �������е�Ԫ�� ������ͬ �����ظ��������п��ܵ��Ӽ����ݼ�����
 *
 * �⼯ ���� �����ظ����Ӽ�������԰� ����˳�� ���ؽ⼯��
 */
public class LC078 {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        getSet(nums,res, 0,new ArrayList<>());
        return res;
    }

    private void getSet(int[] nums, List<List<Integer>> res, int k, List<Integer> temp) {
        if(k==nums.length-1){
            List<Integer> list = new ArrayList<>(temp);
            res.add(list);
            return;
        }
        getSet(nums,res,k+1,temp);
        temp.add(nums[k]);
        getSet(nums,res,k+1,temp);
        temp.remove(temp.size()-1);
    }
}

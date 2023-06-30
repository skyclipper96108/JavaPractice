package cn.kevin.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
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

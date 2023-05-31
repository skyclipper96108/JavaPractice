package cn.kevin.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请
 *
 * 你返回所有和为 0 且不重复的三元组。
 *
 */
public class LC015 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int length = nums.length;
        if(length <3){
            return res;
        }
        Arrays.sort(nums);
        for(int i=0; i<length; i++){
            if(nums[i]>0){
                break;
            }
            //去重
            if(i>0&&nums[i-1]==nums[i]){
                continue;
            }
            //定义双指针
            int l = i+1; int r = length-1;
            while (l<r){
                //双指针不重合 则判断三数之和
                int sum = nums[i] + nums[l] + nums[r];
                if(sum==0){
                    res.add(Arrays.asList(nums[i],nums[l],nums[r]));
                    //若l指针下一位等于l跳过
                    while(l<length-1&&nums[l+1]==nums[l]){
                        l++;
                    }
                    //若r指针前一位等于r跳过
                    while(r>0&&nums[r-1]==nums[r]){
                        r--;
                    }
                    l++;
                    r--;
                }else if(sum>0){
                    //和大于0，则r往前找
                    r--;
                }else {
                    //和小于0，则l向后找
                    l++;
                }

            }
        }
        return res;
    }

    public int threeSumClosest(int[] nums, int target) {

        int res=0;
        int c = Integer.MAX_VALUE;
        int length = nums.length;
        if(length <3){
            for(int n:nums){
                res+=n;
            }
            return res;
        }
        Arrays.sort(nums);
        res = nums[0]+nums[1]+nums[2];
        for(int i=0; i<length; i++){
            //去重
            if(i>0&&nums[i-1]==nums[i]){
                continue;
            }
            //定义双指针
            int l = i+1; int r = length-1;
            while (l<r){
                //双指针不重合 则判断三数之和
                int sum = nums[i] + nums[l] + nums[r];
                if(Math.abs(target-sum)<c){
                    res = sum;
                    c=Math.abs(target-sum);
                }
                if(sum==target){
                    return target;
                }else if(sum >target){
                    //和大于0，则r往前找
                    r--;
                }else {
                    //和小于0，则l向后找
                    l++;
                }

            }
        }
        return res;

    }


}

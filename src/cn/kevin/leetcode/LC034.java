package cn.kevin.leetcode;

/**
 * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
 *
 * 如果数组中不存在目标值 target，返回?[-1, -1]。
 *
 * 你必须设计并实现时间复杂度为?O(log n)?的算法解决此问题。
 */
public class LC034 {
    public int[] searchRange(int[] nums, int target) {
        int lens = nums.length;
        if(nums[0]>target||nums[nums.length-1]<target){
            return new int[]{-1,-1};
        }
        int left = findLeftBorder(nums,0,lens,target);
        int right = findRightBorder(nums,0,lens,target);
        return new int[]{left,right};
    }

    private int findRightBorder(int[] nums, int l, int r, int target) {
        return -1;
    }

    private int findLeftBorder(int[] nums,int l, int r, int target) {
        while(l<=r) {
            int mid = l+(l-r)/2;
            if(nums[mid]==target){

                return mid;
            }else if(nums[mid]<target){
                l=mid+1;
            }
            else {
                r = mid-1;
            }
        }
        return -1;
    }


}

package cn.kevin.leetcode;

/**
 * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 判断你是否能够到达最后一个下标。
 */
public class LC055 {

//    public int k = 0;
    public boolean canJump(int[] nums) {
//        int n = nums.length;
//        if(k>=n-1){
//            return true;
//        }
//        for(int i=nums[k];i>0;i--){
//            k+=i;
//            if(canJump(nums)){
//                return true;
//            }
//            k-=i;
//        }
//        return false;
        int n = nums.length;
        int k=0;
        for(int i=0;i<n;i++){
            if(i>k){
                return false;
            }
            k=Math.max(k,i+nums[i]);
        }
        return true;
    }





}

package cn.kevin.leetcode;

public class LC2460 {
    public int[] applyOperations(int[] nums) {
        int j=0;
        int len = nums.length;
        for(int i = 0; i< len; i++){
            if (i != len - 1 && nums[i] == nums[i + 1]) {
                nums[i]=nums[i]*2;
                nums[i+1]=0;
            }
            if(nums[i]!=0){
                nums[j]=nums[i];
                j++;
            }
        }
        while (j<len){
            nums[j]=0;
            j++;
        }
        return nums;
    }

}

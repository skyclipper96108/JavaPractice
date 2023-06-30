package cn.kevin.leetcode;

public class LC031 {

    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        //�Ӻ���ǰ����˳���
        while (i>=0&&nums[i]>=nums[i+1]){
            i--;
        }
        if(i>=0){
            int j = nums.length-1;
            while(j>=0&&nums[j]<=nums[i]){
                j--;
            }
            swap(nums,i,j);
        }
        reverse(nums,i+1);
    }
    //��ת�����д�left��ĩβ��ֵ
    private void reverse(int[] nums, int left) {
        int right = nums.length-1;
        while (left<right){
            swap(nums,left,right);
            left++;
            right--;
        }
    }
    //����������������
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
    }
}

package cn.kevin.leetcode;

/**
 * ����һ�����շǵݼ�˳�����е��������� nums����һ��Ŀ��ֵ target�������ҳ�����Ŀ��ֵ�������еĿ�ʼλ�úͽ���λ�á�
 *
 * ��������в�����Ŀ��ֵ target������?[-1, -1]��
 *
 * �������Ʋ�ʵ��ʱ�临�Ӷ�Ϊ?O(log n)?���㷨��������⡣
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

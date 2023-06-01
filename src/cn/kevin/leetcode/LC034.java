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
        if(lens==0||nums[0]>target||nums[nums.length-1]<target){
            return new int[]{-1,-1};
        }
        int left = findLeftBorder(nums,-1,lens-1,target);
        int right = findRightBorder(nums,0,lens,target);
        if(left<lens-1&&nums[left+1]==target){
            left=left+1;
        }else {
            left=-1;
        }
        if(right>0&&nums[right-1]==target){
            right=right-1;
        }else {
            right=-1;
        }
        return new int[]{left,right};
    }
    //����target��С����
    private int findRightBorder(int[] nums, int l, int r, int target) {
        while (l<r){
            int mid = l+(r-l)/2;
            if(nums[mid]<=target){
                l=mid+1;
            }else {
                r=mid;
            }
        }
        return l;
    }

    //С��target�������
    private int findLeftBorder(int[] nums,int l, int r, int target) {
        while(l<r) {
            int mid = l+(r-l+1)/2;
            if(nums[mid]>=target){
                r=mid-1;
            }else {
                l=mid;
            }
        }
        return r;
    }


}

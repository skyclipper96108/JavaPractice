package cn.kevin.leetcode;

/**
 * ����һ���Ǹ��������� nums �������λ������� ��һ���±� ��
 *
 * �����е�ÿ��Ԫ�ش������ڸ�λ�ÿ�����Ծ����󳤶ȡ�
 *
 * �ж����Ƿ��ܹ��������һ���±ꡣ
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

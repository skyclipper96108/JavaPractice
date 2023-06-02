package cn.kevin.leetcode;

public class LC026 {

    public int removeDuplicates(int[] nums) {
        int j=0;
        for(int i=0;i<nums.length;i++){
            if(j==0||nums[i]!=nums[j-1]){
                nums[j]=nums[i];
                j++;
            }
        }
        return j;
    }

    /**����һ������ nums��һ��ֵ val, ����Ҫ ԭ�� �Ƴ�������ֵ����val��Ԫ�أ��������Ƴ���������³��ȡ�
     *��Ҫʹ�ö��������ռ䣬������ʹ�� O(1) ����ռ䲢 ԭ�� �޸��������顣
     *Ԫ�ص�˳����Ըı䡣�㲻��Ҫ���������г����³��Ⱥ����Ԫ�ء�
     */
    public int removeElement(int[] nums, int val) {
        int j=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=val){
                nums[j]=nums[i];
                j++;
            }
        }
        return j;
    }
}

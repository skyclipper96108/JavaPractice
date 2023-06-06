package cn.kevin.leetcode;


/**
 * ���������� �ǵݼ�˳�� ���е���������?nums1 �� nums2�������������� m �� n ���ֱ��ʾ nums1 �� nums2 �е�Ԫ����Ŀ��
 *
 * ���� �ϲ� nums2 �� nums1 �У�ʹ�ϲ��������ͬ���� �ǵݼ�˳�� ���С�
 *
 * ע�⣺���գ��ϲ������鲻Ӧ�ɺ������أ����Ǵ洢������ nums1 �С�Ϊ��Ӧ�����������nums1 �ĳ�ʼ����Ϊ m + n������ǰ m ��Ԫ�ر�ʾӦ�ϲ���Ԫ�أ��� n ��Ԫ��Ϊ 0 ��Ӧ���ԡ�nums2 �ĳ���Ϊ n ��
 *
 */
public class LC088 {

    //����˫ָ��
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        m--;
        n--;
        for(int i=n+m+1;i>=0;i--){
            if(m<0){
                nums1[i]=nums2[n];
                n--;
            }else if (n<0){
                nums1[i]=nums1[m];
                m--;
            }else if(nums1[m]>=nums2[n]){
                nums1[i]=nums1[m];
                m--;
            }else {
                nums1[i]=nums2[n];
                n--;
            }
        }
    }
}

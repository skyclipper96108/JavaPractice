package cn.kevin.leetcode;

/**
 * ����������С�ֱ�Ϊ m �� n �����򣨴�С��������?nums1 ��?nums2�������ҳ���������������������� ��λ�� ��
 *
 * �㷨��ʱ�临�Ӷ�Ӧ��Ϊ O(log (m+n)) ��
 *
 */
public class LC004 {

    // select����ı��壬���ö��ֲ��ҷ��ݹ����k/2����������С�Ĳ���
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int k1 = (n+m+1)/2;
        int k2 = (n+m+2)/2;
        return (getMedianK(nums1,0,n-1,nums2,0,m-1,k1)+getMedianK(nums1,0,n-1,nums2,0,m-1,k2))/2;
    }

    /**
     *
     * @param nums1 ����1
     * @param s1 ��ʼ����1
     * @param e1 ��ֹ����1
     * @param nums2 ����2
     * @param s2 ��ʼ����2
     * @param e2 ��ֹ����2
     * @param k ��k���������λ����
     * @return ��λ��
     */
    private double getMedianK(int[] nums1, int s1, int e1, int[] nums2, int s2, int e2, int k) {
        int n = e1-s1+1;
        int m = e2-s2+1;
        if(n==0){
            return nums2[s2+k-1];
        }
        if(m==0){
            return nums1[s1+k-1];
        }
        //�ݹ���ֹ���� k=1 �Ƚ�����������СԪ��
        if(k==1){
            return Math.min(nums1[s1],nums2[s2]);
        }
        //ȡ�������k/2Ԫ�� ��������ȡβ��Ԫ��
        int i = s1 + Math.min(k/2, n)-1;
        int j = s2 + Math.min(k/2, m)-1;
        if(nums1[i]<=nums2[j]){
            //����1ǰk/2��Ԫ����ȥ
            return getMedianK(nums1, i+1,e1,nums2,s2,e2,k-(i+1-s1));
        }else{
            //����2ǰk/2��Ԫ����ȥ
            return getMedianK(nums1,s1,e1,nums2,j+1,e2,k-(j+1-s1));
        }

    }
}

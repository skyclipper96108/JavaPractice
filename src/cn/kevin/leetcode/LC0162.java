package cn.kevin.leetcode;

public class LC0162 {
    public int findPeakElement(int[] nums) {
        int l=0,r=nums.length-1;
        while (l<r){
            int mid = l+(r-l)/2;
            if(nums[mid]>nums[mid+1]){
                //����mid�ұ�
                r=mid;
            }else{
                l=mid+1;
            }
        }
        return l;
    }
    /**
     * һ�� 2D �����е� ��ֵ ��ָ��Щ �ϸ���� �����ڸ���(�ϡ��¡�����)��Ԫ�ء�
     *
     * ����һ�� �� 0 ��ʼ��� �� m x n ���� mat �����������������ڸ��ӵ�ֵ�� ����ͬ ���ҳ� ����һ�� ��ֵ mat[i][j] �� ������λ�� [i,j] ��
     *
     * ����Լ������������ܱ߻�����һȦֵΪ -1 �ĸ��ӡ�
     *
     * Ҫ�����д��ʱ�临�Ӷ�Ϊ O(m log(n)) �� O(n log(m)) ���㷨
     */
    public int[] findPeakGrid(int[][] mat) {
        int m = mat.length ;
        int l=0,r=m-1;
        while (l<r){
            int mid = l+(r-l)/2;
            int peak = findMaxElement(mat[mid]);
            if(mat[mid][peak]>mat[mid+1][peak]){
                //����mid�ұ�
                r=mid;
            }else{
                l=mid+1;
            }
        }
        return new int[]{l,findMaxElement(mat[l])};
    }
    public int findMaxElement(int[] arr){
        int k=0;
        for(int i=0;i<arr.length;i++){
            if(arr[k]<arr[i]){
                k=i;
            }
        }
        return k;
    }
}

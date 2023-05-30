package cn.kevin.leetcode;

/**
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组?nums1 和?nums2。请你找出并返回这两个正序数组的 中位数 。
 *
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 *
 */
public class LC004 {

    // select问题的变体，利用二分查找法递归查找k/2的数并舍弃小的部分
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int k1 = (n+m+1)/2;
        int k2 = (n+m+2)/2;
        return (getMedianK(nums1,0,n-1,nums2,0,m-1,k1)+getMedianK(nums1,0,n-1,nums2,0,m-1,k2))/2;
    }

    /**
     *
     * @param nums1 数组1
     * @param s1 起始索引1
     * @param e1 终止索引1
     * @param nums2 数组2
     * @param s2 起始索引2
     * @param e2 终止索引2
     * @param k 第k大的数（中位数）
     * @return 中位数
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
        //递归终止条件 k=1 比较两数组中最小元素
        if(k==1){
            return Math.min(nums1[s1],nums2[s2]);
        }
        //取两数组第k/2元素 若不够长取尾部元素
        int i = s1 + Math.min(k/2, n)-1;
        int j = s2 + Math.min(k/2, m)-1;
        if(nums1[i]<=nums2[j]){
            //数组1前k/2的元素舍去
            return getMedianK(nums1, i+1,e1,nums2,s2,e2,k-(i+1-s1));
        }else{
            //数组2前k/2的元素舍去
            return getMedianK(nums1,s1,e1,nums2,j+1,e2,k-(j+1-s1));
        }

    }
}

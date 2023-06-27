package cn.kevin.leetcode;

/**
 * 给你一个整数数组，返回它的某个非空 子数组（连续元素）在执行一次可选的删除操作后，所能得到的最大元素总和。
 * 换句话说，你可以从原数组中选出一个子数组，并可以决定要不要从中删除一个元素（只能删一次哦），（删除后）子数组中至少应当有一个元素，
 * 然后该子数组（剩下）的元素总和是所有子数组之中最大的。
 *
 */
public class LC1186 {
    public int maximumSum(int[] arr) {
        int len = arr.length;
        //定义dp数组
        int[] dp1 = new int[len];
        int[] dp0= new int[len];
        dp0[0]=arr[0];
        dp1[0]=0;
        int res=arr[0];
        for(int i=1;i<len;i++){
            dp0[i]=Math.max(dp0[i-1]+arr[i],arr[i]);
            dp1[i]=Math.max(dp0[i-1],dp1[i-1]+arr[i]);
            res=Math.max(res,Math.max(dp0[i],dp1[i]));
        }
        return res;
    }
}

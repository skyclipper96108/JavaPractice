package cn.kevin.leetcode;

/**
 * ����һ���������飬��������ĳ���ǿ� �����飨����Ԫ�أ���ִ��һ�ο�ѡ��ɾ�����������ܵõ������Ԫ���ܺ͡�
 * ���仰˵������Դ�ԭ������ѡ��һ�������飬�����Ծ���Ҫ��Ҫ����ɾ��һ��Ԫ�أ�ֻ��ɾһ��Ŷ������ɾ����������������Ӧ����һ��Ԫ�أ�
 * Ȼ��������飨ʣ�£���Ԫ���ܺ�������������֮�����ġ�
 *
 */
public class LC1186 {
    public int maximumSum(int[] arr) {
        int len = arr.length;
        //����dp����
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

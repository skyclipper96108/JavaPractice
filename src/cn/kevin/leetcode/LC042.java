package cn.kevin.leetcode;

/**
 * ���� n ���Ǹ�������ʾÿ�����Ϊ 1 �����ӵĸ߶�ͼ�����㰴�����е����ӣ�����֮���ܽӶ�����ˮ��
 */
public class LC042 {
    public int trap(int[] height) {
        int len = height.length;
        int [] leftMax = new int[len];
        for(int i=0; i<len; i++){
            if(i==0||height[i]>leftMax[i-1]){
                leftMax[i]=height[i];
            }else {
                leftMax[i]=leftMax[i-1];
            }
        }
        int [] rightMax = new int[len];
        for(int i=len-1; i>=0; i--){
            if(i==len-1||height[i]>rightMax[i+1]){
                rightMax[i]=height[i];
            }else {
                rightMax[i]=rightMax[i+1];
            }
        }
        int vol = 0;
        for(int i=0; i<len; i++){
            int max = Math.min(leftMax[i], rightMax[i]);
            if(max>height[i]){
                vol +=(max-height[i]);
            }
        }
        return vol;
    }
}

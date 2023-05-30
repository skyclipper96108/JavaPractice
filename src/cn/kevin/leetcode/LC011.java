package cn.kevin.leetcode;

public class LC011 {
	class Solution {
	    public int maxArea(int[] height) {
	        if(height.length<2)return 0;
	        int i=0, j=height.length-1, a=0;
	        while(i<j){
	            int h=Math.min(height[i],height[j]);
	            a=Math.max(a,h*(j-i));
	            if(height[i]<=height[j])i++;
	            else j--;
	        }
	        return a;
	    }
	}
}

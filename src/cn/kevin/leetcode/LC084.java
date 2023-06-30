package cn.kevin.leetcode;


import java.util.Stack;

/**
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 *
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 */
public class LC084 {


    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        if(n==0){
            return 0;
        }
        if(n==1){
            return heights[0];
        }
        Stack<Integer> stack = new Stack<>();
        int res=0;
        for(int i=0;i<n;i++){
            while (!stack.isEmpty()&&heights[i]<heights[stack.peek()]){
                int h = heights[stack.pop()];
                while (!stack.isEmpty()&&h==heights[stack.peek()]){
                    stack.pop();
                }
                int w=i;
                if(!stack.isEmpty()){
                    w=i-stack.peek()-1;
                }
                res = Math.max(res,w*h);
            }
            stack.push(i);
        }
        while (!stack.isEmpty()){
            int h = heights[stack.pop()];
            while (!stack.isEmpty()&&h==heights[stack.peek()]){
                stack.pop();
            }
            int w=n;
            if(!stack.isEmpty()){
                w=n-stack.peek()-1;
            }
            res = Math.max(res,w*h);
        }
        return res;
    }
}

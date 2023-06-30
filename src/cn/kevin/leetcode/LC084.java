package cn.kevin.leetcode;


import java.util.Stack;

/**
 * ���� n ���Ǹ�������������ʾ��״ͼ�и������ӵĸ߶ȡ�ÿ�����ӱ˴����ڣ��ҿ��Ϊ 1 ��
 *
 * ���ڸ���״ͼ�У��ܹ����ճ����ľ��ε���������
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

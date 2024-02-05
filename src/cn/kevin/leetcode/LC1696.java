package cn.kevin.leetcode;

import java.util.ArrayDeque;

public class LC1696 {


    public int maxResult(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n];
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.offerLast(0);
        dp[0]=nums[0];
        for(int i=1; i<n; i++){
            while (deque.size()>0&&deque.peekFirst()<i-k){
                deque.pollFirst();
            }
            if(deque.size()==0){
                return -1;
            }
            dp[i] = dp[deque.peekFirst()]+nums[i];
            while(!deque.isEmpty()&& dp[deque.peekLast()]<=dp[i]){
                deque.pollLast();
            }
            deque.offerLast(i);
        }
        return dp[n-1];
    }
}

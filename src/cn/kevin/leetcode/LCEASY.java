package cn.kevin.leetcode;

import java.util.*;

public class LCEASY {
    /**
     * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
     *
     * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
     *
     * 你可以假设除了整数 0 之外，这个整数不会以零开头
     * 066
     */
    public int[] plusOne(int[] digits) {
        for(int i=digits.length-1;i>=0;i--){
            if(digits[i]!=9){
                digits[i]++;
                break;
            }
            digits[i]=0;
            if(i==0){
                int[] res = new int[digits.length+1];
                res[0]=1;
                System.arraycopy(digits, 0, res, 1, digits.length);
                return res;
            }
        }
        return digits;
    }

    /**
     * 给定一个已排序的链表的头 head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表 。
     * 083
     */
    public class ListNode {
       int val;
       ListNode next;
       ListNode() {}
       ListNode(int val) { this.val = val; }
       ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        while (cur!=null&&cur.next!=null){
            while(cur.next!=null&&cur.val==cur.next.val){
                cur.next = cur.next.next;
            }
            cur = cur.next;
        }
        return head;
    }

    /**
     * 给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中 最后一个 单词的长度。
     *
     * 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
     * 058
     */
    public int lengthOfLastWord(String s) {
        String[] s1 = s.split(" ");
        String s0 = "";
        int i = s1.length-1;
        while (s0.equals("")){
            s0=s1[i];
            i--;
        }
        return s0.length();
    }


    /**
     * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
     *
     * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
     */
    public int climbStairs(int n) {
        int[] memo = new int[n+1];
        Arrays.fill(memo,-666);
        return findStairs(n,memo);
    }

    private int findStairs(int n, int[] memo) {
        if(memo[n]!=-666){
            return memo[n];
        }
        if(n==0){
            return 1;
        }
        if(n==1){
            return 1;
        }
        memo[n] = findStairs(n-1,memo)+findStairs(n-2,memo);
        return memo[n];
    }


    public int numTrees(int n) {
        int[] memo = new int[n+1];
        Arrays.fill(memo,-666);
        return findTrees(n,memo);
    }

    private int findTrees(int n, int[] memo) {
        if(memo[n]!=-666){
            return memo[n];
        }
        if(n==0){
            return 1;
        }
        if(n==1){
            return 1;
        }
        int k = 0;
        for(int i=1;i<=n;i++){
            k=k+findTrees(i-1,memo)*findTrees(n-i,memo);
        }
        memo[n] = k;
        System.out.println(Arrays.toString(memo));
        return memo[n];
    }

    /**
     * 袋子中装有一些物品，每个物品上都标记着数字 1 、0 或 -1 。
     *
     * 给你四个非负整数 numOnes 、numZeros 、numNegOnes 和 k 。
     *
     * 袋子最初包含：
     *
     * numOnes 件标记为 1 的物品。
     * numZeroes 件标记为 0 的物品。
     * numNegOnes 件标记为 -1 的物品。
     * 现计划从这些物品中恰好选出 k 件物品。返回所有可行方案中，物品上所标记数字之和的最大值。
     *
     */
    public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        if(k<=numOnes){
            return k;
        }else if(k<=numOnes+numZeros){
            return numOnes;
        }else {
            return 2*numOnes+numZeros-k;
        }
    }



    public int[] twoSum(int[] numbers, int target) {
        int l = 0, r = numbers.length - 1;
        while (l < r) {
            int sum = numbers[l] + numbers[r];
            if (sum == target) {
                return new int[]{l + 1, r + 1};
            } else if (sum < target) {
                l++;
            } else {
                r--;
            }
        }
        return new int[]{-1, -1};
    }

    /**
     *
     * 在桌子上有 n 张卡片，每张卡片的正面和背面都写着一个正数（正面与背面上的数有可能不一样）。
     *
     * 我们可以先翻转任意张卡片，然后选择其中一张卡片。
     *
     * 如果选中的那张卡片背面的数字 x 与任意一张卡片的正面的数字都不同，那么这个数字是我们想要的数字。
     *
     * 哪个数是这些想要的数字中最小的数（找到这些数中的最小值）呢？如果没有一个数字符合要求的，输出 0 。
     *
     * 其中, fronts[i] 和 backs[i] 分别代表第 i 张卡片的正面和背面的数字。
     *
     * 如果我们通过翻转卡片来交换正面与背面上的数，那么当初在正面的数就变成背面的数，背面的数就变成正面的数。
     * 822
     */
    public int flipgame(int[] fronts, int[] backs) {
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<fronts.length;i++){
            if(fronts[i]==backs[i]){
                set.add(fronts[i]);
            }
        }
        int res = 9999;
        for(int x:fronts){
            if(x<res&&!set.contains(x)){
                res=x;
            }
        }
        for(int x:backs){
            if(x<res&&!set.contains(x)){
                res=x;
            }
        }
        return res%9999;
    }

}

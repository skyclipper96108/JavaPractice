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

    /**
     * 给你一个下标从 0 开始的整数数组 nums 和一个整数 k 。你需要执行以下操作 恰好 k 次，最大化你的得分：
     *
     * 从 nums 中选择一个元素 m 。
     * 将选中的元素 m 从数组中删除。
     * 将新元素 m + 1 添加到数组中。
     * 你的得分增加 m 。
     * 请你返回执行以上操作恰好 k 次后的最大得分。
     * 2656
     */

    public int maximizeSum(int[] nums, int k) {
        int m = Arrays.stream(nums).max().getAsInt();
        return (2*m+k-1)*k/2;
    }

    /**
     * 给你一个下标从 0 开始的整数数组 nums 和一个整数 threshold 。
     *
     * 请你从 nums 的子数组中找出以下标 l 开头、下标 r 结尾 (0 <= l <= r < nums.length) 且满足以下条件的 最长子数组 ：
     *
     * nums[l] % 2 == 0
     * 对于范围 [l, r - 1] 内的所有下标 i ，nums[i] % 2 != nums[i + 1] % 2
     * 对于范围 [l, r] 内的所有下标 i ，nums[i] <= threshold
     * 以整数形式返回满足题目要求的最长子数组的长度。
     *
     * 注意：子数组 是数组中的一个连续非空元素序列。
     */
    public int longestAlternatingSubarray(int[] nums, int threshold) {
        // dp数组 以i开头的满足条件的子数组长度
        int dp=0; //状态压缩 只需要一组
        int res=0;
        int n=nums.length;
        for (int i=n-1; i>=0; i--){
            if(nums[i]>threshold) {
                dp=0;
            }else if(i==n-1||nums[i]%2!=nums[i+1]%2){
                dp++;
            }else {
                dp=1;
            }
            if(nums[i]%2==0){
                res=Math.max(dp,res);
            }
        }
        return res;
    }

    /**
     * 给你一个字符串数组 words 和一个字符串 s ，请你判断 s 是不是 words 的 首字母缩略词 。
     *
     * 如果可以按顺序串联 words 中每个字符串的第一个字符形成字符串 s ，则认为 s 是 words 的首字母缩略词。例如，"ab" 可以由 ["apple", "banana"] 形成，但是无法从 ["bear", "aardvark"] 形成。
     *
     * 如果 s 是 words 的首字母缩略词，返回 true ；否则，返回 false 。
     */
    public boolean isAcronym(List<String> words, String s) {
        String[] split = s.split("");
        if(split.length!=words.size()){
            return false;
        }
        for(int i=0;i<words.size();i++){
            if (!words.get(i).startsWith(split[i])){
                return false;
            }
        }
        return true;
    }

    /**
     * 圣诞活动预热开始啦，汉堡店推出了全新的汉堡套餐。为了避免浪费原料，请你帮他们制定合适的制作计划。
     *
     * 给你两个整数 tomatoSlices 和 cheeseSlices，分别表示番茄片和奶酪片的数目。不同汉堡的原料搭配如下：
     *
     * 巨无霸汉堡：4 片番茄和 1 片奶酪
     * 小皇堡：2 片番茄和 1 片奶酪
     * 请你以 [total_jumbo, total_small]（[巨无霸汉堡总数，小皇堡总数]）的格式返回恰当的制作方案，使得剩下的番茄片 tomatoSlices 和奶酪片 cheeseSlices 的数量都是 0。
     *
     * 如果无法使剩下的番茄片 tomatoSlices 和奶酪片 cheeseSlices 的数量为 0，就请返回 []。
     */
    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        List<Integer> res = new ArrayList<>();
        int minTomatoes=2* cheeseSlices;
        int maxTomatoes=4* cheeseSlices;
        if(tomatoSlices>=minTomatoes&&tomatoSlices<=maxTomatoes&&(tomatoSlices-minTomatoes)%2==0){
            int total_jumbo=(tomatoSlices-minTomatoes)/2;
            res.add(total_jumbo);
            res.add(cheeseSlices -total_jumbo);
            return res;
        }
        return res;
    }

    /**
     * 给你一个 非空 整数数组 nums ，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
     *
     * 你必须设计并实现线性时间复杂度的算法来解决此问题，且该算法只使用常量额外空间。
     */
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        for(int i=0; i<nums.length; i++){
            if(i==nums.length-1){
                return nums[i];
            }
            if(nums[i]==nums[i+1]){
                i++;
            }else{
                return nums[i];
            }
        }
        return -1;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
        }
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while(root!=null||!stack.isEmpty()){
            while (root!=null){
                stack.push(root);
                root=root.left;
            }
            root = stack.pop();
            res.add(root.val);
            root=root.right;
        }
        return res;
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while(root!=null||!stack.isEmpty()){
            while (root!=null){
                res.add(root.val);
                stack.push(root);
                root=root.left;
            }
            root = stack.pop();
            root=root.right;
        }
        return res;
    }

    class MyStack {

        private Queue<Integer> queue1;
        private Queue<Integer> queue2;
        public MyStack() {
            queue1=new LinkedList<>();
            queue2=new LinkedList<>();
        }

        public void push(int x) {
            queue2.offer(x);
            while (!queue1.isEmpty()){
                queue2.offer(queue1.poll());
            }
            Queue<Integer> t = queue1;
            queue1=queue2;
            queue2=t;
        }

        public int pop() {
            return queue1.poll();
        }

        public int top() {
            return queue1.peek();
        }

        public boolean empty() {
            return queue1.isEmpty();
        }
    }

    class MyQueue {

        private Stack<Integer> stack1;
        private Stack<Integer> stack2;
        public MyQueue() {
            stack1=new Stack<>();
            stack2=new Stack<>();
        }

        public void push(int x) {
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
            stack1.push(x);
            while (!stack2.isEmpty()){
                stack1.push(stack2.pop());
            }
        }

        public int pop() {
            return stack1.pop();
        }

        public int peek() {
            return stack1.peek();
        }

        public boolean empty() {
            return stack1.isEmpty();
        }
    }
}

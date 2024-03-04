package cn.kevin.leetcode;

import java.util.*;

public class LCEASY {
    /**
     * ����һ���� ���� ��ɵ� �ǿ� ��������ʾ�ķǸ��������ڸ����Ļ����ϼ�һ��
     *
     * ���λ���ִ�����������λ�� ������ÿ��Ԫ��ֻ�洢�������֡�
     *
     * ����Լ���������� 0 ֮�⣬��������������㿪ͷ
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
     * ����һ��������������ͷ head �� ɾ�������ظ���Ԫ�أ�ʹÿ��Ԫ��ֻ����һ�� ������ ����������� ��
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
     * ����һ���ַ��� s�������ɵ�����ɣ�����ǰ����һЩ�ո��ַ������������ַ����� ���һ�� ���ʵĳ��ȡ�
     *
     * ���� ��ָ������ĸ��ɡ��������κοո��ַ���������ַ�����
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
     * ������������¥�ݡ���Ҫ n ������ܵ���¥����
     *
     * ÿ��������� 1 �� 2 ��̨�ס����ж����ֲ�ͬ�ķ�����������¥���أ�
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
     * ������װ��һЩ��Ʒ��ÿ����Ʒ�϶���������� 1 ��0 �� -1 ��
     *
     * �����ĸ��Ǹ����� numOnes ��numZeros ��numNegOnes �� k ��
     *
     * �������������
     *
     * numOnes �����Ϊ 1 ����Ʒ��
     * numZeroes �����Ϊ 0 ����Ʒ��
     * numNegOnes �����Ϊ -1 ����Ʒ��
     * �ּƻ�����Щ��Ʒ��ǡ��ѡ�� k ����Ʒ���������п��з����У���Ʒ�����������֮�͵����ֵ��
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
     * ���������� n �ſ�Ƭ��ÿ�ſ�Ƭ������ͱ��涼д��һ�������������뱳���ϵ����п��ܲ�һ������
     *
     * ���ǿ����ȷ�ת�����ſ�Ƭ��Ȼ��ѡ������һ�ſ�Ƭ��
     *
     * ���ѡ�е����ſ�Ƭ��������� x ������һ�ſ�Ƭ����������ֶ���ͬ����ô���������������Ҫ�����֡�
     *
     * �ĸ�������Щ��Ҫ����������С�������ҵ���Щ���е���Сֵ���أ����û��һ�����ַ���Ҫ��ģ���� 0 ��
     *
     * ����, fronts[i] �� backs[i] �ֱ����� i �ſ�Ƭ������ͱ�������֡�
     *
     * �������ͨ����ת��Ƭ�����������뱳���ϵ�������ô��������������ͱ�ɱ����������������ͱ�����������
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
     * ����һ���±�� 0 ��ʼ���������� nums ��һ������ k ������Ҫִ�����²��� ǡ�� k �Σ������ĵ÷֣�
     *
     * �� nums ��ѡ��һ��Ԫ�� m ��
     * ��ѡ�е�Ԫ�� m ��������ɾ����
     * ����Ԫ�� m + 1 ��ӵ������С�
     * ��ĵ÷����� m ��
     * ���㷵��ִ�����ϲ���ǡ�� k �κ�����÷֡�
     * 2656
     */

    public int maximizeSum(int[] nums, int k) {
        int m = Arrays.stream(nums).max().getAsInt();
        return (2*m+k-1)*k/2;
    }

    /**
     * ����һ���±�� 0 ��ʼ���������� nums ��һ������ threshold ��
     *
     * ����� nums �����������ҳ����±� l ��ͷ���±� r ��β (0 <= l <= r < nums.length) ���������������� ������� ��
     *
     * nums[l] % 2 == 0
     * ���ڷ�Χ [l, r - 1] �ڵ������±� i ��nums[i] % 2 != nums[i + 1] % 2
     * ���ڷ�Χ [l, r] �ڵ������±� i ��nums[i] <= threshold
     * ��������ʽ����������ĿҪ����������ĳ��ȡ�
     *
     * ע�⣺������ �������е�һ�������ǿ�Ԫ�����С�
     */
    public int longestAlternatingSubarray(int[] nums, int threshold) {
        // dp���� ��i��ͷ�����������������鳤��
        int dp=0; //״̬ѹ�� ֻ��Ҫһ��
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
     * ����һ���ַ������� words ��һ���ַ��� s �������ж� s �ǲ��� words �� ����ĸ���Դ� ��
     *
     * ������԰�˳���� words ��ÿ���ַ����ĵ�һ���ַ��γ��ַ��� s ������Ϊ s �� words ������ĸ���Դʡ����磬"ab" ������ ["apple", "banana"] �γɣ������޷��� ["bear", "aardvark"] �γɡ�
     *
     * ��� s �� words ������ĸ���Դʣ����� true �����򣬷��� false ��
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
     * ʥ���Ԥ�ȿ�ʼ�����������Ƴ���ȫ�µĺ����ײ͡�Ϊ�˱����˷�ԭ�ϣ�����������ƶ����ʵ������ƻ���
     *
     * ������������ tomatoSlices �� cheeseSlices���ֱ��ʾ����Ƭ������Ƭ����Ŀ����ͬ������ԭ�ϴ������£�
     *
     * ���ްԺ�����4 Ƭ���Ѻ� 1 Ƭ����
     * С�ʱ���2 Ƭ���Ѻ� 1 Ƭ����
     * ������ [total_jumbo, total_small]��[���ްԺ���������С�ʱ�����]���ĸ�ʽ����ǡ��������������ʹ��ʣ�µķ���Ƭ tomatoSlices ������Ƭ cheeseSlices ���������� 0��
     *
     * ����޷�ʹʣ�µķ���Ƭ tomatoSlices ������Ƭ cheeseSlices ������Ϊ 0�����뷵�� []��
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
     * ����һ�� �ǿ� �������� nums ������ĳ��Ԫ��ֻ����һ�����⣬����ÿ��Ԫ�ؾ��������Ρ��ҳ��Ǹ�ֻ������һ�ε�Ԫ�ء�
     *
     * �������Ʋ�ʵ������ʱ�临�Ӷȵ��㷨����������⣬�Ҹ��㷨ֻʹ�ó�������ռ䡣
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

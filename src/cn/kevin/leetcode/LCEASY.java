package cn.kevin.leetcode;

import java.util.Arrays;

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
}

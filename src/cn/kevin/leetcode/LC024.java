package cn.kevin.leetcode;

/**
 * ����һ���������������������ڵĽڵ㣬�����ؽ����������ͷ�ڵ㡣������ڲ��޸Ľڵ��ڲ���ֵ���������ɱ��⣨����ֻ�ܽ��нڵ㽻������
 */
public class LC024 {
    public class ListNode {
       int val;
       ListNode next;
       ListNode() {}
       ListNode(int val) { this.val = val; }
       ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode swapPairs(ListNode head) {
        if(head==null){
            return head;
        }
        ListNode ret = head.next;
        if(ret==null){
            return head;
        }
        head.next = swapPairs(ret.next);
        ret.next = head;
        return ret;
    }
}

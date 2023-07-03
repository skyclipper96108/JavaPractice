package cn.kevin.leetcode;

public class LC445 {

    public class ListNode {
       int val;
       ListNode next;
       ListNode() {}
       ListNode(int val) { this.val = val; }
       ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1=reverseList(l1);
        l2=reverseList(l2);
        ListNode l3 = add(l1,l2,0);
        return reverseList(l3);
    }

    private ListNode add(ListNode l1, ListNode l2,int extra) {
        if(l1==null&&l2==null){
            return extra==0?null:new ListNode(extra);
        }
        if(l1==null){
            l1=l2;
            l2=null;
        }
        int value = l1.val+(l2==null?0:l2.val)+extra;
        extra=value/10;
        l1.val = value % 10;
        l1.next=add(l1.next,(l2==null?null:l2.next),extra);
        return l1;
    }

    private ListNode reverseList(ListNode node) {
        if(node==null||node.next==null){
            return node;
        }
        ListNode res = reverseList(node.next);
        node.next.next=node;
        node.next=null;
        return res;
    }
}

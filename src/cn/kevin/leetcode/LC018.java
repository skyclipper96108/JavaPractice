package cn.kevin.leetcode;

/**
 * ��������������ϲ�Ϊһ���µ� ���� �������ء���������ͨ��ƴ�Ӹ�����������������нڵ���ɵġ�
 * public class ListNode {
 *      int val;
 *      ListNode next;
 *      ListNode() {}
 *      ListNode(int val) { this.val = val; }
 *      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 *  }
 */

public class LC018 {
    public class ListNode {
       int val;
       ListNode next;
       ListNode() {}
       ListNode(int val) { this.val = val; }
       ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null){
            return list2;
        }
        if(list2==null){
            return list1;
        }
        //�Ƚ����������ͷ�ڵ㣬ֵС����Ϊ�µ������ͷ�ڵ�
        if(list1.val<=list2.val){
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        }else {
            list2.next = mergeTwoLists(list1,list2.next);
            return list2;
        }
    }
}

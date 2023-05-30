package cn.linkedlist;
/**
 * 删除链表中值为val的所有元素
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class LC203 {
	// 常规解法
    public ListNode removeElements(ListNode head, int val) {
    	ListNode dummyhead = new ListNode();
    	dummyhead.next = head;
    	ListNode prev = dummyhead;
    	while(prev.next!=null) {
    		if(prev.next.val==val)
    			prev.next = prev.next.next;
    		else prev = prev.next;
    	}
    	return dummyhead.next;
    }
    // 递归解法
    public ListNode removeElements2(ListNode head, int val) {
    	if(head==null)return null;
    	head.next = removeElements2(head.next, val);
    	if(head.val ==val)return head.next;
    	else return head;
    }

    public static void main(String[] args) {
    	int[] nums = {112,24,53,6,46};
    	ListNode head1 = new ListNode(nums);
    	System.out.println(head1);
    	ListNode head2 = (new LC203()).removeElements(head1, 6);
    	System.out.println(head2);

    }
}

package cn.linkedlist;
// 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
public class LC206 {
	public ListNode reverseList(ListNode head) {
		
		ListNode prev = null;
		ListNode cur = head;
		while(cur!=null) {
			ListNode next = cur.next;	
			cur.next = prev;
			prev = cur;
			cur = next;
		}
		return prev;
    }
	// 递归实现
	public ListNode reverseList2(ListNode head) {
		if(head==null || head.next==null)return null;
		ListNode rev = reverseList(head.next);
		head.next.next=head;
		head.next=null;
		return rev;
	}
}

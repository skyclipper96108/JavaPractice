package cn.linkedlist;
// ���㵥�����ͷ�ڵ� head �����㷴ת���������ط�ת�������
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
	// �ݹ�ʵ��
	public ListNode reverseList2(ListNode head) {
		if(head==null || head.next==null)return null;
		ListNode rev = reverseList(head.next);
		head.next.next=head;
		head.next=null;
		return rev;
	}
}

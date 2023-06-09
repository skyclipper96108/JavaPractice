package cn.linkedlist;

public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    // 链表节点的构造函数
    // 使用arr为参数创建一个链表输出头节点
    public ListNode(int[] arr) {
    	if(arr==null || arr.length==0)
    		throw new IllegalArgumentException("arr can't be empty");
    	this.val = arr[0];
    	ListNode cur = this;
    	for(int i =0; i<arr.length; i++) {
    		cur.next = new ListNode(arr[i]);
    		cur = cur.next;
    	}
    }
    // 以当前节点为头结点的链表信息字符串
    @Override
    public String toString() {
    	StringBuilder res = new StringBuilder();
    	ListNode cur= this;
    	while(cur!=null) {
    		res.append(cur.val+"→");
    		cur = cur.next;
    	}
    	res.append("Null");
    	return res.toString();
    	
    }
    
 }

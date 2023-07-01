package cn.kevin.leetcode;

import java.util.HashMap;
import java.util.Map;

class LC002 {
	public class ListNode {
	      int val;
	      ListNode next;
	      ListNode() {}
	      ListNode(int val) { this.val = val; }
	      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode();
        ListNode res = l3;
        ListNode prev = l3;
        int c=0;
        int sum=0;
        while(l1!=null || l2!=null || c!=0) {
            if(l1==null&&l2!=null)sum=l2.val+c;
            else if(l2==null&&l1!=null)sum=l1.val+c;
            else if(l2!=null&&l1!=null) sum =l1.val+l2.val+c;
            else sum=c;
            c=sum/10;
            l3.val=sum%10;
            l3.next=new ListNode();
            prev=l3;
            l3=l3.next;
            if(l1!=null)l1=l1.next;
            if(l2!=null)l2=l2.next;
        }
        if(l3.val==0)prev.next=null;
        return res;
    }





    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int k = nums[i];
            if(map.containsKey(target-k)){
                return new int[]{i,map.get(target-k)};
            }else{
                map.put(k,i);
            }
        }
        return new int[0];
    }
}

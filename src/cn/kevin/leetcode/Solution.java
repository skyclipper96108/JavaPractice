package cn.kevin.leetcode;
import java.util.HashSet;
class Solution {
    public static int lengthOfLongestSubstring(String s) {
//    	StringBuilder sol = new StringBuilder(s);
//    	Queue<Character> q = new LinkedList<>();
//    	if(s.isEmpty())return 0;
//    	q.add(sol.charAt(0));   	
//    	int maxLength=1;
//		for(int i=1; i<sol.length(); i++) {
//			Queue<Character> q2 = new LinkedList<>();
//			for(int j=0; j<q.size()+q2.size(); j++) {		
//				if(q.peek()==(sol.charAt(i))) {
//					q.remove();
//					break;
//				}
//				q2.add(q.remove());
//				if(q.size()==0)q=q2;
//			}
//			q.add(sol.charAt(i));
//			if(q.size()>maxLength)
//				maxLength=q.size();
//		}
    	int maxLength=0;
    	HashSet<Character>hs = new HashSet<>();
    	for(int i=0, j=0; j<s.length(); j++) {
    		hs.add(s.charAt(j));
    		if(s.charAt(i)==s.charAt(j)&&i!=j) {
    			i++;
    		}else if(hs.size()!=j-i+1){
	    		do{
	    			hs.remove(s.charAt(i));
	    			i++;
	    			}while(s.charAt(i)!=s.charAt(j)) ;
	    		i++;
    		}
    		maxLength=maxLength>hs.size()?maxLength:hs.size();
    		System.out.println(hs.toString());
    		System.out.println(i);
			System.out.println(j);
    	}
    	return maxLength;    	
    }
}

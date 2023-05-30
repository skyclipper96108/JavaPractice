package cn.kevin.leetcode;

import java.util.HashMap;

public class LC012 {
	public int romanToInt(String s) {
		HashMap<Character, Integer> match=new HashMap<>();
		match.put('I', 1);
		match.put('V', 5);
		match.put('X', 10);
		match.put('L', 50);
		match.put('C', 100);
		match.put('D', 500);
		match.put('M', 1000);
		char [] ch=s.toCharArray();
		int sum=0;
		for(int i=0; i<ch.length-1; i++) {
			System.out.println(match.get(ch[i]));
			if(match.get(ch[i])<match.get(ch[i+1]))sum-=match.get(ch[i]);
			else sum+=match.get(ch[i]);
		}
		return sum+match.get(ch[ch.length-1]);
    }
}

package cn.kevin.leetcode;

import org.junit.Test;

public class LCTest {

	@Test
	public void test28() {
		LC028 lc = new LC028();
		int i = lc.divide(-2147483648,-1);
		System.out.println(i);
	}



	@Test
	public void test38() {
		LC038 lc = new LC038();
		String i = lc.countAndSay(20);
		System.out.println(i);
	}

}

package cn.kevin.leetcode;

import org.junit.Test;

import java.util.List;

public class LCTest {

	@Test
	public void test28() {
		LC005 lc = new LC005();
		String i = lc.longestPalindrome("aaaa");
		System.out.println(i);
	}



	@Test
	public void test54() {
		LC054 lc = new LC054();
		int[][] l = new int[][]{{3,2,1}};
		List<Integer> integers = lc.spiralOrder(l);
		System.out.println(integers.toString());
	}

	@Test
	public void test53() {
		LC053 lc = new LC053();
		int[] l = new int[]{-2,1,-3,4,-1,2,1,-5,4};
		int i = lc.maxSubArray(l);
		System.out.println(i);
	}

	@Test
	public void test2611() {
		LC2611 lc = new LC2611();
//		int[][] l = new int[][]{{3,2,1},{1,7,6},{2,7,7}};
		int[] l1 = new int[]{2,1};
		int[] l2 = new int[]{1,2};
		int i = lc.miceAndCheese(l1,l2,1);
		System.out.println(i);
	}

	@Test
	public void testEasy() {
		LCEASY lc = new LCEASY();
		int i = lc.numTrees(3);
		System.out.println(i);
	}

}

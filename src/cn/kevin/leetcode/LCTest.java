package cn.kevin.leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LCTest {

	@Test
	public void test28() {
		LC005 lc = new LC005();
		String i = lc.longestPalindrome("aaaa");
		System.out.println(i);
	}



	@Test
	public void test54() {
		LC056 lc = new LC056();
		int[][] l = new int[][]{{1,3},{2,6},{8,10},{15,18}};
		int[][] merge = lc.merge(l);
		System.out.println(Arrays.deepToString(merge));
	}

	@Test
	public void test53() {
		HashMap<String, String > map1  = new HashMap<String, String>(){{
			put("a","b");
			put("b","b");
		}};
		Map<Object, String> map2 = new HashMap<>();
		System.out.println(map1.getClass());
		System.out.println(map2.getClass());
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

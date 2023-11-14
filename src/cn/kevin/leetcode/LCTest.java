package cn.kevin.leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LCTest {

	@Test
	public void test28() {
		LC1334 lc = new LC1334();
		int[][] l = new int[][]{{0,1,2},{0,4,8},{1,2,3},{1,4,2},{2,3,1},{3,4,1}};
		int i = lc.findTheCity(5,l,2);
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
		LC2532 lc = new LC2532();
		int[][] l = new int[][]{{1,9,1,8},{10,10,10,10}};
		int i = lc.findCrossingTime(3,2,l);
		System.out.println(i);
	}

	@Test
	public void testEasy() {
		LCEASY lc = new LCEASY();
		int i = lc.numTrees(3);
		System.out.println(i);
	}

}

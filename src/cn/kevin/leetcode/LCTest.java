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
	public void test0162() {
		LC0162 lc = new LC0162();
		int[][] l = new int[][]{{10,50,40,30,20},{1,500,2,3,4}};
		int[] peakGrid = lc.findPeakGrid(l);
		System.out.println(Arrays.toString(peakGrid));
	}

	@Test
	public void testEasy() {
		LCEASY lc = new LCEASY();
		int i = lc.numTrees(3);
		System.out.println(i);
	}

	@Test
	public void testCase() {
		String t1 = "2023-07-15";
		String t2 = "2023-12-15";
		System.out.println(t1.compareTo(t2));
	}

}

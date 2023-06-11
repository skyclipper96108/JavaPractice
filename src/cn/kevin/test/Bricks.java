package cn.kevin.test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 题目描述
 * Solo只和koko是两兄弟，妈妈给了他们一大堆积木，每块积木上都有自己的重量，现在他们想要将这些积木分成两堆。哥哥Solo负责分配，弟弟koko要求两个人获得的积木总重量“相等”(根据Koko的逻辑)，个数可以不同，不然就会哭，koko只会先将两个数转成二进制再进行加法，而且总会忘记进位(每个进位都忘记)，如当25 (11101) 加11 (01011) 时，k得到的计算结果是18 (10010):
 * 11001
 * +01011
 * 10010
 * Solo想要尽可能使自己得到的积木总重量最大，且不让koko哭
 * 输入描述
 * 第一行是一个整数N(2≤N≤100)，表示有多少块积木:
 * 第二行为空格分开的N个整数Ci(1sCis106)，表示第i块积木的重量。
 * 输出描述
 * 如果能让koko不哭，输出Solo所能获得积木的最大总重量; 否则输出“NO”
 */
public class Bricks {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) weights[i] = sc.nextInt();
        System.out.println(getMaxWeight(n, weights));
    }

    private static String getMaxWeight(int n, int[] weights) {
        // 升序
        Arrays.sort(weights);
        int min = weights[0];
        // correctSum记录solo 计算的正锦的总重量
        int correctSum = min;
        // faultSum 记Koko计的错误的总重量
        int faultSum = min;
        for (int i = 1; i < weights.length; i++) {
            correctSum += weights[i];
            //koko计算逻辑
            faultSum^=weights[i];
        }
        //如果按航Koko计算方法，若想校重量平分，必然会生成两母相同的二进制数，而两个相同二进制数，按位异或的结果必然是0
        if(faultSum==0){
            //faultSum-0表示可以平分，因此任意减去一个重量，韶可以得到两个相同的二进制数，因此就减去展小的，这林SoLo就可以升得最重
            return correctSum-min+"";
        }else {
            //faultsum != 0 表示无法按服Koko的逻趣平分
            return "NO";
        }
    }
}

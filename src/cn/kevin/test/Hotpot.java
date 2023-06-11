package cn.kevin.test;


import java.util.Arrays;
import java.util.Scanner;

/**
 * 题目描述
 * 入职后，导师会请你吃饭，你选择了火锅。
 * 火锅里会在不同时间下很多菜
 * 不同食材要煮不同的时问，才能变得刚好合适你希盟吃到最多的刚好合适的菜，但你的手迪不够快，用而代表手迪，每次下手捞菜后至少要过m秒才能再捞(每次只能捞一个)那么用最合理的策略，最多能吃到多少刚好合适的菜?
 * 输入描述
 * 第一行两个整数n，m，其中n代表往锅里下的菜的个数，m代表手速。 (1 n,m<1000)接下来有n行，每行有两个数x，y代表第x秒下的菜过y秒才能变得刚好合适。 (1x,y < 1000)
 * 输出描述
 * 输出一个整数代表用最合理的策略，最多能吃到刚好合适的菜的数量.
 */
public class Hotpot {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] suit = new int[n];
        for (int i = 0; i < n; i++) {
            suit[i] = sc.nextInt() + sc.nextInt();
        }
        System.out.println(getFood(n, m, suit));
    }

    private static int getFood(int n, int m, int[] suit) {
        Arrays.sort(suit);

        int count = 1;
        int pre = 0;
        for(int i=1;i<suit.length;i++){
            if(suit[i]>=suit[pre]+m){
                count++;
                //如要本次合适的菜，则必须要与上次苏菜的时间差大于等于m，注意这里是suit[pre] + m ，而不是suit[i-1] +m
                pre=i;
                //如果本次捞了菜，则更新缓存本次捞菜的时间点
            }
        }
        return count;
    }

}

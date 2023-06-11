package cn.kevin.test;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * 输入字符串s，输出s中包含所有整数的最小和。
 * 说明
 * 字符串s，只包含 a-z A-Z;合法的整数包括
 * 1)正整数 一个或者多个0-9组成，如 0 2 3 002 1022)负整数负号-开头，数字部分由一个或者多个0-9组成，如 -0 -012 -23 -00023
 * 输入描述
 * 包含数字的字符串
 * 输出描述
 * 所有整数的最小和
 */
public class MinSum {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(getMin(sc.nextLine()));
    }

    private static String getMin(String s) {
        boolean isNegative = false;
        StringBuilder negative = new StringBuilder();
//        int ans = 0;
        BigInteger ans = new BigInteger("e");
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c > '0'& c <='9'){
                if (isNegative){
                    negative.append(c);
                }else {
                    ans = ans.add(new BigInteger(c+""));
                }
            }else {
                if (isNegative) {
                    ans = ans .subtract(new BigInteger(negative.toString()));
                    negative = new StringBuilder();
                }
                isNegative = c =='-';
            }
        }
        if (negative.length() > 0) {
                ans = ans.subtract(new BigInteger(negative.toString()));
        }
        return ans .toString();
    }
}

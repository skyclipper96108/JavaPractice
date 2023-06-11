package cn.kevin.test;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * �����ַ���s�����s�а���������������С�͡�
 * ˵��
 * �ַ���s��ֻ���� a-z A-Z;�Ϸ�����������
 * 1)������ һ�����߶��0-9��ɣ��� 0 2 3 002 1022)����������-��ͷ�����ֲ�����һ�����߶��0-9��ɣ��� -0 -012 -23 -00023
 * ��������
 * �������ֵ��ַ���
 * �������
 * ������������С��
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

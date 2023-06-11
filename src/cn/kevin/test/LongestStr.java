package cn.kevin.test;

import java.util.LinkedList;

import java.util.Scanner;

/**
 * 给定一个字符串，只包含字母和数字，按费求找出字符串中的最长(连续 ) 子串的长度，字符串本身是其最长的子串，子串要求:1、只包含1个字母(a~z,A-Z)，其余必须是数字;
 * 2、字母可以在子串中的任意位置 :
 * 如果找不到满足要求的子串，如全是字母或全是数字，则返回-1.
 * 输入描述
 * 字符串(只包含字母和数字)
 * 输出描述
 * 子串的长度
 */
public class LongestStr {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(getLongest(sc.nextLine()));
    }

    private static int getLongest(String str) {
        int maxLen = -1;
        boolean hasLetter = false;
        int l=0, r=0;
        LinkedList<Integer> letterIndex = new LinkedList<>();
        while (r<str.length()){
            char c = str.charAt(r);
            if(isLetter(c)){
                hasLetter=true;
                letterIndex.add(r);
                if(letterIndex.size()>1){
                    l=letterIndex.removeFirst()+1;
                }
                if(r==l){
                    r++;
                    continue;
                }
            }
            maxLen = Math.max(maxLen,r-l+1);
            r++;
        }
        if(!hasLetter){
            return -1;
        }
        return maxLen;
    }

    public static boolean isLetter(char c) {
        return (c >= 'a'&& c <= 'z') || (c >= 'A'&& c <'z');
    }
}

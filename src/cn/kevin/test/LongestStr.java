package cn.kevin.test;

import java.util.LinkedList;

import java.util.Scanner;

/**
 * ����һ���ַ�����ֻ������ĸ�����֣��������ҳ��ַ����е��(���� ) �Ӵ��ĳ��ȣ��ַ���������������Ӵ����Ӵ�Ҫ��:1��ֻ����1����ĸ(a~z,A-Z)���������������;
 * 2����ĸ�������Ӵ��е�����λ�� :
 * ����Ҳ�������Ҫ����Ӵ�����ȫ����ĸ��ȫ�����֣��򷵻�-1.
 * ��������
 * �ַ���(ֻ������ĸ������)
 * �������
 * �Ӵ��ĳ���
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

package cn.kevin.leetcode;

import java.util.ArrayList;
import java.util.List;

public class test20230704 {



    public static void main(String[] args) {

        int n = 500;
        int k = 30;
        int p = 16;
        test20230704 test20230704 = new test20230704();
        int day = test20230704.infectionTerminated(n,k,p);
        int minDay = test20230704.minOverLoad(n, k);
        System.out.println(day);
        System.out.println(minDay);

        List<String> wholeComb = test20230704.getWholeComb("xyzw");
        System.out.println(wholeComb.toString());
    }

    /**
     * 1 一个小区里有n个居民，第一天有k个传染病感染者，感染者需要转运到医院隔离和治疗，该小区第一天的转运感染者的能力是p个人，第二天转运能力是p-1人，第三天转运能力是p-2人，以此类推。
     * 如果感染者当天没有转运出小区，则每一个感染者会在当天午夜12点感染1个人。请问这个小区需要多少天感染者能清零。
     * 要求：
     * (1) 命名一个合适的函数名称，实现完整的函数
     * (2) 按照你平时的编程习惯，在你认为需要注释处写上相应的注释
     * (3) 代码行数尽可能少，代码运行复杂度尽可能小
     * (4) 写出你实现代码的算法复杂度o(n)
     * 给两组数让候选人跑一下代码给结果：
     *
     */
    public int infectionTerminated(int n, int k, int p){
        int day=0;
        while (k>0){
            n-=p;
            k-=p;
            p--;
            if(k>0){
                k = Math.min(n, 2 * k);
            }
            if(p==0){
                return -1;
            }
            day++;
        }
        return day;
    }

    /**
     * 2 接上一题，如果要确保最后小区能清零，即在转运能力减到0之前，所有感染者都能被转运出去，p的最小值是多少。即基于小区居民n，第一天感染人数k，求出p的最小值。用Java/JS/TS/C++语言实现求p最小值的函数。
     * 要求：
     * (1) 命名一个合适的函数名称，实现完整的函数
     * (2) 按照你平时的编程习惯，在你认为需要注释处写上相应的注释
     */
    public int minOverLoad(int n, int k){
        //二分搜索法 p的取值1<p<k;
        int l=1;
        int r=k;
        while (l<r){
            int mid=(l+r)/2;
            int p = infectionTerminated(n,k,mid);
            if(p==-1){
                l=mid+1;
            }else {
                r=mid;
            }
        }
        return l;
    }

    /**
     * 3 输入一个没有重复字符的字符串，打印出该字符串中所有字符的排列。如输入abc，则打印出a、b、c所能排列出来的所有字符串abc, acb, bac, bca, cab, cba。用Java/JS/TS/C++语言写一个函数实现。
     * 要求：
     * (1)命名一个合适的函数名称，实现完整的函数
     * (2)仅用一个函数实现，不要出现调用子函数f
     * (3) 按照你平时的编程习惯，在你认为需要注释处写上相应的注释
     */
    public List<String> getWholeComb(String s){
        char[] chars = s.toCharArray();
        List<String> res = new ArrayList<>();

        getArrange(res,chars,new ArrayList<>());
        return res;
    }

    private void getArrange(List<String> res, char[] chars, List<Character> s) {
        if(chars.length==s.size()){
            StringBuilder builder = new StringBuilder();
            for (Character s0:s){
                builder.append(s0);
            }
            res.add(builder.toString());
        }
        for(char c:chars){
            if(s.contains(c)){
                continue;
            }
            List<Character> list2 = new ArrayList<>(s);
            list2.add(c);
            getArrange(res,chars,list2);
        }
    }




}

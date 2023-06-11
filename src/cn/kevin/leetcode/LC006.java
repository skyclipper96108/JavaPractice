package cn.kevin.leetcode;

import java.util.*;
import java.util.stream.IntStream;

/**
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 */
public class LC006 {

    public String convert(String s, int numRows) {
        if(numRows<2){
            //行数小于2直接返回
            return s;
        }
        List<StringBuilder> list = new ArrayList<>();
        for(int i=0; i<numRows; i++){
            list.add(new StringBuilder());
        }
        //定义行索引
        int i = 0; int flag=-1;
        for(char c: s.toCharArray()){
            //数组不会越界
            list.get(i).append(c);
            //方向初始为向下，一开始或者到达行尾反向
            if(i==0||i==numRows-1){
                flag=-flag;
            }
            i+=flag;
        }
        StringBuilder res = new StringBuilder();
        for(StringBuilder l:list){
            res.append(l.toString());
        }
        return res.toString();
    }


    public static int luckyNumber(int n) {
        int x = n/100000;
        n=n-x*100000;
        int y = n/10000;
        n=n-y*10000;
        int z = n/1000;
        n=n-z*1000;


        while(n<=999){
            int k = n;
            int a =k/100;
            k=k-a*100;
            int b = k/10;
            k=k-b*10;
            int c = k;
            if(x+y+z==a+b+c){
                return x*100000+y*10000+z*1000+n;
            }
            n++;
        }
        int a=9;
        int b=9;
        int c=9;
        if(x+y+z+1>18){
            a = x+y+1-18;
        }else if(x+y+z+1>9){
            a=0;
            b=x+y+1-9;
        }else {
            a=0;
            b=0;
            c=x+y+z+1;
        }
        return x*100000+y*10000+(z+1)*1000+a*100+b*10+c;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String scan = scanner.nextLine();
        String[] s = scan.split(" ");
        int s1 = Integer.parseInt(s[0]);
        int n = Integer.parseInt(s[1]);
        Map<String, Integer> map = new HashMap<>();
        boolean flag =true;
        for(int i=0;i<s1;i++){
            String k = scanner.nextLine();
            String[] k1 = k.split(" ");
            for(int j=1;j<k1.length;j++){
                int num = 0;
                if(map.containsKey(k1[j])){
                    num=map.get(k1[j])+1;
                }
                if(num==n){
                    System.out.println(k1[j]);
                    flag =false;
                }
                map.put(k1[j],num);
            }
        }
        if (flag){
            System.out.println(0);
        }

    }

    public static void luckyNumber(String n) {

        
    }




}

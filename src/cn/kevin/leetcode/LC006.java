package cn.kevin.leetcode;

import java.util.ArrayList;
import java.util.List;
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
}

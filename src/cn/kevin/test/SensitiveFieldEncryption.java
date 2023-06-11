package cn.kevin.test;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.StringJoiner;
import java.util.stream.Collectors;

/**
 * 题目描述
 * 给定一个由多个命令字组成的命令字符串:1、字符串长度小于等于127字节，只包含大小写字母，数字下划线和偶数个双引号;
 * 2、命令字之间以一个或多个下划线_进行分割;
 * 3、可以通过两个双引号””来标识包含下划线_的命令字或空命令字(仅包含两个双引号的命令字) ，双引号不会在命令字内部出现;
 * 请对指定索引的敏感字段进行加密，替换为****** (6个*)并删除命令字前后多余的下划线如果无法找到指定索引的命令字，输出字符串ERROR。
 * 输入描述
 * 输入为两行，第一行为命令字索引K (从0开始)，第二行为命令字符串S。
 * 输出描述
 * 输出处理后的命令字符串，如果无法找到指定索引的命令字输出字符串ERROR
 */
public class SensitiveFieldEncryption {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        String s = sc.nextLine();
        System.out.println(getResult(k,s));
    }

    public static String getResult(int k, String s) {
        StringBuilder stack = new StringBuilder();
        LinkedList<String> result = new LinkedList<>();
        for (int i = 0; i< s.length(); i++) {
            char c = s.charAt(i);
            if (c == '_'&& (stack.length() == 0|| stack.charAt(stack.length()-1)!='"')){
                result.add(stack.toString());
                stack = new StringBuilder();
            }else if (c == '"' && stack.length() != 0) {
                stack.append('"');
                result.add(stack.toString());
                stack = new StringBuilder();
            } else {
                stack.append(c);
            }
        }
        if (stack.length() > 0) {
            result.add(stack.toString());
        }

        List<String> ans = result.stream().filter(str -> !"".equals(str)).collect(Collectors.toList());
        if (k > ans.size() - 1) {
            return "ERROR";
        }
        ans.set(k,"******");
        StringJoiner sj = new StringJoiner("");
        for (String an : ans) {
            sj.add(an);
        }
        return sj.toString();
    }
}

package cn.kevin.test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;



/**
 * 题目描述
 * 有一个考古学家发现一个石碑，但是很可惜，发现时其已经断成多殴，原地发现n个断口整齐的石碑碎片。为了破解石碑内容，希望有程序能帮忙计算复原后的石碑文字 组合数Q，你能帮忙吗?
 * 输入描述
 * 第一行输入n，n表示石碑碎片的个数
 * 第二行依次输入石碑碎片上的文字内容S，共有n组
 * 输出描述
 * 输出石碑文字的组合《(按照 升序排列Q)，行末无多余空格。
 */
public class Archaeology {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] arr = new String[n];
        for (int i=0;i<n;i++){
            arr[i]= scanner.next();
        }
        Arrays.sort(arr);
        HashSet<String> set = new HashSet<>();
        dfs(arr,n,new boolean[n],new LinkedList<>(),set);
    }

    private static void dfs(String[] arr, int n, boolean[] used, LinkedList<String>path, HashSet<String> set) {
        if(path.size()==n){
            StringBuilder sb = new StringBuilder();
            for(String node:path){
                sb.append(node);
            }
            String ans = sb.toString();
            if(!set.contains(ans)){
                System.out.println(ans);
                set.add(ans);
            }
            return;
        }
        for (int i=0;i<n;i++){
            if(i>0&&arr[i].equals(arr[i-1])&&!used[i-1])continue;
            if(!used[i]){
                path.addLast(arr[i]);
                used[i]=true;
                dfs(arr,n,used,path,set);
                used[i]=false;
                path.removeLast();
            }
        }
    }

}

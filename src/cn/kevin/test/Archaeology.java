package cn.kevin.test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;



/**
 * ��Ŀ����
 * ��һ������ѧ�ҷ���һ��ʯ�������Ǻܿ�ϧ������ʱ���Ѿ��ϳɶ�Ź��ԭ�ط���n���Ͽ������ʯ����Ƭ��Ϊ���ƽ�ʯ�����ݣ�ϣ���г����ܰ�æ���㸴ԭ���ʯ������ �����Q�����ܰ�æ��?
 * ��������
 * ��һ������n��n��ʾʯ����Ƭ�ĸ���
 * �ڶ�����������ʯ����Ƭ�ϵ���������S������n��
 * �������
 * ���ʯ�����ֵ���ϡ�(���� ��������Q)����ĩ�޶���ո�
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

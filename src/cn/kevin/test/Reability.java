package cn.kevin.test;

import java.util.Arrays;
import java.util.Scanner;

//组装最大可靠性设备
public class Reability {

    public static int res =-1;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int money = sc.nextInt();
        int type = sc.nextInt();
        int n = sc.nextInt();
        int[][] suit = new int[n][3];
        for (int i = 0; i < n; i++) {
            suit[i][0]= sc.nextInt();
            suit[i][1]= sc.nextInt();
            suit[i][2]= sc.nextInt();
        }
        int[] ty = new int[type];
        for(int i=0;i<type;i++){
            ty[i]=-999;
        }
        getComponent(money,type, ty, n, suit);
        System.out.println(res);
    }


    private static void getComponent(int money,int type, int[] ty,int n, int[][] suit) {
        if(money<0){
            return;
        }
        if(type==0){
            Arrays.sort(ty);
            res = Math.max(ty[0],res);
            return;
        }
        for(int i=0;i<n;i++){
            int [] comp = suit[i];
            int num = comp[0];
            if(ty[num]!=-999){
                continue;
            }
            ty[num]=comp[1];
            getComponent(money-comp[2], type-1, ty, n, suit);
            ty[num]=-999;
        }
    }
}

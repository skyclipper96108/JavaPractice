package cn.kevin.test;

import java.util.Arrays;
import java.util.Scanner;

public class SunBench {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer[] arr = Arrays.stream(sc.next().split(",")).map(Integer::parseInt).toArray(Integer[]::new);
        System.out.println(getArea(arr));
    }

    private static int getArea(Integer[] arr) {
        int i = 0;
        int j = arr.length-i;
        int res = 0;
        while (i<j){
            int a = j-i;
            if(arr[i]>arr[j]){
                res = Math.max(res,a*arr[j]);
                j--;
            }else {
                res = Math.max(res,a*arr[i]);
                i++;
            }
        }
        return res;
    }
}

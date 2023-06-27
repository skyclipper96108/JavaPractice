package cn.kevin.leetcode;

public class LC2485 {
    public int pivotInteger(int n) {
        int left = 1;
        int right = n;
        while (left<=right) {
            int middle = (left + right) / 2;
            if((1+middle)*middle/2==(middle+n)*(n-middle+1)/2){
                return middle;
            }else if((1+middle)*middle/2>(middle+n)*(n-middle+1)/2){
                right = middle-1;
            }else if((1+middle)*middle/2<(middle+n)*(n-middle+1)/2){
                left=middle+1;
            }
        }
        return -1;
    }



}

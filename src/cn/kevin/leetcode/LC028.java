package cn.kevin.leetcode;

/**
 * ���������ַ���?haystack �� needle �������� haystack �ַ������ҳ� needle �ַ����ĵ�һ��ƥ������±꣨�±�� 0 ��ʼ�������?needle ���� haystack ��һ���֣��򷵻�? -1 ��
 */
public class LC028 {
    public int strStr(String haystack, String needle) {
        int i = haystack.length();
        int j = needle.length();
        if(i<j){
            return -1;
        }
        for(int k=0;k<i-j+1;k++){
            if(needle.equals(haystack.substring(k,k+j))){
                return k;
            }
        }
        return -1;
    }

    public int divide(int dividend, int divisor) {
        boolean flag = false;
        if(dividend<0){
            if(dividend==Integer.MIN_VALUE){
                dividend=Integer.MAX_VALUE;
            }else{
                dividend=-dividend;
            }
            flag =!flag;
        }
        if(divisor<0){
            if(divisor==Integer.MIN_VALUE){
                divisor=Integer.MAX_VALUE;
            }else{
                divisor=-divisor;
            }
            flag =!flag;
        }
        int res = 0;
        while(dividend>=divisor){
            dividend-=divisor;
            res++;
        }
        if(flag){
            res=-res;
        }
        return res;
    }
}

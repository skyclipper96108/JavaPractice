package cn.kevin.leetcode;


/**
 * ����һ������ x ����� x ��һ���������������� true �����򣬷��� false ��
 *
 * ��������ָ���򣨴������ң��͵��򣨴������󣩶�����һ����������
 */
public class LC009 {
    public boolean isPalindrome2(int x) {
        if(x<0){
            return false;
        }
        int p = x;
        int res = 0;
        while (x!=0){
            int tmp = x%10;
            res=10*res+tmp;
            x/=10;
        }
        return res==p;
    }

    public boolean isPalindrome(String s) {
        String str = s.replaceAll("[^a-zA-Z0-9]", "");
        int n = str.length();
        int l = 0, r=n-1;
        while(l<r){
            if(Character.toLowerCase(str.charAt(l))!=Character.toLowerCase(str.charAt(r))){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}

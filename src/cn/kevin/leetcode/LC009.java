package cn.kevin.leetcode;


/**
 * ����һ������ x ����� x ��һ���������������� true �����򣬷��� false ��
 *
 * ��������ָ���򣨴������ң��͵��򣨴������󣩶�����һ����������
 */
public class LC009 {
    public boolean isPalindrome(int x) {
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
}

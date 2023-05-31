package cn.kevin.leetcode;


/**
 * ����һ�� 32 λ���з������� x �����ؽ� x �е����ֲ��ַ�ת��Ľ����
 *
 * �����ת���������� 32 λ���з��������ķ�Χ?[?231,? 231?? 1] ���ͷ��� 0��
 *
 * ���軷��������洢 64 λ�������з��Ż��޷��ţ���
 *
 */
public class LC007 {
    public int reverse(int x) {
        int res = 0;
        while (x!=0){
            int tmp = x%10;
            //������xΪ11λ�������λֻ����Ϊ1����2
            //�������ֵ2147483648 ��Сֵ-2147483647
            if(res>Integer.MAX_VALUE/10 || res<Integer.MIN_VALUE/10){
                return 0;
            }
            res=res*10+tmp;
            x/=10;
        }
        return res;
    }
}

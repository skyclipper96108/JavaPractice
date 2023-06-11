package cn.kevin.test;


import java.util.Arrays;
import java.util.Scanner;

/**
 * ��Ŀ����
 * ��ְ�󣬵�ʦ������Է�����ѡ���˻����
 * �������ڲ�ͬʱ���ºܶ��
 * ��ͬʳ��Ҫ��ͬ��ʱ�ʣ����ܱ�øպú�����ϣ�˳Ե����ĸպú��ʵĲˣ�������ֵϲ����죬�ö������ֵϣ�ÿ�������̲˺�����Ҫ��m���������(ÿ��ֻ����һ��)��ô�������Ĳ��ԣ�����ܳԵ����ٸպú��ʵĲ�?
 * ��������
 * ��һ����������n��m������n�����������µĲ˵ĸ�����m�������١� (1 n,m<1000)��������n�У�ÿ����������x��y�����x���µĲ˹�y����ܱ�øպú��ʡ� (1x,y < 1000)
 * �������
 * ���һ�����������������Ĳ��ԣ�����ܳԵ��պú��ʵĲ˵�����.
 */
public class Hotpot {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] suit = new int[n];
        for (int i = 0; i < n; i++) {
            suit[i] = sc.nextInt() + sc.nextInt();
        }
        System.out.println(getFood(n, m, suit));
    }

    private static int getFood(int n, int m, int[] suit) {
        Arrays.sort(suit);

        int count = 1;
        int pre = 0;
        for(int i=1;i<suit.length;i++){
            if(suit[i]>=suit[pre]+m){
                count++;
                //��Ҫ���κ��ʵĲˣ������Ҫ���ϴ��ղ˵�ʱ�����ڵ���m��ע��������suit[pre] + m ��������suit[i-1] +m
                pre=i;
                //����������˲ˣ�����»��汾���̲˵�ʱ���
            }
        }
        return count;
    }

}

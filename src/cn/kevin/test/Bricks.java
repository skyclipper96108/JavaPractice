package cn.kevin.test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * ��Ŀ����
 * Soloֻ��koko�����ֵܣ������������һ��ѻ�ľ��ÿ���ľ�϶����Լ�������������������Ҫ����Щ��ľ�ֳ����ѡ����Solo������䣬�ܵ�kokoҪ�������˻�õĻ�ľ����������ȡ�(����Koko���߼�)���������Բ�ͬ����Ȼ�ͻ�ޣ�kokoֻ���Ƚ�������ת�ɶ������ٽ��мӷ��������ܻ����ǽ�λ(ÿ����λ������)���統25 (11101) ��11 (01011) ʱ��k�õ��ļ�������18 (10010):
 * 11001
 * +01011
 * 10010
 * Solo��Ҫ������ʹ�Լ��õ��Ļ�ľ����������Ҳ���koko��
 * ��������
 * ��һ����һ������N(2��N��100)����ʾ�ж��ٿ��ľ:
 * �ڶ���Ϊ�ո�ֿ���N������Ci(1sCis106)����ʾ��i���ľ��������
 * �������
 * �������koko���ޣ����Solo���ܻ�û�ľ�����������; ���������NO��
 */
public class Bricks {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) weights[i] = sc.nextInt();
        System.out.println(getMaxWeight(n, weights));
    }

    private static String getMaxWeight(int n, int[] weights) {
        // ����
        Arrays.sort(weights);
        int min = weights[0];
        // correctSum��¼solo �����������������
        int correctSum = min;
        // faultSum ��Koko�ƵĴ����������
        int faultSum = min;
        for (int i = 1; i < weights.length; i++) {
            correctSum += weights[i];
            //koko�����߼�
            faultSum^=weights[i];
        }
        //�������Koko���㷽��������У����ƽ�֣���Ȼ��������ĸ��ͬ�Ķ�����������������ͬ������������λ���Ľ����Ȼ��0
        if(faultSum==0){
            //faultSum-0��ʾ����ƽ�֣���������ȥһ���������ؿ��Եõ�������ͬ�Ķ�����������˾ͼ�ȥչС�ģ�����SoLo�Ϳ�����������
            return correctSum-min+"";
        }else {
            //faultsum != 0 ��ʾ�޷�����Koko����Ȥƽ��
            return "NO";
        }
    }
}

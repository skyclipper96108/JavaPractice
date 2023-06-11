package cn.kevin.test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * ����һ������IPv4��ַQ����4С����ɣ�ÿ�ڵķ�ΧΪ0-255����#�ż��������IPV4��ַ����ת��Ϊһ��32λ������������:��128#0#255#255��ת��Ϊ32λ�����Ľ��Ϊ2147549183( 0x8000FFFF)
 * ��1#0#0#0��ת��Ϊ32λ�����Ľ��Ϊ16777216 ( 0x01000000 )
 * �����ַ�����ʽ����һ������IPv4��ַ�����Ƶ�1С�ڵķ�ΧΪ1~128����ÿһ�ڷ����ֱ�Ϊ(1~128)0-255)0-255)#(0-255),Ҫ���IPv4��ַֻ�ܶ�Ӧ��Ψһ�������ϡ�
 * ����ǷǷ�IPv4Q����invalid IP
 * ��������
 * ����һ�У�����IPV4��ַ��ʽ�ַ���
 * �������
 * ���һ�У�����Ҫ��������ͻ����ض��ַ�
 * ��ע
 * ���벻��ȷ���ǺϷ���IPV4��ַ����Ҫ�ԷǷ�IPV4( �մ�������1��ַ�в����ڵ��ַ����ǺϷ���#��ʮ���ƣ�ʮ�����������ںϷ�������)����ʶ�𣬷����ض�����
 */
public class DummyIPV4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(getResult(sc.nextLine()));
    }
    public static String getResult(String s) {
        try {
            Integer[] ip = Arrays.stream(s.split("#")).map(Integer::parseInt).toArray(Integer[]::new);
            if (ip.length != 4) {
                return "invalid Ip"; // ip��ɲ��ָ������㣬����"invalid Ip'
            }
            int p1 = ip[0], p2 = ip[1], p3 = ip[2], p4 = ip[3];
            if (p1 >= 1 && p1 <= 128 && p2 >= 0 && p2 < 255 && p3 >= 0 && p3 <= 255 && p4 >= 0 && p4 <= 255) {
                String tmp = getHexString(p1) + getHexString(p2) + getHexString(p3) + getHexString(p4);
                return Long.parseLong(tmp, 16) + "";
            } else {
                return "invalid Ip"; // ip����ɲ���ȡֵ�������ԣ�"invalid Ip"
            }
        } catch (Exception e) {

            return "invalid IP"; // ���ڷǷ��ַ�ʱ������parseInt�ᱨ�������쳣�󣬷���"invalid IP'
        }


    }
    private static String getHexString(int num) {
        String tmp = Integer.toHexString(num);
        if(tmp.length()<2){
            tmp="0"+tmp;
        }
        return tmp;
    }

}




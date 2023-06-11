package cn.kevin.test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 存在一种虚拟IPv4地址Q，由4小节组成，每节的范围为0-255，以#号间隔，虚拟IPV4地址可以转换为一个32位的整数，例如:。128#0#255#255，转换为32位整数的结果为2147549183( 0x8000FFFF)
 * 。1#0#0#0，转换为32位整数的结果为16777216 ( 0x01000000 )
 * 现以字符串形式给出一个虚拟IPv4地址，限制第1小节的范围为1~128，即每一节范国分别为(1~128)0-255)0-255)#(0-255),要求个IPv4地址只能对应到唯一的整数上。
 * 如果是非法IPv4Q，返invalid IP
 * 输入描述
 * 输入一行，虚拟IPV4地址格式字符串
 * 输出描述
 * 输出一行，按照要求输出整型或者特定字符
 * 备注
 * 输入不能确保是合法的IPV4地址，需要对非法IPV4( 空串，含有1地址中不存在的字符，非合法的#分十进制，十进制整数不在合法区间内)进行识别，返回特定错误
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
                return "invalid Ip"; // ip组成部分个数不足，返回"invalid Ip'
            }
            int p1 = ip[0], p2 = ip[1], p3 = ip[2], p4 = ip[3];
            if (p1 >= 1 && p1 <= 128 && p2 >= 0 && p2 < 255 && p3 >= 0 && p3 <= 255 && p4 >= 0 && p4 <= 255) {
                String tmp = getHexString(p1) + getHexString(p2) + getHexString(p3) + getHexString(p4);
                return Long.parseLong(tmp, 16) + "";
            } else {
                return "invalid Ip"; // ip各组成部分取值范国不对，"invalid Ip"
            }
        } catch (Exception e) {

            return "invalid IP"; // 存在非法字符时，这里parseInt会报错，捕获异常后，返回"invalid IP'
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




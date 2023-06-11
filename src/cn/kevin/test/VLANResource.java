package cn.kevin.test;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringJoiner;
import java.util.stream.Collectors;

/**
 * 题目描述
 * VLAN是一种对局域网设备进行逻辑划分的技术，为了标识不同的VLAN，引入VLAN ID(1-4094之间的整数)的概念.定义一个VLAN ID的资源池(下称VLAN资源池)，资中连续的LAN用开始VLAN-结束VLAN表示，不连续的用单个整数表示，所有的VLAN用英文逗号连接起来。
 * 现在有一个VLAN资源池，业务需要从资源池中申请一个VLAN，要你输出从VLAN资源池中移除申请的VLAN后的资源池。
 * 输入描述
 * 第一行为字符串格式的VLAN资源池，第二行为业务要申请的VLAN，VLAN的取值范围为[1,4094]之间的整数
 * 输出描述
 * 从输入VLAN资源池中移除申请的VLAN后字符电格式的VLAN资源池，输出要求满足题目描述中的格式，并且按照LAN从小到大升序输出
 * 如果申请的VLAN不在原VLAN资源池内，输出原VLAN资源池升序排序后的字特串即可.
 * 备注
 * 输入VLAN资源池中VLAN的数量取值范围为[2-4094)间的整数，资池中VLAN不亚复且合法(14094]之间的整数)，输入是乱序的.
 */
public class VLANResource {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] vlanarr = sc.nextLine().split(",");

        int remove = sc.nextInt();
        System.out.println(handleArr(vlanarr,remove));

    }

    private static String handleArr(String[] vlanarr, int remove) {
        LinkedList<Integer[]> vlanList = Arrays.stream(vlanarr).
                map(v->Arrays.stream(v.split("-")).map(Integer::parseInt).toArray(Integer[]::new))
                .sorted((a,b)->a[0]-b[0]).collect(Collectors.toCollection(LinkedList::new));

        for(int i=0;i<vlanList.size();i++){
            Integer[] vlan = vlanList.get(i);
            int front =vlan[0];
            if(vlan.length>1){
                int to = vlan[1];
                if(remove<front||remove>to){
                    continue;
                }
                vlanList.remove(i);

                if(remove==front){
                    vlanList.add(i,generateRange(remove+1,to));
                } else if (remove==to) {
                    vlanList.add(i,generateRange(front,remove-1));
                }else {
                    vlanList.add(i,generateRange(remove+1,to));
                    vlanList.add(i,generateRange(front,remove-1));
                }
                break;
            }else if(front==remove){
                vlanList.remove(i);
                break;
            }
        }
        StringJoiner ans = new StringJoiner(",");

        vlanList.stream().map(
                vlan->{
                    StringJoiner sj = new StringJoiner("-");
                    for(Integer v:vlan){
                        sj.add(v+"");
                    }
                    return sj.toString();
                })
                .forEach(ans::add);
        return ans.toString();
    }

    private static Integer[] generateRange(int from, int to) {
        if(from<to){
            return new Integer[]{from,to};
        }else {
            return new Integer[]{from};
        }
    }
}

package cn.kevin.test;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringJoiner;
import java.util.stream.Collectors;

/**
 * ��Ŀ����
 * VLAN��һ�ֶԾ������豸�����߼����ֵļ�����Ϊ�˱�ʶ��ͬ��VLAN������VLAN ID(1-4094֮�������)�ĸ���.����һ��VLAN ID����Դ��(�³�VLAN��Դ��)������������LAN�ÿ�ʼVLAN-����VLAN��ʾ�����������õ���������ʾ�����е�VLAN��Ӣ�Ķ�������������
 * ������һ��VLAN��Դ�أ�ҵ����Ҫ����Դ��������һ��VLAN��Ҫ�������VLAN��Դ�����Ƴ������VLAN�����Դ�ء�
 * ��������
 * ��һ��Ϊ�ַ�����ʽ��VLAN��Դ�أ��ڶ���Ϊҵ��Ҫ�����VLAN��VLAN��ȡֵ��ΧΪ[1,4094]֮�������
 * �������
 * ������VLAN��Դ�����Ƴ������VLAN���ַ����ʽ��VLAN��Դ�أ����Ҫ��������Ŀ�����еĸ�ʽ�����Ұ���LAN��С�����������
 * ��������VLAN����ԭVLAN��Դ���ڣ����ԭVLAN��Դ���������������ش�����.
 * ��ע
 * ����VLAN��Դ����VLAN������ȡֵ��ΧΪ[2-4094)����������ʳ���VLAN���Ǹ��ҺϷ�(14094]֮�������)�������������.
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

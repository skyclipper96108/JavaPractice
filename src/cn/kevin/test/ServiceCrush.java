package cn.kevin.test;


import java.util.*;

/**
 * 题目描述
 * 某系统中有众多服务，每个服务用字符串(只包含字母和数字，长度<=10)唯一标识，服务间可能有依赖关系，如A依赖B，则当B故障时导致A也故障
 * 依赖具有传递性，如A依赖B，B依赖C，当C故障时导致B故障，也导致A故障。
 * 给出所有依赖关系，以及当前已知故障服务，要求输出所有正常服务。
 * 依赖关系: 服务1-服务2 表示“服务1”依赖”服务2”
 * 不必考虑输入异常，用例保证:依赖关系列表、故障列表非空，且依赖关系数，故障服务数都不会超过3000，服务标识格式正常。
 * 输入描述
 * 半角逗号分隔的依赖关系列表 (换行)
 * 半角逗号分隔的故障服务列表
 * 输出描述依赖关系列表中提及的所有服务中可以正常工作的服务列表，用半角逗号分隔，按依赖关系列表中出现的次序排序。特别的，没有正常节点输出单独一个半角逗号。
 */
public class ServiceCrush {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[][] relations = Arrays.stream(sc.nextLine().split(",")).map(s->s.split("-")).toArray(String[][]::new);
        String[] breakdowns = sc.nextLine().split(",");
        System.out.println(getWorkSerive(relations,breakdowns));
    }

    private static String getWorkSerive(String[][] relations, String[] breakdowns) {
        HashMap<String,HashSet<String>> next = new HashMap<>(); // 是服务，属性值是子服务合
        HashMap<String,Integer> first = new HashMap<>(); // 服务第一次出现的位营
        int i = 0;
        for (String[] relation : relations) {
            String c = relation[0];
            String f = relation[1];
            next.putIfAbsent(c, new HashSet<>());
            next.putIfAbsent(f,new HashSet <>());
            next.get(f).add(c);
            first.putIfAbsent(c, i++);
            first.putIfAbsent(f, i++);
        }
        for (String s : breakdowns) {
            remove(next,s);
        }
        String[] ans = next.keySet().toArray(new String[0]);
        if (ans .length == 0)
            return",";
        Arrays.sort(ans, Comparator.comparingInt(first::get));
        StringJoiner sj = new StringJoiner(",");
        for (String an : ans) sj.add(an);
        return sj.toString();
    }
    // 由于服务5是故障服务，因此s服务本身，和其所有子孙服务韶无法运行
    private static void remove(HashMap<String, HashSet<String>> next, String s) {
        if (next.containsKey(s)) {
            HashSet<String> need_remove = next.get(s);
            next .remove(s);
            for(String ss : need_remove) {
                remove(next,ss);
            }
        }


    }

}

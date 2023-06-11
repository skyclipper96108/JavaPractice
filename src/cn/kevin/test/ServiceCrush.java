package cn.kevin.test;


import java.util.*;

/**
 * ��Ŀ����
 * ĳϵͳ�����ڶ����ÿ���������ַ���(ֻ������ĸ�����֣�����<=10)Ψһ��ʶ������������������ϵ����A����B����B����ʱ����AҲ����
 * �������д����ԣ���A����B��B����C����C����ʱ����B���ϣ�Ҳ����A���ϡ�
 * ��������������ϵ���Լ���ǰ��֪���Ϸ���Ҫ�����������������
 * ������ϵ: ����1-����2 ��ʾ������1������������2��
 * ���ؿ��������쳣��������֤:������ϵ�б������б�ǿգ���������ϵ�������Ϸ����������ᳬ��3000�������ʶ��ʽ������
 * ��������
 * ��Ƕ��ŷָ���������ϵ�б� (����)
 * ��Ƕ��ŷָ��Ĺ��Ϸ����б�
 * �������������ϵ�б����ἰ�����з����п������������ķ����б��ð�Ƕ��ŷָ�����������ϵ�б��г��ֵĴ��������ر�ģ�û�������ڵ��������һ����Ƕ��š�
 */
public class ServiceCrush {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[][] relations = Arrays.stream(sc.nextLine().split(",")).map(s->s.split("-")).toArray(String[][]::new);
        String[] breakdowns = sc.nextLine().split(",");
        System.out.println(getWorkSerive(relations,breakdowns));
    }

    private static String getWorkSerive(String[][] relations, String[] breakdowns) {
        HashMap<String,HashSet<String>> next = new HashMap<>(); // �Ƿ�������ֵ���ӷ����
        HashMap<String,Integer> first = new HashMap<>(); // �����һ�γ��ֵ�λӪ
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
    // ���ڷ���5�ǹ��Ϸ������s������������������������޷�����
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

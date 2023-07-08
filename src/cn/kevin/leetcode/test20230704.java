package cn.kevin.leetcode;

import java.util.ArrayList;
import java.util.List;

public class test20230704 {



    public static void main(String[] args) {

        int n = 500;
        int k = 30;
        int p = 16;
        test20230704 test20230704 = new test20230704();
        int day = test20230704.infectionTerminated(n,k,p);
        int minDay = test20230704.minOverLoad(n, k);
        System.out.println(day);
        System.out.println(minDay);

        List<String> wholeComb = test20230704.getWholeComb("xyzw");
        System.out.println(wholeComb.toString());
    }

    /**
     * 1 һ��С������n�����񣬵�һ����k����Ⱦ����Ⱦ�ߣ���Ⱦ����Ҫת�˵�ҽԺ��������ƣ���С����һ���ת�˸�Ⱦ�ߵ�������p���ˣ��ڶ���ת��������p-1�ˣ�������ת��������p-2�ˣ��Դ����ơ�
     * �����Ⱦ�ߵ���û��ת�˳�С������ÿһ����Ⱦ�߻��ڵ�����ҹ12���Ⱦ1���ˡ��������С����Ҫ�������Ⱦ�������㡣
     * Ҫ��
     * (1) ����һ�����ʵĺ������ƣ�ʵ�������ĺ���
     * (2) ������ƽʱ�ı��ϰ�ߣ�������Ϊ��Ҫע�ʹ�д����Ӧ��ע��
     * (3) ���������������٣��������и��ӶȾ�����С
     * (4) д����ʵ�ִ�����㷨���Ӷ�o(n)
     * ���������ú�ѡ����һ�´���������
     *
     */
    public int infectionTerminated(int n, int k, int p){
        int day=0;
        while (k>0){
            n-=p;
            k-=p;
            p--;
            if(k>0){
                k = Math.min(n, 2 * k);
            }
            if(p==0){
                return -1;
            }
            day++;
        }
        return day;
    }

    /**
     * 2 ����һ�⣬���Ҫȷ�����С�������㣬����ת����������0֮ǰ�����и�Ⱦ�߶��ܱ�ת�˳�ȥ��p����Сֵ�Ƕ��١�������С������n����һ���Ⱦ����k�����p����Сֵ����Java/JS/TS/C++����ʵ����p��Сֵ�ĺ�����
     * Ҫ��
     * (1) ����һ�����ʵĺ������ƣ�ʵ�������ĺ���
     * (2) ������ƽʱ�ı��ϰ�ߣ�������Ϊ��Ҫע�ʹ�д����Ӧ��ע��
     */
    public int minOverLoad(int n, int k){
        //���������� p��ȡֵ1<p<k;
        int l=1;
        int r=k;
        while (l<r){
            int mid=(l+r)/2;
            int p = infectionTerminated(n,k,mid);
            if(p==-1){
                l=mid+1;
            }else {
                r=mid;
            }
        }
        return l;
    }

    /**
     * 3 ����һ��û���ظ��ַ����ַ�������ӡ�����ַ����������ַ������С�������abc�����ӡ��a��b��c�������г����������ַ���abc, acb, bac, bca, cab, cba����Java/JS/TS/C++����дһ������ʵ�֡�
     * Ҫ��
     * (1)����һ�����ʵĺ������ƣ�ʵ�������ĺ���
     * (2)����һ������ʵ�֣���Ҫ���ֵ����Ӻ���f
     * (3) ������ƽʱ�ı��ϰ�ߣ�������Ϊ��Ҫע�ʹ�д����Ӧ��ע��
     */
    public List<String> getWholeComb(String s){
        char[] chars = s.toCharArray();
        List<String> res = new ArrayList<>();

        getArrange(res,chars,new ArrayList<>());
        return res;
    }

    private void getArrange(List<String> res, char[] chars, List<Character> s) {
        if(chars.length==s.size()){
            StringBuilder builder = new StringBuilder();
            for (Character s0:s){
                builder.append(s0);
            }
            res.add(builder.toString());
        }
        for(char c:chars){
            if(s.contains(c)){
                continue;
            }
            List<Character> list2 = new ArrayList<>(s);
            list2.add(c);
            getArrange(res,chars,list2);
        }
    }




}

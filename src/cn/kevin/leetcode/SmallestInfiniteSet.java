package cn.kevin.leetcode;


import java.util.Set;
import java.util.TreeSet;

/**
 * ����һ�����������������ļ��� [1, 2, 3, 4, 5, ...] ��
 *
 * ʵ�� SmallestInfiniteSet �ࣺ
 *
 * SmallestInfiniteSet() ��ʼ�� SmallestInfiniteSet �����԰��� ���� ��������
 * int popSmallest() �Ƴ� �����ظ����޼��е���С������
 * void addBack(int num) ��������� num �� ���������޼��У���һ�� num ��� �������޼��С�
 */
public class SmallestInfiniteSet {

    private int floor;
    private TreeSet<Integer> set;

    public SmallestInfiniteSet() {
        floor = 1;
        set = new TreeSet<>();
    }

    public int popSmallest() {
        if(set.isEmpty()){
            int res = floor;
            floor++;
            return res;
        }
        return set.pollFirst();
    }

    public void addBack(int num) {
        if(num<floor){
            set.add(num);
        }
    }
}

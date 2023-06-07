package cn.kevin.leetcode;

import java.util.PriorityQueue;

/**
 * ����ֻ�����n�鲻ͬ���͵����ң�ÿ�����Ҷ�ֻ�ܱ�����һֻ����Ե���
 *
 * �±�Ϊ i�������ұ��Ե��ĵ÷�Ϊ��
 *
 * �����һֻ����Ե�����÷�Ϊreward1[i]��
 * ����ڶ�ֻ����Ե�����÷�Ϊreward2[i]��
 * ����һ������������reward1��һ������������reward2����һ���Ǹ�����k��
 *
 * ���㷵�ص�һֻ����ǡ�óԵ� k�����ҵ�����£����÷�Ϊ���١�
 */
public class LC2611 {
    public static class Cheese implements Comparable<Cheese>{
        private final int profit;
        private final int id;
        public Cheese(int profit, int id) {
            this.profit = profit;
            this.id = id;
        }
        @Override
        public boolean equals(Object cheese) {
            if(this == cheese)
                return true;
            if(cheese == null)
                return false;
            if(this.getClass()!=cheese.getClass())
                return false;
            Cheese another = (Cheese)cheese;
            return this.profit==another.profit&&this.id==another.id;
        }
        @Override
        public int compareTo(Cheese another) {
            if(this.profit<another.profit)
                return 1;
            else if(this.profit==another.profit)
                return 0;
            return -1;
            // return this.id-another.id;
        }
        @Override
        public String toString() {
            return "cheese [profit=" + profit + ", id=" + id + "]";
        }

    }
    public int miceAndCheese(int[] reward1, int[] reward2, int k) {
        int res = 0;
        int n = reward1.length;
        PriorityQueue<Cheese> priorityQueue = new PriorityQueue<>();
        for(int i=0;i<n;i++){
            Cheese cheese = new Cheese(reward1[i] - reward2[i], i);
            System.out.println(cheese);
            priorityQueue.offer(cheese);
        }
        System.out.println("---------------------");
        for(int i=0;i<k;i++){
            Cheese poll = priorityQueue.poll();
            System.out.println(poll);
            res+=reward1[poll.id];
        }
        while (!priorityQueue.isEmpty()){
            Cheese poll = priorityQueue.poll();
            res+=reward2[poll.id];
        }
        return res;
    }
}

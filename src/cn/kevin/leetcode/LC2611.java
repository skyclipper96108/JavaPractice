package cn.kevin.leetcode;

import java.util.PriorityQueue;

/**
 * 有两只老鼠和n块不同类型的奶酪，每块奶酪都只能被其中一只老鼠吃掉。
 *
 * 下标为 i处的奶酪被吃掉的得分为：
 *
 * 如果第一只老鼠吃掉，则得分为reward1[i]。
 * 如果第二只老鼠吃掉，则得分为reward2[i]。
 * 给你一个正整数数组reward1，一个正整数数组reward2，和一个非负整数k。
 *
 * 请你返回第一只老鼠恰好吃掉 k块奶酪的情况下，最大得分为多少。
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

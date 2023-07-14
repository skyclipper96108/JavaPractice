package cn.kevin.leetcode;


import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * ���� k λ���˼ƻ��� n �����ӴӾɲֿ��ƶ����²ֿ⡣������������ n �� k���Լ�һ����ά�������� time ������Ĵ�СΪ k x 4 ������ time[i] = [leftToRighti, pickOldi, rightToLefti, putNewi] ��
 *
 * һ���ӽ������ֿ�ָ���ֻ��ͨ��һ����ͨ�С��ɲֿ�λ�ںӵ��Ұ����²ֿ��ںӵ��󰶡���ʼʱ������ k λ���˶����ŵ����ȴ���Ϊ���ƶ���Щ���ӣ��� i λ���ˣ��±�� 0 ��ʼ�����ԣ�
 *
 * ���󰶣��²ֿ⣩����ŵ��Ұ����ɲֿ⣩����ʱ leftToRighti ���ӡ�
 * �Ӿɲֿ�ѡ��һ�����ӣ������ص��űߣ���ʱ pickOldi ���ӡ���ͬ���˿���ͬʱ������ѡ�����ӡ�
 * ���Ұ����ɲֿ⣩����ŵ��󰶣��²ֿ⣩����ʱ rightToLefti ���ӡ�
 * �����ӷ����²ֿ⣬�����ص��űߣ���ʱ putNewi ���ӡ���ͬ���˿���ͬʱ������ѡ�����ӡ�
 * �������������һ����������Ϊ���� i �� Ч�ʵ��� ���� j ��
 *
 * leftToRighti + rightToLefti > leftToRightj + rightToLeftj
 * leftToRighti + rightToLefti == leftToRightj + rightToLeftj �� i > j
 * ����ͨ����ʱ��Ҫ��ѭ���¹���
 *
 * ������� x �����ű�ʱ������ y ���ڹ��ţ���ô���� x ��Ҫ���űߵȴ���
 * ���û�����ڹ��ŵĹ��ˣ���ô�����ұߵȴ��Ĺ��˿����ȹ��š����ͬʱ�ж���������ұߵȴ�����ô Ч����� �Ĺ��˻��ȹ��š�
 * ���û�����ڹ��ŵĹ��ˣ������ұ�Ҳû���ڵȴ��Ĺ��ˣ�ͬʱ�ɲֿ⻹ʣ������һ��������Ҫ���ˣ���ʱ������ߵĹ��˿��Թ��š����ͬʱ�ж����������ߵȴ�����ô Ч����� �Ĺ��˻��ȹ��š�
 * ���� n �����Ӷ���Ҫ�����²ֿ⣬���㷵�����һ���������ӵĹ��� ������� ��ʱ�䡣
 *
 */
public class LC2532 {
    public static class Worker {
        public int id;
        public int finishTime;
        public Worker(int id, int finishTime) {
            this.id = id;
            this.finishTime = finishTime;
        }
    }

    public int findCrossingTime(int n, int k, int[][] time) {
        Comparator<Integer> comparator1= (a, b) -> {
            int timeA = time[a][0] + time[a][2];
            int timeB = time[b][0] + time[b][2];
            return timeA != timeB ? timeB - timeA : b - a;
        };
        Comparator<Worker> comparator2= (a, b) -> {
            if(a.finishTime!=b.finishTime){
                return a.finishTime-b.finishTime;
            }else {
                return a.id-b.id;
            }
        };
        int res = 0;//��ǰʱ��ֻΧ�������Ƿ�ռ����ά��
        PriorityQueue<Integer> waitLeft = new PriorityQueue<>(comparator1);
        PriorityQueue<Integer> waitRight = new PriorityQueue<>(comparator1);
        PriorityQueue<Worker> workLeft = new PriorityQueue<>(comparator2);
        PriorityQueue<Worker> workRight = new PriorityQueue<>(comparator2);
        for(int i=0;i<k;i++){
            waitLeft.offer(i);
        }
        while (n>0||!workRight.isEmpty()||!waitRight.isEmpty()){
            //��������������ɵ�worker��������ǳ��ӷ�������Ӧ�ĵȴ�������
            while (!workLeft.isEmpty()&&workLeft.peek().finishTime<=res){
                waitLeft.offer(workLeft.poll().id);
            }
            while (!workRight.isEmpty()&&workRight.peek().finishTime<=res){
                waitRight.offer(workRight.poll().id);
            }
            //�Ҳ๤������
            if(!waitRight.isEmpty()){
                Integer id = waitRight.poll();
                res+=time[id][2];
                workLeft.offer(new Worker(id, res + time[id][3]));
            }else if(n>0&&!waitLeft.isEmpty()){
                Integer id = waitLeft.poll();
                res+=time[id][0];
                workRight.offer(new Worker(id, res + time[id][1]));
                n--;
            }else {
                res++;
            }
        }
        return res;
    }
}

package cn.kevin.test;


import java.util.*;

public class MockQueue {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer[] arr = Arrays.stream(sc.next().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
        int n = sc.nextInt();
        int m = sc.nextInt();
        System.out.println(getResult(arr,n,m));
    }


    public static class Mission {
        private int start;
        private int time;
        public Mission(int start, int time) {
            this.start = start;
            this.time = time;
        }

    }

    private static String getResult(Integer[] arr, int n, int m) {
        int drop = 0;
        int time = 1;
        int wait = 0;
        int[] finish = new int[n];
        Queue<Mission> queue = new LinkedList<>();
        Queue<Mission> waitqueue = new LinkedList<>();
        for(int i=0;i<arr.length;i+=2){
            Mission mission = new Mission(arr[i], arr[i + 1]);
            queue.offer(mission);
        }
        while (!queue.isEmpty()){

            if(queue.peek().start==time){
                Mission poll = queue.poll();
                if(!waitqueue.isEmpty()){
                    waitqueue.offer(poll);
                }
                boolean get = false;
                for(int i=0;i<n;i++){
                    if(finish[i]==0){
                        finish[i]= poll.time+time;
                        get = true;
                    }
                    if(finish[i]>=time){
                        finish[i]= poll.time+time;
                        get = true;
                    }
                }
                if(!get){
                    wait+=1;
                    waitqueue.offer(poll);
                    if(waitqueue.size()>m){
                        waitqueue.poll();
                    }
                }
            }
            time++;
        }
        return null;
    }
}

package Heap;

import java.util.PriorityQueue;

public class connectRopes {

    public static void main(String[] args) {
        int[] len = {1,2,3,4,5};
        System.out.println(minCost(len));
    }

    private static int minCost(int[] arr){

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(int i=0;i<arr.length;i++){
            minHeap.offer(arr[i]);
        }
        int cost = 0;
        while (minHeap.size()>=2){
            int a = minHeap.poll();
            int b = minHeap.poll();
            int ans = a+b;
            cost+=ans;
            minHeap.offer(ans);
        }
        return cost;
    }

}

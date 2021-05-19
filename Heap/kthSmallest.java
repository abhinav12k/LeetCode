package Heap;

import java.util.PriorityQueue;

public class kthSmallest {

    public static void main(String[] args) {

        int[] arr = new int[]{7,10,4,3,20,15};
        System.out.println(getKthSmallest(arr,4));
    }

    private static int getKthSmallest(int[] arr,int k){

        //max heap
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2-o1);

        for(int i=0;i<arr.length;i++){

            pq.offer(arr[i]);
            if(pq.size() > k){
                pq.poll();
            }

            System.out.println(pq);
        }
        return pq.poll();
    }

}

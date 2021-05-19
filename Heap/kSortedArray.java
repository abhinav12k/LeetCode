package Heap;

import java.util.PriorityQueue;

public class kSortedArray {

    public static void main(String[] args) {

        int[] arr = new int[]{6,5,3,2,8,10,9};
        int[] ans = getSorted(arr,3);
        for(int a: ans)
            System.out.println(a);
    }

    private static int[] getSorted(int[] arr,int k){

        //min heap
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int i=0;
        for(i=0;i<arr.length;i++){

            pq.offer(arr[i]);
            if(pq.size()==k+1){
                int val = pq.remove();
                arr[i-k] = val;
            }

        }

        while(!pq.isEmpty()){
            arr[i-k] = pq.poll();
            i++;
        }

        return arr;
    }

}

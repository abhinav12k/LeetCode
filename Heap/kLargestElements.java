package Heap;

import java.util.PriorityQueue;

public class kLargestElements {

    public static void main(String[] args) {
        int[] arr = new int[]{6,5,3,2,8,10,9};
        int[] ans = getkLargestElements(arr,3);
        for(int i: ans)
            System.out.println(i);
    }

    private static int[] getkLargestElements(int[] arr,int k){

        //min Heap
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0;i<arr.length;i++){
            pq.offer(arr[i]);
            if(pq.size()>k){
                pq.poll();
            }
            System.out.println(pq);
        }
        int[] ans = new int[k];
        int i=0;
        while(!pq.isEmpty()){
            ans[i] = pq.poll();
            i++;
        }
        return ans;
    }

}

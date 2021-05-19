package Heap;

import java.util.PriorityQueue;

public class kClosestElement {

    public static void main(String[] args) {
        int[] arr = {5,6,7,8,9,10};
        int[] ans = kClosest(arr,7,3);
        for(int i:ans)
            System.out.println(i);
    }

    private static int[] kClosest(int[] arr,int x,int k){

        int[] ans = new int[k];

        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((o1, o2) -> o2.diff - o1.diff);

        for(int i=0;i<arr.length;i++){
            maxHeap.offer(new Pair(arr[i],Math.abs(arr[i]-x)));
            if(maxHeap.size()>k)
                maxHeap.poll();
        }
        int i=0;
        while (!maxHeap.isEmpty()){
            ans[i] = maxHeap.poll().val;
            i++;
        }
        return ans;
    }

    private static class Pair{
        int val;
        int diff;
        private Pair(int val,int diff){
            this.val = val;
            this.diff = diff;
        }
    }

}

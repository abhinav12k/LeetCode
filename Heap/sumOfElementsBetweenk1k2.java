package Heap;

import java.util.PriorityQueue;

public class sumOfElementsBetweenk1k2 {

    public static void main(String[] args) {

        int[] arr = {1,5,6,50,9,4,65,0};
        System.out.println(findRangeSum(arr,2,5));
    }

    private static int findRangeSum(int[] arr,int k1,int k2){

        int first = kthSmallest(arr,k1);
        int second = kthSmallest(arr,k2);

        int sum=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>first&& arr[i]<second)
                sum+=arr[i];
        }
        return sum;
    }

    private static int kthSmallest(int[] arr,int k){

        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((o1, o2) -> o2-o1);

        for(int a: arr) {
            maxHeap.offer(a);
            if(maxHeap.size()>k)
                maxHeap.poll();
        }
        return maxHeap.poll();
    }
}

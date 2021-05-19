package Heap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class TopKFrequent {
    public static void main(String[] args) {

        int[] arr = {1,5,2,5,3,3,55,5};
        int[] ans = getkMostFrequent(arr,2);
        for(int a:ans)
            System.out.println(a);
    }

    private static int[] getkMostFrequent(int[] arr,int k){
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i:arr)
            map.put(i,map.getOrDefault(i,0)+1);

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(Comparator.comparingInt(map::get));
        for(Integer key: map.keySet()){
            minHeap.offer(key);
            if(minHeap.size()>k)
                minHeap.poll();
        }
        int[] ans = new int[k];
        int i=0;
        while (!minHeap.isEmpty()){
            ans[i] = minHeap.poll();
            i++;
        }
        return ans;
    }
}

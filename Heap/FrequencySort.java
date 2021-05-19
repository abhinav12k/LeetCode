package Heap;

import java.util.HashMap;
import java.util.PriorityQueue;

public class FrequencySort {

    public static void main(String[] args) {
        int[] arr = {1,1,2,1,1,5,2,3,3,3};
        int[] ans = sort(arr);
        for(int a:ans)
            System.out.println(a);
    }

    private static int[] sort(int[] ans){

        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i: ans){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> map.get(o2)-map.get(o1));
        for(Integer key:map.keySet()){
            maxHeap.offer(key);
        }

        int end = 0;
        int filledUpto = 0;
        while (!maxHeap.isEmpty()){
            int val = maxHeap.poll();
            end += map.get(val);
            for(int i=filledUpto;i<end;i++)
                ans[i] = val;
            filledUpto += map.get(val);
        }
        return ans;
    }

}

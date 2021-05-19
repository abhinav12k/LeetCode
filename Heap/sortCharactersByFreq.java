package Heap;

import java.util.HashMap;
import java.util.PriorityQueue;

public class sortCharactersByFreq {

    public static void main(String[] args) {

    }

    private static String sortCharacters(String str){

        HashMap<Character,Integer> map = new HashMap<>();
        for(char c: str.toCharArray())
            map.put(c,map.getOrDefault(c,0)+1);

        PriorityQueue<Character> maxHeap = new PriorityQueue<>((o1, o2) -> map.get(o2)-map.get(o1));

        for(Character c: map.keySet())
            maxHeap.offer(c);


        StringBuilder sb = new StringBuilder();
        while(!maxHeap.isEmpty()){
            char c = maxHeap.poll();
            while (map.get(c)!=0){
                sb.append(c);
                map.put(c,map.get(c)-1);
            }
        }
        return sb.toString();
    }

}

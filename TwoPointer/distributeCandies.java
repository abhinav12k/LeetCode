package TwoPointer;

import java.util.HashMap;

public class distributeCandies {
    public static void main(String[] args) {

    }
    class Solution {
        public int distributeCandies(int[] candyType) {
            HashMap<Integer,Integer> fMap = new HashMap<>();
            int lt = candyType.length / 2;
            for(int i=0;i<candyType.length;i++){
                fMap.put(candyType[i],fMap.getOrDefault(candyType[i],0)+1);
            }

            int type = 0;
            for(Integer key: fMap.keySet()){
                type++;
                if(type == lt)
                    break;
            }
            return type;
        }
    }
}

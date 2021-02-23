package Arrays.Medium;

import java.util.*;

public class kFrequentElements {
    public static void main(String[] args) {

        int[] arr = {1,1,1,2,2,3};
        int k = 2;

        int[] ans = new Solution().topKFrequent(arr,k);
        for(int i: ans){
            System.out.print(i+" ");
        }
    }

    static class Solution {
        public int[] topKFrequent(int[] nums, int k) {

            HashMap<Integer,Integer> freqMap = new HashMap();
            for(int i=0;i<nums.length;i++){
                freqMap.put(nums[i],freqMap.getOrDefault(nums[i],0)+1);
            }

            List<Integer> keySet = new ArrayList<>(freqMap.keySet());
            Collections.sort(keySet,(a,b) -> freqMap.get(b) - freqMap.get(a));
            int[] ans = new int[k];
            for(int i=0;i<k;i++){
                ans[i] = keySet.get(i);
            }
            return ans;

        }

    }
}

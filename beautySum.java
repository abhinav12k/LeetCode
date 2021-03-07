import java.util.HashMap;

public class beautySum {
    public static void main(String[] args) {
        System.out.println(new Solution().beautySum("aabcb"));
    }

    static class Solution {
        public int beautySum(String s) {

            int left = 0;
            int right = 1;
            int sum = 0;
            HashMap<Character,Integer> fMap = new HashMap<>();
            while (left<right){

                if(right == s.length()){
                    left++;
                    right--;
                }
                sum+=getIdxDiff(s,left,right+1,fMap);
                right++;
            }
            return sum;
        }

        private int getIdxDiff(String s,int start,int end,HashMap<Character,Integer> fMap){
            int minFreq = Integer.MAX_VALUE;
            int maxFreq = Integer.MIN_VALUE;
            if(start==0) {
                for (int i = end-1; i < end; i++) {
                    fMap.put(s.charAt(i), fMap.getOrDefault(s.charAt(i), 0) + 1);
                }
            }else{
                while(start--!=0){
                    fMap.put(s.charAt(start),fMap.getOrDefault(s.charAt(start),0)-1);
                }
            }
            for(Character c:fMap.keySet()) {
                minFreq = Math.min(minFreq, fMap.get(c));
                maxFreq = Math.max(maxFreq, fMap.get(c));
            }
            return maxFreq - minFreq;
        }
    }
}

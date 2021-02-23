package TwoPointer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class longestSSwithoutRepeat {

    public static void main(String[] args) {

        String s = "pwwkew";
        System.out.println(new Solution().lengthOfLongestSubstring2(s));

    }

    static class Solution {

        //Approach 1 - O(2n)
        public int lengthOfLongestSubstring(String s) {
            Set<Character> freqMap = new HashSet<>();

            int left = 0, right = 0;
            int len = 0;
            while (right < s.length()) {

                while(freqMap.contains(s.charAt(right))){
                    freqMap.remove(s.charAt(left));
                    left++;
                }

                len = Math.max(len,right-left+1);
                freqMap.add(s.charAt(right));
                right++;
            }
            return len;
        }

        //Approach 2 - O(n)
        public int lengthOfLongestSubstring2(String s) {
            HashMap<Character,Integer> freqMap = new HashMap<>();

            int left = 0, right = 0;
            int len = 0;
            while (right < s.length()) {

                if(freqMap.containsKey(s.charAt(right))){
                    left = Math.max(freqMap.get(s.charAt(right)) + 1,left);
                }

                len = Math.max(len,right-left+1);
                freqMap.put(s.charAt(right),right);
                right++;
            }
            return len;
        }
    }

}

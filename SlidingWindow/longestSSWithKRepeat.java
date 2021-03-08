package SlidingWindow;

import java.util.HashMap;
import java.util.TreeMap;

public class longestSSWithKRepeat {

    public static void main(String[] args) {

    }

    class Solution {
        public int longestSubstring(String s, int k) {

            if (s.length() == 1 && k >= 1) {
                return 1;
            }

            TreeMap<Character, Integer> map = new TreeMap<>();
            int maxLen = Integer.MAX_VALUE;
            int currLen = 0;
            int start = 0;
            for (int i = 0; i < s.length(); i++) {
                map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            }

            for (Character c : map.keySet()) {
                if (map.get(c) >= k) {
                    currLen += map.get(c);
                } else {
                    char curr = s.charAt(start);
                    map.put(curr, map.get(curr) - 1);
                    currLen -= 1;
                }
            }


        }
    }
}

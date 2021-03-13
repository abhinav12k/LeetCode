package SlidingWindow;

import java.util.Arrays;

public class longestSSWithKRepeat {

    public static void main(String[] args) {

    }

    static class Solution {
        public int longestSubstring(String s, int k) {
            if (s.length() == 1 && k == 1) {
                return 1;
            }else if(s.length()==1 && k > 1)
                return 0;

            int maxUniq = 0;
            boolean[] isVisited = new boolean[26];

            for (int i = 0; i < s.length(); i++) {
                if (!isVisited[s.charAt(i) - 'a']) {
                    maxUniq++;
                    isVisited[s.charAt(i) - 'a'] = true;
                }
            }

            int result = 0;
            int[] countArray = new int[26];
            for (int currUniq = 1; currUniq <= maxUniq; currUniq++) {
                Arrays.fill(countArray,0);
                int winStart = 0, winEnd = 0, unique = 0, countAtLeastk = 0;
                while (winEnd < s.length()) {
                    if (unique <= currUniq) {
                        if (countArray[s.charAt(winEnd)-'a'] == 0)
                            unique++;
                        countArray[s.charAt(winEnd)- 'a']++;
                        if (countArray[s.charAt(winEnd) - 'a'] == k)
                            countAtLeastk++;
                        winEnd++;
                    } else {
                        if (countArray[s.charAt(winStart) - 'a'] == k)
                            countAtLeastk--;
                        countArray[s.charAt(winStart) - 'a']--;
                        if (countArray[s.charAt(winStart) - 'a'] == 0)
                            unique--;
                        winStart++;
                    }

                    if (unique == currUniq && unique == countAtLeastk)
                        result = Math.max(winEnd - winStart, result);

                }

            }
            return result;
        }
    }
}

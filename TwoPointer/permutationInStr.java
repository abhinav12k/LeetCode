package TwoPointer;

import java.util.Arrays;

public class permutationInStr {

    public static void main(String[] args) {
        System.out.println(new Solution().checkInclusion("ab", "eidbaooo"));
    }

    static class Solution {
        public boolean checkInclusion(String s1, String s2) {

            if (s2.length() < s1.length())
                return false;

            int[] fm1 = new int[26];
            int[] fm2 = new int[26];

            for (int i = 0; i < s1.length(); i++) {
                fm1[s1.charAt(i) - 'a']++;
                fm2[s2.charAt(i) - 'a']++;
            }

            for (int i = 0; i < s2.length() - s1.length(); i++) {

                if (Arrays.equals(fm1, fm2)) {
                    return true;
                }
                fm2[s2.charAt(i+s1.length())-'a']++;
                fm2[s2.charAt(i)-'a']--;
            }
            return Arrays.equals(fm1,fm2);
        }
    }
}

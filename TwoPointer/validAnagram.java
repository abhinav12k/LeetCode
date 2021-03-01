package TwoPointer;

import java.util.Arrays;

public class validAnagram {

    class Solution {
        public boolean isAnagram(String s, String t) {

            if(s.length() != t.length())
                return false;

            int[] fm1 = new int[26];
            int[] fm2 = new int[26];

            for(int i=0;i<s.length();i++){
                fm1[s.charAt(i) - 'a']++;
                fm2[t.charAt(i) - 'a']++;
            }
            return Arrays.equals(fm1,fm2);
        }
    }
}

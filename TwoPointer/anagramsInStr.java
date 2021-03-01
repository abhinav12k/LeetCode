package TwoPointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class anagramsInStr {

    public static void main(String[] args) {
        System.out.println(new Solution().findAnagrams("cbaebabacd","abc"));
    }

    static class Solution {
        public List<Integer> findAnagrams(String s, String p) {

            List<Integer> ans = new ArrayList<>();
            if(s.length()<p.length()){
                return ans;
            }

            int[] fm1 = new int[26];
            int[] fm2 = new int[26];

            for(int i=0;i<p.length();i++){
                fm1[p.charAt(i) - 'a']++;
                fm2[s.charAt(i) - 'a']++;
            }

            int i;
            for(i=0;i<s.length()-p.length();i++){

                if(Arrays.equals(fm1,fm2)){
                    ans.add(i);
                }

                fm2[s.charAt(i+p.length()) - 'a']++;
                fm2[s.charAt(i) - 'a']--;

            }

            if(Arrays.equals(fm1,fm2)){
                ans.add(i);
            }

            return ans;
        }
    }
}

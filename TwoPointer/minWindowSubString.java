package TwoPointer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class minWindowSubString {

    public static void main(String[] args) {

        System.out.println(new Solution().minWindow("bba", "ab"));
    }

    static class Solution {
        public String minWindow(String s, String t) {

            if (s.length() == 0 || t.length() == 0) {
                return "";
            }

            HashMap<Character, Integer> map = new HashMap<>();
            for (Character ch : t.toCharArray()) {
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }

            int l = 0, r = 0;
            int reqSize = map.size();
            int count =0;
            int[] ans = {-1,0,0};   //Window size, l, r

            HashMap<Character,Integer> sFMap = new HashMap<>();
            while (r < s.length()) {

                sFMap.put(s.charAt(r),sFMap.getOrDefault(s.charAt(r),0)+1);

                if(map.containsKey(s.charAt(r))
                        && map.get(s.charAt(r)).intValue() == sFMap.get(s.charAt(r)).intValue()){
                    count++;
                }


                while (l <= r && count == reqSize){

                    //save the current min answer
                    if(ans[0]== -1 || r-l+1< ans[0]){
                        ans[0] = r-l+1;
                        ans[1] = l;
                        ans[2] = r;
                    }

                    sFMap.put(s.charAt(l),sFMap.get(s.charAt(l)) - 1);

                    if (map.containsKey(s.charAt(l))
                            && sFMap.get(s.charAt(l)) < map.get(s.charAt(l))){
                        count--;
                    }

                    l++;
                }

                r++;
            }

            return ans[0] == -1 ? "" : s.substring(ans[1],ans[2]+1);
        }
    }

}

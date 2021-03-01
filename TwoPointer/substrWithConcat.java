package TwoPointer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class substrWithConcat {

    public static void main(String[] args) {

        String s = "barfoothefoobarman";
        String[] words = {"foo","bar"};
        System.out.println(new Solution().findSubstring(s, words));

    }

    static class Solution {
        public List<Integer> findSubstring(String s, String[] words) {
            List<Integer> idxs = new ArrayList<>();

            int len =  words[0].length();
            int lt = words.length * len;
            if (s.length() < lt)
                return idxs;

            HashMap<String, Integer> targetMap = new HashMap<>();
            for (int i = 0; i < words.length; i++) {
                targetMap.put(words[i], targetMap.getOrDefault(words[i], 0) + 1);
            }
            for (int i = 0; i < s.length() - lt + 1 ; i+=words[0].length()) {

                HashMap<String, Integer> seen = new HashMap<>();
                int j=0;
                while(j< words.length){

                    String word = s.substring(i+j*len,i+(j+1)*len);
                    if(targetMap.containsKey(word)){
                        seen.put(word,seen.getOrDefault(word,0)+1);
                        if(seen.get(word) > targetMap.getOrDefault(word,0)){
                            break;
                        }
                    }else{
                        break;
                    }
                    j++;
                }

                if(j==words.length){
                    idxs.add(i);
                }
            }

            return idxs;
        }
    }
}

package TwoPointer;

import java.util.*;

public class longestWordInDic {

    public static void main(String[] args) {

    }

    class Solution {
        public String findLongestWord(String s, List<String> dictionary) {
            //TC - O(2^n)
            HashSet<String> set = new HashSet<>(dictionary);
            List<String> l = new ArrayList<>();
            generate(s,"",0,l);
            String max_str = "";
            for(String str: l){

                if(set.contains(str)){
                    if(str.length() > max_str.length() || str.length() == max_str.length() && str.compareTo(max_str) < 0)
                        max_str = str;
                }
            }
            return max_str;
        }

        public void generate(String s,String ans,int idx,List<String> l){
            if(idx == s.length())
                l.add(ans);
            generate(s,ans+s.charAt(idx),idx+1,l);
            generate(s,ans,idx+1,l);
        }

        //Approach - 2 (With SORTING)
        public String findLongestWord2(String s , List<String> d){

            d.sort((o1, o2) -> o1.length() != o2.length() ? o2.length() - o1.length() : o1.compareTo(o2));
            for(String str:d){
                if(isSubsequence(str,s))
                    return str;
            }
            return "";
        }

        public boolean isSubsequence(String str,String s){
            int j = 0;
            for(int i=0;i<s.length() && j < str.length() ;i++){
                if(str.charAt(j) == s.charAt(i))
                    j++;
            }
            return j==str.length();
        }

        //Approach 3 - Without Sorting
        public String findLongestWord3(String s ,List<String> d){
            String max_str = "";
            for(String str: d){
                if(isSubsequence(str,s)){
                    if(str.length() > max_str.length() || str.length() == max_str.length() && str.compareTo(max_str) < 0)
                        max_str = str;
                }
            }
            return max_str;
        }

    }
}

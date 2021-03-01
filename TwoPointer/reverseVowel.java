package TwoPointer;

public class reverseVowel {

    public static void main(String[] args) {

        System.out.print(new Solution().reverseVowels("aA"));

    }

    static class Solution {
        public String reverseVowels(String s) {
            int l =0;
            int r = s.length()-1;
            while(l<r) {

                if (!isVowel(String.valueOf(s.charAt(l)))) {
                    l++;
                    continue;
                }
                if (!isVowel(String.valueOf(s.charAt(r)))) {
                    r--;
                    continue;
                }

                char c = s.charAt(l);
                char d = s.charAt(r);
                s = s.substring(0, l) + d + s.substring(l + 1, r) + c + s.substring(r + 1);
                l++;
                r--;
            }
            return s;
        }

        public boolean isVowel(String ch){
            return ch.equalsIgnoreCase("a") || ch.equalsIgnoreCase("e") || ch.equalsIgnoreCase("i")
                    || ch.equalsIgnoreCase("o") || ch.equalsIgnoreCase("u") ;
        }
    }

}

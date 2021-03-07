package TwoPointer;

public class longestRepeatCharacterReplacement {

    public static void main(String[] args) {

    }

    class Solution {
        public int characterReplacement(String s, int k) {

            int l = 0;
            int r = 0;
            int maxCount = 0;
            int maxFreq = 0;
            int[] fMap = new int[26];
            while(r<s.length()){

                maxFreq = Math.max(maxFreq, ++fMap[s.charAt(r) - 'A']);
                if(r-l+1-maxFreq > k){
                    fMap[s.charAt(r) - 'A']--;
                    l++;
                }
                maxCount = Math.max(maxCount,r-l+1);
                r++;
            }
            return maxCount;
        }
    }
}

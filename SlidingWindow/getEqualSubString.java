package SlidingWindow;

public class getEqualSubString {

    public static void main(String[] args) {

    }

    class Solution {
        public int equalSubstring(String s, String t, int maxCost) {
            int ans = Integer.MIN_VALUE;
            int currSum = 0;
            int[] diff = new int[s.length()];
            int start = 0;
            int len = 0;
            for(int i=0;i<s.length();i++){

                diff[i] = Math.abs(s.charAt(i) - t.charAt(i));
                currSum+=diff[i];
                len++;
                while (start <= i && currSum > maxCost) {
                    currSum-=diff[start];
                    len--;
                    start++;
                }

                ans = Math.max(ans,len);
            }
            return ans;
        }
    }
}

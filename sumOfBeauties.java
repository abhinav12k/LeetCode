public class sumOfBeauties {

    public static void main(String[] args) {

    }

    class Solution {
        public int beautySum(String s) {
            int ans = 0;
            for (int start = 0; start < s.length(); start++) {

                int[] count = new int[26];
                for (int end = start + 1; end < s.length(); end++) {
                    int b = count[s.charAt(end) - 'a']++;

                    int minFq = Integer.MAX_VALUE;
                    int maxFq = Integer.MIN_VALUE;
                    for (int i = 0; i < 26; i++) {
                        minFq = Math.min(minFq, b);
                        maxFq = Math.max(maxFq, b);
                    }
                    ans += maxFq - minFq;
                }

            }
            return ans;
        }
    }

}

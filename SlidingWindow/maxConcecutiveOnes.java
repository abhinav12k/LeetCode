package SlidingWindow;

public class maxConcecutiveOnes {

    public static void main(String[] args) {
        System.out.println(new Solution().longestOnes(new int[]{0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1}, 3));
    }

    static class Solution {
        public int longestOnes(int[] A, int K) {

            //Approach - 1 (TLE)
            int max_len = Integer.MIN_VALUE;
            for (int l = 0; l < A.length; l++) {
                int r = l;
                int max_zeros = 0;
                while (r < A.length) {

                    if (A[r] == 0) {
                        max_zeros++;
                    }

                    if (max_zeros > K) {
                        max_zeros--;
                        break;
                    }

                    if (r - l + 1 > max_len) {
                        max_len = r - l + 1;
                    }
                    r++;
                }

            }
            return max_len == Integer.MIN_VALUE ? 0 : max_len;
        }

        public int largestOnes2(int[] A, int K) {

            //Approach 2
            int max_zeros = 0, l = 0;
            int max_length = 0;
            for (int r = 0; r < A.length; r++) {

                if (A[r] == 0) {
                    max_zeros++;
                }

                while (max_zeros > K) {
                    if (A[l] == 0)
                        max_zeros--;
                    l++;
                }

                max_length = Math.max(max_length, r - l + 1);
            }
            return max_length;
        }
    }

}

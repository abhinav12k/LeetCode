package SlidingWindow;

import java.util.HashMap;

public class subArrayWithKDiffInt {

    class Solution {
        public int subarraysWithKDistinct(int[] A, int K) {
            return atMost(A, K) - atMost(A, K - 1);
        }

        private int atMost(int[] A, int k) {

            int l = 0, r = 0, ans = 0;
            HashMap<Integer, Integer> map = new HashMap<>();

            while (r < A.length) {

                if (map.getOrDefault(A[r], 0) == 0)
                    k--;
                map.put(A[r], map.getOrDefault(A[r], 0) + 1);
                while (k < 0) {
                    map.put(A[l], map.get(A[l]) - 1);
                    if (map.get(A[l]) == 0)
                        k++;
                    l++;
                }
                ans += r - l + 1;
                r++;
            }
            return ans;
        }

    }

}

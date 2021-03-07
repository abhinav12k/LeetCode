package SlidingWindow;

public class grumpy {

    public static void main(String[] args) {
        int[] cust = {1, 0, 1, 2, 1, 1, 7, 5};
        int[] g = {0, 1, 0, 1, 0, 1, 0, 1};
        int x = 3;

        System.out.println(new Solution().maxSatisfied2(cust, g, x));
    }

    static class Solution {
        public int maxSatisfied(int[] customers, int[] grumpy, int X) {

            int max_satisfied = 0;
            for (int i = 0; i < grumpy.length; i++) {
                int curr_satisfied = 0;

                for (int s = 0; s < i && s < customers.length; s++) {
                    if (grumpy[s] == 0) {
                        curr_satisfied += customers[s];
                    }
                }

                for (int k = i; k < i + X && k < customers.length; k++) {
                    curr_satisfied += customers[k];
                }

                for (int j = i + X; j < customers.length; j++) {
                    if (grumpy[j] == 0) {
                        curr_satisfied += customers[j];
                    }
                }
                max_satisfied = Math.max(max_satisfied, curr_satisfied);
            }
            return max_satisfied;
        }

        public int maxSatisfied2(int[] customers, int[] grumpy, int x) {

            int satisfied = 0;
            int max_satisfied = 0;
            for (int i = 0, win_make_satisfied = 0; i < customers.length; i++) {

                if (grumpy[i] == 0) {
                    satisfied += customers[i];
                } else {
                    win_make_satisfied += customers[i];
                }

                if (i >= x) {
                    win_make_satisfied -= grumpy[i - x] * customers[i - x];
                }
                max_satisfied = Math.max(win_make_satisfied,max_satisfied);
            }
            return max_satisfied + satisfied;
        }
    }
}

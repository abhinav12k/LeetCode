package TwoPointer;

import java.util.Arrays;

public class kDiffPairs {

    public static void main(String[] args) {
        System.out.println(new Solution().findPairs(new int[]{3, 1, 4, 1, 5}, 2));
    }

    static class Solution {
        public int findPairs(int[] nums, int k) {
            if(nums == null || nums.length < 1) return 0;

            Arrays.sort(nums);
            int l = 0, ans = 0, prev = Integer.MAX_VALUE;
            for(int r = 1; r < nums.length; r++) {
                while(l < r && nums[r] - nums[l] > k) l++;

                if(l != r && prev != nums[l] && nums[r] - nums[l] == k) {
                    ans++;
                    prev = nums[l];
                }
            }
            return ans;
        }

    }
}

package SlidingWindow;

public class minSizeSubArray {

    public static void main(String[] args) {

    }

    class Solution {
        public int minSubArrayLen(int target, int[] nums) {
            int sum = 0;
            int count = 0;
            int ans = Integer.MAX_VALUE;
            int left = 0;
            int right = 0;
            while (right < nums.length) {

                sum += nums[right];
                count++;
                while (left <= right && sum >= target) {
                    ans = Math.min(ans, count);
                    sum -= nums[left];
                    count--;
                    left++;
                }
                right++;
            }
            return ans==Integer.MAX_VALUE ? 0:ans;
        }
    }
}

package TwoPointer;

public class minSizeSubArray {

    public static void main(String[] args) {
        System.out.println(new Solution().minSubArrayLen2(7,new int[]{2,3,1,2,4,3}));
    }

    static class Solution {
        public int minSubArrayLen(int target, int[] nums) {
            //Approach 1
            int minLen = Integer.MAX_VALUE - 1;
            for (int i = 0; i < nums.length; i++) {
                int sum = 0;
                for (int j = i; j < nums.length; j++) {

                    sum += nums[j];
                    if (sum >= target) {
                        minLen = Math.min(minLen, j - i + 1);
                        break;
                    }

                }

            }

            if (minLen == Integer.MAX_VALUE - 1)
                return 0;
            return minLen;
        }

        public int minSubArrayLen2(int target, int[] nums) {
            //Approach 2
            int right =0,left = 0;
            int sum = 0,min = Integer.MAX_VALUE;
            while(right<nums.length){
                sum += nums[right];
                right++;
                while(sum>=target){
                    min = Math.min(min,right-left);
                    sum-=nums[left];
                    left++;
                }
            }
            return min;
        }

    }
}

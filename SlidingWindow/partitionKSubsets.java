package SlidingWindow;

import java.util.Arrays;

public class partitionKSubsets {

    public static void main(String[] args) {

        int[] nums = {4, 3, 2, 3, 5, 2, 1};
        int k = 4;
        System.out.println(new Solution().canPartitionKSubsets(nums, k));

    }

    static class Solution {
        public boolean canPartitionKSubsets(int[] nums, int k) {
            // TODO - Solution is not correct!
            Arrays.sort(nums);
            int sum = 0;
            for (int n : nums)
                sum += n;

            if (sum % k != 0)
                return false;

            int subsetSum = sum / k;
            int l=0,r=0;
            int currSum = 0;
            int ct = 0;
            while(r<nums.length){

                currSum += nums[r];
                while (l <= r && currSum > subsetSum){
                    currSum-=nums[l];
                    l++;
                }
                if(currSum == subsetSum)
                    ct++;

                r++;
            }
            return ct == k;

        }
    }
}

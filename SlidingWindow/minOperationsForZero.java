package SlidingWindow;

public class minOperationsForZero {
    public static void main(String[] args) {

    }

    static class Solution {
        public int minOperations(int[] nums, int x) {

            int tSum = 0;
            for(int n:nums){
                tSum += n;
            }
            tSum-=x;

            int l = 0, r = 0;
            int currSum = 0;
            int len = Integer.MAX_VALUE;
            while (r < nums.length) {

                currSum += nums[r];
                while(l <= r && currSum > tSum){
                    currSum-= nums[l];
                    l++;
                }
                if(currSum == tSum){
                    len = Math.min(len,l+nums.length-1-r);
                }

                r++;
            }
            return len==Integer.MAX_VALUE ? -1 : len;
        }
    }
}

package SlidingWindow;

public class maxConsecutiveOnes1 {

    public static void main(String[] args) {
        System.out.println(new Solution().findMaxConsecutiveOnes(new int[]{1}));
    }

    static class Solution {
        public int findMaxConsecutiveOnes(int[] nums) {
            int max = 0;
            int curr_max = 0;
            for(int i=0;i<nums.length-1;i++){

                if(nums[i]==1){
                    curr_max++;
                    max = Math.max(max,curr_max);
                }else
                    curr_max=0;

            }
            return max;
        }
    }
}

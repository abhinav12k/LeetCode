package SlidingWindow;

import java.util.Arrays;

public class subSequencesWithCond {

    public static void main(String[] args) {

        int[] num = {3, 5, 6, 7};
        int t = 9;
        System.out.println(new Solution().numSubseq(num, t));

    }

    static class Solution {
        public int numSubseq(int[] nums, int target) {

            Arrays.sort(nums);
            int mod = (int)1e9 + 7;
            int[] pows = new int[nums.length];
            pows[0]=1;
            for(int i=1;i<pows.length;i++){
                pows[i] = pows[i-1]*2 % mod;
            }

            int ans = 0;
            int l = 0,r=nums.length-1;
            while (l<=r){

                if(nums[l] + nums [r] > target){
                    r--;
                }else{
                    ans = (ans + pows[r-l])%mod;
                    l++;
                }

            }
            return ans;
        }
    }

}

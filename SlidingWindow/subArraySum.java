package SlidingWindow;

import java.util.HashMap;

public class subArraySum {

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        int k = 3;
        System.out.println(new Solution().subArraySum(nums,k));
    }

    static class Solution {
        //TC - O(n^2)
        public int subarraySum(int[] nums, int k) {

            int[] pre = new int[nums.length];
            pre[0] = nums[0];
            for(int i=1;i<nums.length;i++){
                pre[i] = pre[i-1] + nums[i];
            }

            int count =0;
            for(int i=0;i<nums.length;i++){
                int sum = 0;
                for(int j=i;j<nums.length;j++){
                    sum+=nums[i];
                    if(sum==k)
                        count++;
                }
            }
            return count;
        }

        public int subArraySum(int[] nums,int k){
            int count = 0;

            HashMap<Integer,Integer> sumMap = new HashMap<>();
            //base condition if the number is exactly equal to k
            sumMap.put(0,1);

            int sum=0;
            for(int i=0;i<nums.length;i++){
                sum+=nums[i];
                if(sumMap.containsKey(sum - k)){
                    count+=sumMap.get(sum-k);
                }
                sumMap.put(sum,sumMap.getOrDefault(sum,0)+1);
            }
            return count;
        }
    }

}

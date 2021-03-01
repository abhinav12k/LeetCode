package TwoPointer;

import java.util.HashMap;
import java.util.HashSet;

public class maxUniqSubArray {

    public static void main(String[] args) {
//        System.out.println(new Solution().maximumUniqueSubarray(new int[]{4,2,4,5,6}));
        System.out.println(new Solution().maxUniqArray(new int[]{4, 2, 4, 5, 6}));

    }

    static class Solution {
        //Approach 1
        public int maximumUniqueSubarray(int[] nums) {

            int maxSum = 0;
            for (int i = 0; i < nums.length; i++) {
                int currSum = 0;
                HashMap<Integer, Integer> idxMap = new HashMap<>();
                for (int j = i; j < nums.length; j++) {

                    if (idxMap.containsKey(nums[j])) {
                        i = idxMap.get(nums[j]);
                        break;
                    } else {
                        idxMap.put(nums[j], j);
                    }
                    currSum += nums[j];
                    maxSum = Math.max(maxSum, currSum);

                }
            }
            return maxSum;
        }

        public int maxUniqArray(int[] arr) {

            //prefix array sum
            int[] prefix = new int[arr.length];
            prefix[0] = arr[0];
            for(int i=1;i<arr.length;i++){
                prefix[i] = prefix[i-1] + arr[i];
            }

            HashMap<Integer,Integer> idxMap = new HashMap<>();
            int i = 0;
            int j =0;
            int maxSum = 0;

            int currSum = 0;
            while(i<arr.length){

                currSum+=arr[i];
                if(idxMap.containsKey(arr[i]) && j <= idxMap.get(arr[i])){
                    j = idxMap.get(arr[i]);
                    currSum = prefix[i] - prefix[j];
                }

                idxMap.put(arr[i],i);
                maxSum = Math.max(maxSum,currSum);
                i++;
            }
            return maxSum;
        }

        public int maxUniqSum(int[] arr){

            HashSet<Integer> set = new HashSet<>();

            int i = 0, j = 0;
            int sum = 0;
            int ans =0;
            while (i < arr.length && j < arr.length) {

                if(!set.contains(arr[j])){
                    sum+=arr[j];
                    set.add(arr[i]);
                    ans = Math.max(ans,sum);
                    j++;
                }else{
                    sum-=arr[i];
                    set.remove(arr[i]);
                    i++;
                }

            }

            return ans;
        }

    }

}

package Arrays.Medium;

import java.util.*;

public class FourSum {
    public static void main(String[] args) {

        int[] nums ={1,0,-1,0,-2,2};
        int target = 0;

        System.out.println(new Solution().fourSum(nums,target));
    }

    static class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {

            Set<List<Integer>> result = new HashSet<>();
            Arrays.sort(nums);

            for(int i=0;i<nums.length;i++){

                for(int j=i+1;j<nums.length;j++) {


                    int k = j + 1;
                    int l = nums.length-1;
                    while (k < l) {

                        int sum = nums[i] + nums[j] + nums[k] + nums[l];

                        if (sum == target) {
                            result.add(Arrays.asList(nums[i],nums[j],nums[k],nums[l]));
                            k++;
                            l--;

                        } else if (sum < target) {
                            k++;
                        } else {
                            l--;
                        }

                    }
                }
            }
            return new ArrayList<>(result);
        }
    }
}

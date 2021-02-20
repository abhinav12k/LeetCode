package Arrays.Medium;

public class nextPermutation {

    public static void main(String[] args) {

       int[] nums = {1,2,3};
       new Solution().nextPermutation(nums);
       for(int i:nums){
           System.out.println(i);
       }
    }

    static class Solution {
        public void nextPermutation(int[] nums) {

            int last = nums.length - 2;
            while(last>=0 && nums[last] >= nums[last+1]){
                last--;
            }

            if(last>=0) {
                int swapIdx = nums.length - 1;
                while (nums[last] >= nums[swapIdx]) {
                    swapIdx--;
                }
                swap(nums, last, swapIdx);
            }
            reverseArray(nums,last+1,nums.length-1);

        }

        private void reverseArray(int[] nums, int i,int j) {
            while(i<j){
                swap(nums,i,j);
                i++;
                j--;
            }
        }

        private void swap(int[] arr,int idx1,int idx2){
            int temp = arr[idx1];
            arr[idx1] = arr[idx2];
            arr[idx2] = temp;
        }


    }

}

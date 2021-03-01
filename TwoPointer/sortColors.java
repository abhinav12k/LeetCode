package TwoPointer;

public class sortColors {

    public static void main(String[] args) {

        new Solution().sortColors(new int[]{2, 0, 2, 1, 1, 0});

    }

    static class Solution {
        public void sortColors(int[] nums) {

            // 1 Pass
            int start = 0,end = nums.length-1,idx=0;
            while (idx <= end){

                if(nums[idx] == 0){
                    nums[idx] = nums[start];
                    nums[start] = 0;
                    start++;
                }

                if(nums[idx] == 2){
                    nums[idx] = nums[end];
                    nums[end] = 2;
                    idx--;
                    end--;
                }
                idx++;
            }

            // 2 Pass
//            int[] count = new int[3];
//            for(int i=0;i<nums.length;i++){
//
//                if(nums[i] == 0)
//                    count[0]++;
//                else if(nums[i] == 1)
//                    count[1]++;
//                else
//                    count[2]++;
//            }
//            for(int i=0;i<count[0];i++){
//                nums[i]=0;
//            }
//            for(int i=0;i< count[1];i++){
//                nums[count[0] + i]=1;
//            }
//            for(int i=0;i<count[2];i++){
//                nums[count[1] + count[0] + i]=2;
//            }
        }
    }

}

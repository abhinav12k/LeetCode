package TwoPointer;

public class removeDuplicates2 {

    class Solution {
        public int removeDuplicates(int[] nums) {

            int count = 0;
            for(int n: nums){
                if(count < 2 || n > nums[count-2]){
                    nums[count++] = n;
                }
            }
            return count;
        }
    }

}

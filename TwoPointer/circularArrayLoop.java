package TwoPointer;

import java.util.HashMap;

public class circularArrayLoop {

    class Solution {
        public boolean circularArrayLoop(int[] nums) {

            //similar approach as used to find cycle in ll
            int n = nums.length;
            if (n == 1) {
                return false;
            }
            for (int i = 0; i < n; i++) {
                if (nums[i] == 0)
                    continue;

                //slow/fast pointer approach
                int slow = i, fast = getIndex(i, nums);
                while (nums[fast] * nums[i] > 0 && nums[getIndex(fast, nums)] * nums[i] > 0) {
                    if (slow == fast) {
                        if (slow == getIndex(slow, nums)) {
                            break;
                        }
                        return true;
                    }
                    slow = getIndex(slow, nums);
                    fast = getIndex(getIndex(fast, nums), nums);
                }

                //loop not found, set all element along the way to  0
                //OPTIONAL
//                slow = i;
//                int val = nums[i];
//                while (nums[slow] * val > 0){
//                    int next = getIndex(slow,nums);
//                    nums[slow]=0;
//                    slow = next;
//                }

            }
            return false;
        }

        private int getIndex(int i, int[] nums) {
            int n = nums.length;
            return i + nums[i] >= 0 ? (i + nums[i]) % n : n + ((i + nums[i]) % n);
        }

        private boolean circularArrayLoop2(int[] nums) {

            //TODO - Another approach - may work but currently failing
            int count = 10000;
            for (int i = 0; i < nums.length; i++) {

                while (true) {

                    int j = i + nums[i] >= 0 ? (i + nums[i]) % nums.length : nums.length + ((i + nums[i]) % nums.length);

                    if (nums[i] * nums[j] > 0) {
                        //same sign

                        if (i == j) {
                            break;
                        }

                        if (nums[i] == count) {
                            return true;
                        } else if (nums[i] <= 1000) {
                            // not in any cycle
                            nums[i] = count;
                            i=j;
                        } else {
                            // part of other cycle
                            break;
                        }



                    } else {
                        nums[i] = count;
                        break;
                    }

                }

                count++;
            }
            return false;
        }

    }
}

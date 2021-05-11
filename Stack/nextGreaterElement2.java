package Stack;

import java.util.Stack;

public class nextGreaterElement2 {
    public static void main(String[] args) {

    }

    class Solution {
        public int[] nextGreaterElements(int[] nums) {

            Stack<Integer> stack = new Stack();
            int size=nums.length;
            int[] ans = new int[size];

            for(int i=2*size-1;i>=0;i--){
                if(stack.isEmpty())
                    ans[i%size] = -1;
                else{
                    if(stack.peek() > nums[i%size])
                        ans[i%size] = stack.peek();
                    else{
                        while(!stack.isEmpty() && stack.peek() <= nums[i%size])
                            stack.pop();
                        if(stack.isEmpty())
                            ans[i%size] = -1;
                        else
                            ans[i%size] =stack.peek();
                    }
                }
                stack.push(nums[i%size]);
            }

            return ans;
        }
    }
}

package Stack;

import java.util.Stack;

public class maxSubArrayMinProd {

    public static void main(String[] args) {

    }

    static long[] presum;
    public static int maxSumMinProduct(int[] nums){

        int n = nums.length;
        int[] left_bound = new int[n];
        int[] right_bound = new int[n];

        Stack<Integer> stack = new Stack<>();

        //calculating NSL
        for(int i=0;i<n;i++){

            if(stack.isEmpty()){
                left_bound[i] = -1;
            }else {

                if(nums[stack.peek()] < nums[i]){
                    left_bound[i] = stack.peek();
                }else {

                    while (!stack.isEmpty() && nums[stack.peek()] >= nums[i])
                        stack.pop();

                    if (stack.isEmpty()) {
                        left_bound[i] = -1;
                    }else{
                        left_bound[i] = stack.peek();
                    }
                }

            }
            stack.push(i);
        }

        //calculating NSR
        stack = new Stack<>();
        for(int i=n-1;i>=0;i--){

            if(stack.isEmpty()){
                right_bound[i] = n;
            }else{

                if(nums[stack.peek()] < nums[i]){
                    right_bound[i] = stack.peek();
                }else{

                    while(!stack.isEmpty() && nums[stack.peek()] >= nums[i])
                        stack.pop();

                    if(stack.isEmpty()){
                        right_bound[i] = n;
                    }else{
                        right_bound[i] = stack.peek();
                    }
                }

            }
            stack.push(i);
        }

        presum = new long[n];
        presum[0] = nums[0];
        for(int i=1;i<n;i++){
            presum[i] = presum[i-1]+nums[i];
        }

        long maxProd = 0;
        for(int i=0;i<n;i++){
            maxProd = Math.max(maxProd,getSum(left_bound[i],right_bound[i])*nums[i]);
        }
        return (int)(maxProd % 1000_000_007);
    }

    private static long getSum(int left_idx, int right_idx){
        if(left_idx==-1 && right_idx == presum.length)
            return presum[right_idx-1];
        else if(left_idx == -1)
            return presum[right_idx-1];
        else if(right_idx==presum.length)
            return presum[right_idx-1]-presum[left_idx];
        else
            return presum[right_idx-1] - presum[left_idx];
    }

}

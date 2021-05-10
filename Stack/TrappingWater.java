package Stack;

import java.util.Stack;

public class TrappingWater {


    public static void main(String[] args) {

        int[] height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(new Solution().trap(height));

    }

    static class Solution {
        //O(n2) - handle case when start height is low
        public int trap(int[] height) {
            int water = 0;
            for(int i=0;i<height.length;){
                int h = height[i];
                if(h>0){
                    //search for next higher height
                    int j = i+1;
                    for(;j<height.length;j++){
                        if(height[j]>=h)
                            break;
                    }
                    if(j==height.length){
                        i++;
                        continue;
                    }
                    int k = i+1;
                    while(k<j){
                        water += Math.min(h,height[j]) - height[k];
                        k++;
                    }

                    i=j;
                }else{
                    i++;
                }

            }
            return water;

        }

        private int trapUsingDP(int[] height){
            if(height.length==0)
                return 0;

            int water=0;
            int size = height.length;
            int[] left_max = new int[size];
            int[] right_max = new int[size];

            left_max[0] = height[0];
            for(int i=1;i<size;i++)
                left_max[i]=Math.max(height[i],left_max[i-1]);

            right_max[size-1] = height[size-1];
            for(int i=size-2;i>=0;i--)
                right_max[i] = Math.max(height[i],right_max[i+1]);

            for(int i=1;i<size;i++)
                water+=Math.min(left_max[i],right_max[i])-height[i];
            return water;
        }

        private int trapUsingStack(int[] height){

            Stack<Integer> stack = new Stack<>();

            int ans =0;
            for(int i=0;i<height.length;i++){

                while(!stack.isEmpty() && height[i] > height[stack.peek()]){

                    int top = stack.pop();
                    if(stack.isEmpty())
                        break;

                    int dist = i - stack.peek() - 1;
                    int ht = Math.min(height[i],height[stack.peek()]) - height[top];
                    ans+=dist*ht;

                }
                stack.push(i);
            }
            return ans;
        }

        private int trapUsingTwoPointer(int[] height){

            if(height.length==0)
                return 0;

            int water=0;
            int left = 0, right = height.length-1;
            int left_max = 0,right_max = 0;
            while (left<right){

                if(height[left] > left_max)
                    left_max = height[left];
                if(height[right] > right_max)
                    right_max = height[right];

                if(left_max < right_max){
                    water += left_max - height[left];
                    left++;
                }else{
                    water += right_max - height[right];
                    right--;
                }

            }
            return water;
        }

    }

}

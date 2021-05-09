package Stack;

import java.util.Stack;

public class largestAreaHistogram {

    public static void main(String[] args) {

        int[] heights = new int[]{2,1,5,6,2,3};
        System.out.println(getLargestArea(heights));
    }

    //Method 1 - reduction to NSL(nearest smaller to left) and NSR(nearest smaller to right) standard problem
    private static int getLargestArea(int[] heights){

        Stack<Integer> leftStack = new Stack<>();
        Stack<Integer> rightStack = new Stack<>();
        //to store nsl
        int[] left = new int[heights.length];
        //to store nsr
        int[] right = new int[heights.length];

        int lo=0;
        int hi = heights.length;
        while(lo<hi){

            if(leftStack.isEmpty()){
                left[lo]= -1;
            }else{

                if(heights[leftStack.peek()] < heights[lo]){
                    left[lo] = leftStack.peek();
                }else {

                    while(!leftStack.isEmpty() && heights[leftStack.peek()] >= heights[lo]){
                        leftStack.pop();
                    }
                    if(leftStack.isEmpty()){
                        left[lo] = -1;
                    }else{
                        left[lo] = leftStack.peek();
                    }
                }

            }
            leftStack.push(lo);
            lo++;
        }

        for(int i=heights.length-1;i>=0;i--){

            if(rightStack.isEmpty()){
                right[i] = heights.length;
            }else{

                if(heights[rightStack.peek()] < heights[i]){
                    right[i] = rightStack.peek();
                }else{

                    while (!rightStack.isEmpty() && heights[rightStack.peek()] >= heights[i]){
                        rightStack.pop();
                    }
                    if(rightStack.isEmpty()){
                        right[i] = heights.length;
                    }else{
                        right[i] = rightStack.peek();
                    }
                }

            }
            rightStack.push(i);
        }

        //Calculating the area of histogram
        int maxArea = Integer.MIN_VALUE;
        for(int idx = 0;idx<heights.length;idx++){

            int width = right[idx]-left[idx]-1;
            int length = heights[idx];
            int area = length*width;
            maxArea = Math.max(maxArea,area);
        }
        return maxArea;
    }

    //Method 2 -> Using single stack (Optimized)
    private static int getLargestAreaOptimized(int[] heights){

        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;

        for(int i=0;i<heights.length;i++){

            int h = heights[i];

            if(stack.isEmpty() || h >= heights[stack.peek()]){
                stack.push(i);
            }else{

                while(!stack.isEmpty() && heights[stack.peek()] > h){
                    int ht = heights[stack.pop()];
                    int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                    maxArea = Math.max(maxArea,ht*width);
                }

                stack.push(i);
            }

        }

        //for handling increasing heights
        if(!stack.isEmpty()){
            int width = heights.length;
            while(!stack.isEmpty()){
                int ht = heights[stack.pop()];
                maxArea = Math.max(maxArea,ht* (stack.isEmpty() ? width : width - stack.peek() - 1 ));
            }
        }

        return maxArea;
    }

}

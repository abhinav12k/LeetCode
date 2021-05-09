package Stack;

import java.util.Stack;

public class maximalBinaryRectangle {

    public static void main(String[] args) {



    }

    private static int maximalRectangle(int[][] matrix){
        if(matrix.length==0)
            return 0;

        int[] heights = new int[matrix[0].length];
        int maxArea=0;
        for(int r=0;r<matrix.length;r++){
            for(int c=0;c<matrix[0].length;c++){
                if(matrix[r][c]==0){
                    heights[c] = 0;
                }else{
                    heights[c] += 1;
                }
            }
            maxArea = Math.max(maxArea,getMaxHeight(heights));
        }
        return maxArea;
    }

    private static int getMaxHeight(int[] arr){

        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;

        for(int i=0;i<arr.length;i++){

            int h = arr[i];

            if(stack.isEmpty() || h >= arr[stack.peek()]){
                stack.push(i);
            }else{

                while(!stack.isEmpty() && arr[stack.peek()] > h){
                    int ht = arr[stack.pop()];
                    int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                    maxArea = Math.max(maxArea,ht*width);
                }

                stack.push(i);
            }

        }

        //for handling increasing heights
        if(!stack.isEmpty()){
            int width = arr.length;
            while(!stack.isEmpty()){
                int ht = arr[stack.pop()];
                maxArea = Math.max(maxArea,ht* (stack.isEmpty() ? width : width - stack.peek() - 1 ));
            }
        }

        return maxArea;
    }

}

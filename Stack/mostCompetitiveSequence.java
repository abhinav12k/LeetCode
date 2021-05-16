package Stack;

import java.util.Stack;

public class mostCompetitiveSequence {

    public static void main(String[] args) {

    }

    private static int[] getMostCompetitive(int[] arr,int k){

        Stack<Integer> stack = new Stack<Integer>();
        int[] ans = new int[k];
        for(int i=0;i<arr.length;i++){
            while(!stack.isEmpty() && arr[i] < arr[stack.peek()] && arr.length - i + stack.size() > k)
                stack.pop();
            if(stack.size()<k)
                stack.push(i);
        }
        for(int i=k-1;i>=0;i--){
            ans[i] = arr[stack.pop()];
        }
        return ans;
    }

}

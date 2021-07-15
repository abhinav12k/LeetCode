package Recursion;

import java.util.Stack;

public class removeMiddleElementStack {

    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<6;i++){
            stack.push(i);
        }

        System.out.println(stack);
        removeElement(stack);
        System.out.println(stack);
    }

    private static Stack<Integer> removeElement(Stack<Integer> stack){

        if(stack.size()==0)
            return stack;

        int k = stack.size()/2 + 1;
        solve(stack,k);
        return stack;
    }

    private static void solve(Stack<Integer> stack, int k){

        if(k==1){
            stack.pop();
            return;
        }

        int top = stack.pop();
        solve(stack,k-1);
        stack.push(top);

    }

}

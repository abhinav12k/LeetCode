package Recursion;

import java.util.Stack;

public class reverseStack {

    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<6;i++)
            stack.push(i);

        System.out.println(stack);
        reverse(stack);
        System.out.println(stack);
    }

    private static void reverse(Stack<Integer> stack){

        if(stack.size()==1)
            return;

        int last = stack.pop();
        reverse(stack);
        insert(stack,last);
    }

    private static void insert(Stack<Integer> stack,int temp){

        if(stack.size()==0){
            stack.push(temp);
            return;
        }

        int last = stack.pop();
        insert(stack,temp);
        stack.push(last);
    }

}


package Recursion;

import java.util.Stack;

public class sortStack {

    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();
        stack.add(5);
        stack.add(1);
        stack.add(15);
        stack.add(4);
        stack.add(2);
        stack.add(3);

        sortstack(stack);
        System.out.println(stack);
    }

    private static void sortstack(Stack<Integer> stack){

        if(stack.size()==1) return;

        int last = stack.pop();
        sortstack(stack);
        insert(stack,last);
    }

    private static void insert(Stack<Integer> stack,int temp){

        if(stack.isEmpty() || stack.peek() <= temp) {
            stack.push(temp);
            return;
        }

        int last = stack.pop();
        insert(stack,temp);
        stack.push(last);
    }

}

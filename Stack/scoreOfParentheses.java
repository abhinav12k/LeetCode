package Stack;

import java.util.Stack;

public class scoreOfParentheses {

    public static void main(String[] args) {

        String sr = "(()(()))";
        System.out.println(getScore(sr));
    }

    private static int getScore(String str){

        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for(char c: str.toCharArray()){
            if(c=='('){
                stack.push(0);
            }else{
                int score = stack.pop();
                int depth = stack.pop();
                stack.push(depth+Math.max(2*score,1));
            }
        }
        return stack.pop();
    }

}

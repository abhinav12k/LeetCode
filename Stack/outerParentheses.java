package Stack;

import java.util.Stack;

public class outerParentheses {

    public static void main(String[] args) {

        String str = "(()())(())(()(()))";
        System.out.println(removeOuterParentheses(str));
        System.out.println(removeOuterParenthesesWithoutStack(str));
    }

    private static String removeOuterParentheses(String str){

        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(char c : str.toCharArray()){

            if(c=='(' && stack.isEmpty()){
                stack.push('(');
            }else if(c == '(' && stack.size() >= 1){
                stack.push('(');
                sb.append("(");
            }else if(c == ')' && stack.size() > 1){
                stack.pop();
                sb.append(")");
            }else if(c==')' && stack.size() == 1){
                stack.pop();
            }

        }
        return sb.toString();
    }

    private static String removeOuterParenthesesWithoutStack(String str){

        StringBuilder sb = new StringBuilder();
        int open = 0;
        for(char c: str.toCharArray()){
            if(c=='(' && open++ > 0)
                sb.append("(");
            else if(c==')' && open-- > 1)
                sb.append(")");
        }

        return sb.toString();
    }

}

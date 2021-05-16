package DailyByte;

import java.util.Stack;

public class Day1 {

    public static void main(String[] args) {

        System.out.println(reverseString("The Daily Byte"));
    }

    private static String reverseString(String str){
        Stack<Character> stack = new Stack<>();
        for(char c: str.toCharArray()){
            stack.push(c);
        }
        String ans = "";
        while(!stack.isEmpty()){
            ans += stack.pop();
        }
        return ans;
    }

}

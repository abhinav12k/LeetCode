package Stack;

import java.util.Stack;

public class basicCal {

    public static void main(String[] args) {


    }

    public int calculate(String s) {

        Stack<Integer> stack = new Stack<>();

        int number = 0;
        int sign = 1;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {

                int currNumber = ch - '0';
                while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                    currNumber = currNumber * 10 + s.charAt(i + 1) - '0';
                    i++;
                }
                number += currNumber * sign;
            } else if (ch == '+') {
                sign = 1;
            } else if (ch == '-')
                sign = -1;
            else if (ch == '(') {
                stack.push(number);
                stack.push(sign);

                number = 0;
                sign = 1;
            } else if (ch == ')') {

                number = number * stack.pop() + stack.pop();

            }


        }

        return number;
    }

}

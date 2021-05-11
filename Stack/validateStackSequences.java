package Stack;

import java.util.Stack;

public class validateStackSequences {

    public static void main(String[] args) {

        int[] pushed = {1, 2, 3, 4, 5};
        int[] popped = {4, 5, 3, 1, 2};
        System.out.println(validateStack(pushed, popped));
    }

    private static boolean validateStack(int[] pushed, int[] popped) {

        Stack<Integer> stack = new Stack<>();
        int j = 0;
        int size = popped.length;
        for (int i = 0; i < size; i++) {
            stack.push(pushed[i]);
            while (!stack.isEmpty() && j < size && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            }
        }
        return j == size;
    }
}

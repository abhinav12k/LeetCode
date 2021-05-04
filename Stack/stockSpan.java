package Stack;

import java.util.Stack;

public class stockSpan {
    public static void main(String[] args) {

        int[] prices = new int[]{100, 80, 60, 70, 60, 75, 85};
        int[] ans = getSpan(prices);
        for (int a : ans)
            System.out.print(a + " ");
    }

    private static int[] getSpan(int[] prices) {

        //Stack will store indices
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {

            if (stack.isEmpty()) {
                ans[i] = 1;
            } else {
                if (prices[stack.peek()] > prices[i]) {
                    ans[i] = 1;
                } else {
                    //search until you get a larger element
                    while (!stack.isEmpty() && prices[stack.peek()] <= prices[i])
                        stack.pop();
                    if (stack.isEmpty())
                        ans[i] = i + 1;
                    else
                        ans[i] = i - stack.peek();
                }
            }
            stack.push(i);
        }
        return ans;
    }

}

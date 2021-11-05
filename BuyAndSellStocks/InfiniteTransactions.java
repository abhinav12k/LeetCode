package BuyAndSellStocks;

import java.util.Scanner;

public class InfiniteTransactions {

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int[] prices = new int[n];

        for (int i = 0; i < n; i++) {
            prices[i] = scn.nextInt();
        }

        //buying date, selling date
        int bd = 0, sd = 0;
        int profit = 0;
        for (int i = 1; i < n; i++) {
            if (prices[i] > prices[i - 1]) {
                sd++;
            } else {
                profit += prices[sd] - prices[bd];
                bd = sd = i;
            }
        }
        profit+=prices[sd]-prices[bd];
        System.out.println(profit);
    }

}

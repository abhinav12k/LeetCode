package BuyAndSellStocks;

import java.util.Scanner;

public class InfiniteTransactionsWithFee {
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] prices = new int[n];
        for (int i = 0; i < n; i++)
            prices[i] = scn.nextInt();

        int fee = scn.nextInt();
        int obsp = -prices[0];
        int ossp = 0;
        for (int i = 0; i < n; i++) {
            int nbsp = 0;
            int nssp = 0;

            if (ossp - prices[i] > obsp) {
                nbsp = ossp - prices[i];
            } else {
                nbsp = obsp;
            }

            if (obsp + prices[i] - fee > ossp) {
                nssp = obsp + prices[i] - fee;
            } else {
                nssp = ossp;
            }

            ossp = nssp;
            obsp = nbsp;
        }
        System.out.println(ossp);
    }
}

package BuyAndSellStocks;

import java.util.Scanner;

public class InfiniteTransactionsWithCooldown {
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        //cooldown period is of 1 day

        int bsp = -arr[0];
        int ssp = 0;
        int csp = 0;

        for (int i = 1; i < n; i++) {
            int nbsp = 0;
            int nssp = 0;
            int ncsp = 0;

            if(csp - arr[i] > bsp){
                nbsp = csp - arr[i];
            }else{
                nbsp = bsp;
            }

            if(bsp + arr[i] > ssp){
                nssp =bsp+arr[i];
            }else{
                nssp = ssp;
            }

            if(ssp>csp){
                ncsp = ssp;
            }else{
                ncsp = ssp;
            }

            bsp = nbsp;
            ssp = nssp;
            csp = ncsp;
        }

        System.out.println(Math.max(ssp,csp));
    }
}

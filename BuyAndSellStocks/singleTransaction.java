package BuyAndSellStocks;

public class singleTransaction {

    public static void main(String[] args) {

        int[] prices = {11, 6, 7, 19, 4, 1, 6, 18, 4};

        int min = prices[0];
        int profit = 0;

        for(int i=1;i<prices.length;i++){
            min = Math.min(min,prices[i]);
            profit = Math.max(profit,prices[i]-min);
        }

        System.out.println(profit);
    }

}

package Arrays.Easy;

public class bestTimeII {

    public static void main(String[] args) {

        int[] prices = {7,1,5,3,6,4};
        System.out.println(bruteForce(prices));
        System.out.println(getMaxProfit(prices));
        System.out.println(getMaxProfitInSinglePass(prices));
    }

    private static int bruteForce(int[] arr){
        return maxProfit(arr,0);
    }

    private static int maxProfit(int[] prices,int s){

        if (s >= prices.length)
            return 0;
        int max = 0;
        for (int start = s; start < prices.length; start++) {
            int maxprofit = 0;
            for (int i = start + 1; i < prices.length; i++) {
                if (prices[start] < prices[i]) {
                    int profit = maxProfit(prices, i + 1) + prices[i] - prices[start];
                    if (profit > maxprofit)
                        maxprofit = profit;
                }
            }
            if (maxprofit > max)
                max = maxprofit;
        }
        return max;

    }

    //Peak Valley approach

    private static int getMaxProfit(int[] prices){

        int maxProfit = 0;
        int peak = prices[0];
        int valley = prices[0];

        int i=0;
        while(i<prices.length-1){

            while(i< prices.length - 1 && prices[i] >= prices[i+1])
                i++;
            valley = prices[i];

            while(i<prices.length - 1 && prices[i] <= prices[i+1])
                i++;
            peak = prices[i];
            maxProfit += peak - valley;
        }
        return maxProfit;
    }

    private static int getMaxProfitInSinglePass(int[] prices){

        int maxProfit = 0;
        for(int i=1;i<prices.length;i++){
            if(prices[i] > prices[i-1])
                maxProfit+=prices[i]-prices[i-1];
        }
        return maxProfit;
    }


}

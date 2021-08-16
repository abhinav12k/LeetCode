package DynamicProgramming;

public class rodCutting {

    /**
     * Application of unbounded  knapsack
     **/

    public static void main(String[] args) {

        int[] prices = {1,5,8,9,10,17,17,20};
        int n = prices.length;
        int[] length = new int[n];
        for(int i=1;i<=n;i++)
            length[i-1]=i;
        System.out.println(getMaxProfit(prices,length,n));
    }

    private static int getMaxProfit(int[] prices,int[] length,int n){

        int[][] t= new int[prices.length+1][n+1];
        for(int i=0;i<=prices.length;i++){
            for(int j=0;j<=n;j++){
                if(i==0){
                    t[i][j] = 0;
                }
                if(j==0) {
                    t[i][j] = 0;
                }
            }
        }

        for(int i=1;i<=prices.length;i++){
            for(int j=1;j<=n;j++){
                if(length[i-1]<=j){
                    t[i][j] = Math.max(t[i-1][j],prices[i-1]+t[i][j-length[i-1]]);
                }else{
                    t[i][j] = t[i-1][j];
                }
            }
        }
        return t[prices.length][n];
    }
}

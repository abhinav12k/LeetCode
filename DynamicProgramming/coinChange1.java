package DynamicProgramming;

public class coinChange1 {

    /**
     * Maximum number of ways in which we can obtain the sum
     **/

    public static void main(String[] args) {
        int[] coins = {1,2,3};
        int sum = 5;
        System.out.println(getCoinSumWays(coins,sum));
    }

    private static int getCoinSumWays(int[] coins,int sum){

        int[][] t= new int[coins.length+1][sum+1];

        for(int i=0;i<=coins.length;i++){
            for(int j=0;j<=sum;j++){
                if(i==0){
                    t[i][j]=0;
                }
                if(j==0){
                    t[i][j] = 1;
                }
            }
        }

        for(int i=1;i<=coins.length;i++){
            for(int j=1;j<=sum;j++){
                if(coins[i-1]<=j){
                    t[i][j] = t[i-1][j] + t[i][j-coins[i-1]];
                }else{
                    t[i][j] = t[i-1][j];
                }
            }
        }
        return t[coins.length][sum];
    }

}

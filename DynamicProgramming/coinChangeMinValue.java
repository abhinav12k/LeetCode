package DynamicProgramming;

public class coinChangeMinValue {

    /**
     * Minimum number of coins required to have sum
    **/

    public static void main(String[] args) {

        int[] coins = {3,2,5};
        int sum = 5;

        System.out.println(getMinCoinsToSumValue(coins,sum));
    }

    private static int getMinCoinsToSumValue(int[] coins,int sum){
        int[][] t = new int[coins.length+1][sum+1];

        //for filling out first row
        for(int i=0;i<=coins.length;i++){
            for(int j=0;j<=sum;j++){
                if(i==0){
                    t[i][j] = 0;
                }
                if(j==0){
                    t[i][j] = Integer.MAX_VALUE-1;
                }
            }
        }

        //for filling out the second row
        for(int j=1;j<=sum;j++){
            if(j%coins[0]==0)
                t[1][j] = j/coins[0];
            else
                t[1][j] = Integer.MAX_VALUE-1;
        }

        for(int i=2;i<=coins.length;i++){
            for(int j=2;j<=sum;j++){
                if(coins[i-1]<=j){
                    t[i][j] = Math.min(1+t[i][j-coins[i-1]],t[i-1][j]);
                }else{
                    t[i][j] = t[i-1][j];
                }
            }
        }
        return t[coins.length][sum];
    }
}

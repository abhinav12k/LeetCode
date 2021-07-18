package Recursion;

public class CoinChange {
    public static void main(String[] args) {

        int[] denom = {2,3,5};
        coinChange(denom,10,"",0);
        coinChangePermutation(denom,10,"");
    }

    static int count = 0;

    //No permutation
    private static void coinChange(int[] denom,int amount,String ans,int lastIdxUsed){

        if(amount==0){
            count++;
            System.out.println(count+". "+ans);
            return;
        }

        if(amount < 0){
            return;
        }

        for(int i=lastIdxUsed;i<denom.length;i++){
            coinChange(denom,amount-denom[i],ans+denom[i],i);
        }

    }

    private static void coinChangePermutation(int[] denom,int amount,String ans){

        if(amount == 0){
            count++;
            System.out.println(count + ". "+ans);
            return;
        }

        if(amount < 0){
            return;
        }

        for(int i=0;i<denom.length;i++)
            coinChangePermutation(denom,amount - denom[i],ans+denom[i]);

    }
}

package DynamicProgramming;

public class countSubsets {
    public static void main(String[] args) {

        int[] arr = {2,3,5,6,8,10};
        int sum = 10;
        System.out.println(count(arr,sum));
    }

    private static int count(int[] arr,int sum){

        int[][] t = new int[arr.length+1][sum+1];
        for(int i=0;i<=arr.length;i++){
            for(int j=0;j<=sum;j++){
                if(i==0){
                    t[i][j] = 0;
                }
                if(j==0){
                    t[i][j] = 1;
                }
            }
        }

        for(int i=1;i<=arr.length;i++){
            for(int j=1;j<=sum;j++){
                if(arr[i-1]<=j){
                    t[i][j] = t[i-1][j]+t[i-1][j-arr[i-1]];
                }else{
                    t[i][j] = t[i-1][j];
                }
            }
        }
        return t[arr.length][sum];
    }
}

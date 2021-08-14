package DynamicProgramming;

public class subsetWithGivenDiff {
    public static void main(String[] args) {
        int[] arr = {1,1,2,3};
        int diff = 1;
        System.out.println(countSubsets(arr,diff));
    }

    private static int countSubsets(int[] arr,int diff){
        int sum = 0;
        for(int a: arr){
            sum+=a;
        }
        int s = (diff+sum)/2;
        return countSubsetSum(arr,s);
    }

    private static int countSubsetSum(int[] arr,int sum){

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
                    t[i][j] = t[i-1][j] + t[i-1][j-arr[i-1]];
                }else{
                    t[i][j] = t[i-1][j];
                }
            }
        }
        return t[arr.length][sum];
    }
}

package DynamicProgramming;

public class minimumSubsetSumDiff {
    public static void main(String[] args) {

        int[] arr = {1,2,7};

        System.out.println(findMinSubsetSumDiff(arr));
    }

    private static int findMinSubsetSumDiff(int[] arr){
        int range = 0;
        for(int a: arr)
            range+=a;

        boolean[] lastRow = subsetSum(arr,range);

        int min = Integer.MAX_VALUE;
        for(int i=0;i<(lastRow.length+1)/2;i++){
            if(lastRow[i])
                min = Math.min(min,range-2*i);
        }
        return min;
    }

    private static boolean[] subsetSum(int[] arr,int sum){

        boolean[][] t = new boolean[arr.length+1][sum+1];
        for(int i=0;i<=arr.length;i++){
            for(int j=0;j<=sum;j++){
                if(i==0){
                    t[i][j] = false;
                }
                if(j==0){
                    t[i][j] = true;
                }
            }
        }

        for(int i=1;i<=arr.length;i++){
            for(int j=1;j<=sum;j++){
                if(arr[i-1]<=j){
                    t[i][j] = t[i-1][j] || t[i-1][j-arr[i-1]];
                }else{
                    t[i][j] = t[i-1][j];
                }
            }
        }

        return t[arr.length];
    }
}

package DynamicProgramming;

public class SubsetSumPartition {
    public static void main(String[] args) {

        int[] arr = {2, 3, 7, 8, 10};
        int sum = 11;

        int n = arr.length;
        System.out.println(isSubsetSumPossibleRecursive(arr, sum, n));

        t = new Boolean[n + 1][sum + 1];
        System.out.println(isSubsetSumPossibleTopDown(arr, sum, n));

        System.out.println(isSubsetSumPossibleBottomUp(arr,sum,n));

    }

    private static boolean isSubsetSumPossibleRecursive(int[] arr, int sum, int n) {

        if (sum == 0) {
            return true;
        }

        if (n == 0) {
            return false;
        }

        if (arr[n - 1] <= sum) {
            return isSubsetSumPossibleRecursive(arr, sum - arr[n - 1], n - 1) || isSubsetSumPossibleRecursive(arr, sum, n - 1);
        } else {
            return isSubsetSumPossibleRecursive(arr, sum, n - 1);
        }

    }

    static Boolean[][] t;

    private static boolean isSubsetSumPossibleTopDown(int[] arr, int sum, int n) {

        if (sum == 0)
            return true;

        if (n == 0)
            return false;

        if (t[n][sum]!=null)
            return t[n][sum];

        if (arr[n - 1] <= sum) {
            return isSubsetSumPossibleTopDown(arr, sum - arr[n - 1], n - 1) || isSubsetSumPossibleTopDown(arr, sum, n - 1);
        } else {
            return isSubsetSumPossibleTopDown(arr, sum, n - 1);
        }
    }

    private static boolean isSubsetSumPossibleBottomUp(int[] arr, int sum,int n){

        boolean[][] t = new boolean[n+1][sum+1];

        for(int i=0;i<=n;i++){
            for(int j=0;j<=sum;j++){
                if(i==0){
                    t[i][j] = false;
                }
                if(j==0){
                    t[i][j] = true;
                }
            }
        }

        for(int i=1;i<=n;i++){
            for(int j=1;j<=sum;j++){
                if (arr[i - 1] <= j) {
                    t[i][j] = t[i-1][j-arr[i-1]] || t[i-1][j];
                } else {
                    t[i][j] = t[i-1][j];
                }
            }
        }

        //Just for checking out stuff in the matrix :/
        for(int i=0;i<t.length;i++){
            for(int j=0;j<t[0].length;j++){
                System.out.print(t[i][j]+"\t");
            }
            System.out.println();
        }
        return t[n][sum];
    }

}

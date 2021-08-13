package DynamicProgramming;

public class EqualSumPartition {
    public static void main(String[] args) {

        int[] arr = {1, 5, 11, 5};

        System.out.println(isEqualPartitionPossible(arr));

    }

    private static boolean isEqualPartitionPossible(int[] arr) {
        int sum = 0;
        for (int a : arr)
            sum += a;
        if (sum % 2 != 0) {
            return false;
        } else {
            return subsetSum(arr, sum / 2);
        }
    }

    private static boolean subsetSum(int[] arr, int sum) {

        Boolean[][] t = new Boolean[arr.length + 1][sum + 1];

        for (int i = 0; i <= arr.length; i++) {
            for (int j = 0; j <= sum; j++) {
                if (i == 0) {
                    t[i][j] = false;
                }
                if (j == 0) {
                    t[i][j] = true;
                }
            }
        }

        for(int i=1;i<=arr.length;i++){
            for(int j=1;j<=sum;j++){
                if(arr[i-1] <= j){
                    t[i][j] = t[i-1][j] || t[i-1][j-arr[i-1]];
                }else{
                    t[i][j] = t[i-1][j];
                }
            }
        }

        return t[arr.length][sum];
    }
}

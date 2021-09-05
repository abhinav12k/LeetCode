package DynamicProgramming;

public class MCM {
    public static void main(String[] args) {

        int[] arr = {40, 20, 30, 10, 30};
        System.out.println(getMinCostOfProduct(arr, 1, arr.length - 1));

        t = new int[arr.length + 1][arr.length + 1];
        System.out.println(getMinCostOfProductBottomUp(arr, 1, arr.length - 1));

        System.out.println(getMinCostOfProductTopDown(arr));
    }

    private static int getMinCostOfProduct(int[] arr, int i, int j) {

        if (i >= j) {
            return 0;
        }

        int ans = Integer.MAX_VALUE;
        for (int k = i; k <= j - 1; k++) {
            int temp_ans = getMinCostOfProduct(arr, i, k) + getMinCostOfProduct(arr, k + 1, j) + arr[i - 1] * arr[k] * arr[j];
            ans = Math.min(ans, temp_ans);
        }

        return ans;
    }

    static int[][] t;

    private static int getMinCostOfProductBottomUp(int[] arr, int i, int j) {
        if (i >= j) {
            return 0;
        }

        if (t[i][j] != 0) {
            return t[i][j];
        }

        int ans = Integer.MAX_VALUE;
        for (int k = i; k <= j - 1; k++) {
            int temp_ans = getMinCostOfProductBottomUp(arr, i, k) + getMinCostOfProductBottomUp(arr, k + 1, j)
                    + arr[i - 1] * arr[k] * arr[j];
            ans = Math.min(ans, temp_ans);
        }
        return t[i][j] = ans;
    }

    private static int getMinCostOfProductTopDown(int[] arr) {

        int n = arr.length;
        int[][] t = new int[n+1][n+1];

        for(int i=1;i<=n;i++){
            t[i][i] = 0;
        }

        int j =0;
        int ans;
        for(int d=1;d<n-1;d++){
            for(int i=1;i<n-d;i++){
                j = i+d;
                ans = Integer.MAX_VALUE;
                for (int k = i; k <= j - 1; k++) {
                    int temp_ans = t[i][k] + t[k + 1][j] + arr[i - 1] * arr[k] * arr[j];
                    ans = Math.min(ans, temp_ans);
                }
                t[i][j] = ans;
            }
        }

        return t[n][n-1];
    }

}

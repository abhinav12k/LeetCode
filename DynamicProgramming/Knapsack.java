package DynamicProgramming;

public class Knapsack {
    public static void main(String[] args) {
        int[] wt = {1, 3, 4, 5};
        int[] val = {1, 4, 5, 7};

        int max_wt = 7;
        int n = wt.length;

        System.out.println(getMaxProfitRecursive(wt, val, max_wt, n));

        t = new int[n + 1][max_wt + 1];
        System.out.println(getMaxProfitTopDown(wt, val, max_wt, n));

        System.out.println(getMaxProfitBottomUp(wt, val, max_wt, n));
    }

    private static int getMaxProfitRecursive(int[] wt, int[] val, int max_wt, int n) {

        if (n == 0 || max_wt == 0) {
            return 0;
        }

        if (wt[n - 1] > max_wt) {
            return getMaxProfitRecursive(wt, val, max_wt, n - 1);
        } else {
            return Math.max(val[n - 1] + getMaxProfitRecursive(wt, val, max_wt - wt[n - 1], n - 1),
                    getMaxProfitRecursive(wt, val, max_wt, n - 1));
        }

    }


    static int[][] t;

    private static int getMaxProfitTopDown(int[] wt, int[] val, int max_wt, int n) {

        if (n == 0 || max_wt == 0)
            return 0;

        if (t[n][max_wt] != 0) {
            return t[n][max_wt];
        }

        if (wt[n - 1] > max_wt) {
            return getMaxProfitTopDown(wt, val, max_wt, n - 1);
        } else {
            return Math.max(val[n - 1] + getMaxProfitTopDown(wt, val, max_wt - wt[n - 1], n - 1),
                    getMaxProfitTopDown(wt, val, max_wt, n - 1));
        }

    }

    private static int getMaxProfitBottomUp(int[] wt, int[] val, int max_wt, int n) {

        int[][] t = new int[n + 1][max_wt + 1];

        for (int i = 0; i <= n; i++)
            for (int j = 0; j <= max_wt; j++)
                if (i == 0 || j == 0)
                    t[i][j] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= max_wt; j++) {
                if (wt[i - 1] > j) {
                    t[i][j] = t[i - 1][j];
                } else {
                    t[i][j] = Math.max(val[i - 1] + t[i - 1][j - wt[i - 1]], t[i - 1][j]);
                }
            }
        }

        return t[n][max_wt];
    }

}

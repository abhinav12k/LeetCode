package DynamicProgramming;

import java.util.Arrays;

public class EditDistance {
    public static void main(String[] args) {

        String str1 = "monday";
        String str2 = "sunday";

        System.out.println(convertString(str1, str2, str1.length(), str2.length()));

        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
        for (int[] d : dp)
            Arrays.fill(d, -1);
        System.out.println(convertStringBottomUp(str1, str2, str1.length(), str2.length(), dp));
        System.out.println(convertStringTopDown(str1, str2, str1.length(), str2.length()));
    }

    public static int convertString(String str1, String str2, int m, int n) {

        if (m == 0)
            return n;

        if (n == 0)
            return m;

        if (str1.charAt(m - 1) == str2.charAt(n - 1))
            return convertString(str1, str2, m - 1, n - 1);
        else {
            return 1 +
                    Math.min(convertString(str1, str2, m, n - 1), //insert
                            Math.min(
                                    convertString(str1, str2, m - 1, n - 1), //replace
                                    convertString(str1, str2, m - 1, n) //remove
                            )
                    );
        }
    }

    public static int convertStringBottomUp(String str1, String str2, int m, int n, int[][] dp) {

        if (m == 0)
            return n;

        if (n == 0)
            return m;

        if (dp[m][n] != -1)
            return dp[m][n];

        if (str1.charAt(m - 1) == str2.charAt(n - 1))
            return convertString(str1, str2, m - 1, n - 1);
        else {
            int insert = 0;
            if (dp[m][n - 1] != -1) {
                insert = dp[m][n - 1];
            } else {
                insert = convertStringBottomUp(str1, str2, m, n - 1, dp);
            }
            int replace = 0;
            if (dp[m - 1][n - 1] != -1) {
                replace = dp[m - 1][n - 1];
            } else {
                replace = convertStringBottomUp(str1, str2, m - 1, n - 1, dp);
            }
            int remove = 0;
            if (dp[m - 1][n] != -1) {
                remove = dp[m - 1][n];
            } else {
                remove = convertStringBottomUp(str1, str2, m - 1, n, dp);
            }
            return 1 + Math.min(insert, Math.min(remove, replace));
        }

    }

    public static int convertStringTopDown(String str1, String str2, int m, int n) {

        if (m == 0)
            return n;

        if (n == 0)
            return m;

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {

                if (i == 0) {
                    dp[i][j] = j;
                } else if (j == 0) {
                    dp[i][j] = i;
                } else if (str1.charAt(i-1) == str2.charAt(j-1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i][j - 1], Math.min(dp[i - 1][j - 1], dp[i - 1][j]));
                }

            }
        }
        return dp[m][n];
    }

}

package DynamicProgramming;

import java.util.Arrays;

public class PalindromePartitioning {

    public static void main(String[] args) {

        String str = "abhinav";
        t = new int[str.length()][str.length()];
        for (int[] row : t)
            Arrays.fill(row, -1);
        System.out.println(getMinPartitions(str, 0, str.length() - 1));
    }

    static int[][] t;

    private static int getMinPartitions(String str, int i, int j) {

        if (i > j)
            return 0;

        if (isPalindrome(str, i, j)) {
            return 0;
        }

        if (t[i][j] != -1) {
            return t[i][j];
        }

        int ans = Integer.MAX_VALUE;
        for (int k = i; k <= j - 1; k++) {
            int curr = getMinPartitions(str, i, k) + getMinPartitions(str, k + 1, j) + 1;
            ans = Math.min(ans, curr);
        }
        t[i][j] = ans;
        return ans;
    }

    private static boolean isPalindrome(String str, int i, int j) {

        while (i <= j) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

}

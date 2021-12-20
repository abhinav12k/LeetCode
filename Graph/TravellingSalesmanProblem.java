package Graph;

import java.util.Arrays;

public class TravellingSalesmanProblem {

    static int tcp(int[][] dist, int setOfCities, int city, int n, int[][] dp) {

        if (setOfCities == (1 << n) - 1) {
            return dist[city][0];
        }

        if (dp[setOfCities][city] != -1)
            return dp[setOfCities][city];

        int ans = Integer.MAX_VALUE;
        for (int choice = 0; choice < n; choice++) {

            if ((setOfCities & (1 << choice)) == 0) {
                int subProblem = dist[city][choice] + tcp(dist, (setOfCities | (1 << choice)), choice, n, dp);
                ans = Math.min(ans, subProblem);
            }

        }
        return ans;
    }

    public static void main(String[] args) {

        int[][] dist = {{0, 20, 42, 25},
                {20, 0, 30, 34},
                {42, 30, 0, 10},
                {25, 34, 10, 0}};

        int n = dist.length;
        int[][] dp = new int[1 << n][n];
        for (int i = 0; i < 1 << n; i++)
            Arrays.fill(dp[i], -1);

        System.out.println(tcp(dist, 1, 0, n, dp));

    }

}

package DynamicProgramming;

import java.util.Arrays;

public class EggDropProblem {
    public static void main(String[] args) {

        int e = 2, f = 6;
        System.out.println(getMinWaysToFindThresholdFloor(e, f));

        dp = new int[e + 1][f + 1];
        for (int[] d : dp)
            Arrays.fill(d, -1);
        System.out.println(getMinWaysBottomUp(e, f));

        System.out.println(getMinWaysTopDown(e, f));

        for (int[] d : dp)
            Arrays.fill(d, -1);
        System.out.println(getMinWaysBinarySearchBottomUp(e, f, dp));

        System.out.println(getMinWaysBinarySearchTopDown(e,f));
    }

    public static int getMinWaysToFindThresholdFloor(int e, int f) {

        if (f == 0 || f == 1)
            return f;

        if (e == 1)
            return f;

        int min = Integer.MAX_VALUE;
        for (int k = 1; k <= f; k++) {
            int temp = 1 + Math.max(getMinWaysToFindThresholdFloor(e - 1, k - 1), getMinWaysToFindThresholdFloor(e, f - k));
            min = Math.min(min, temp);
        }
        return min;
    }

    static int[][] dp;

    public static int getMinWaysBottomUp(int e, int f) {

        if (e == 1) {
            return f;
        }

        if (f == 0 || f == 1) {
            return f;
        }

        if (dp[e][f] != -1) {
            return dp[e][f];
        }

        int ans = Integer.MAX_VALUE;
        for (int k = 1; k <= f; k++) {
            int temp = 1 + Math.max(getMinWaysBottomUp(e - 1, k - 1), getMinWaysBottomUp(e, f - k));
            ans = Math.min(ans, temp);
        }
        dp[e][f] = ans;
        return ans;
    }

    public static int getMinWaysTopDown(int e, int f) {

        if (e == 1)
            return f;

        if (f == 0 || f == 1)
            return f;

        int[][] dp = new int[e + 1][f + 1];

        for (int i = 0; i <= e; i++) {
            dp[i][0] = 0;
            dp[i][1] = 1;
        }

        for (int i = 0; i <= f; i++) {
            dp[0][i] = 0;
            dp[1][i] = i;
        }

        for (int i = 2; i <= e; i++) {
            for (int j = 2; j <= f; j++) {

                int min = Integer.MAX_VALUE;
                for (int mj = j - 1, pj = 0; mj >= 0 && pj < j; mj--, pj++) {
                    int val = 1 + Math.max(dp[i][mj], dp[i-1][pj]);
                    min = Math.min(min, val);
                }
                dp[i][j] = min;
                
            }
        }
        return dp[e][f];
    }

    public static int getMinWaysBinarySearchBottomUp(int e, int f, int[][] dp) {

        if (f == 0 || f == 1)
            return f;

        if (e == 1)
            return f;

        if (dp[e][f] != -1)
            return dp[e][f];

        int l = 1, h = f;
        int ans = Integer.MAX_VALUE;

        while (l <= h) {
            int mid = (l + h) / 2;
            int left = getMinWaysBinarySearchBottomUp(e - 1, mid - 1, dp);
            int right = getMinWaysBinarySearchBottomUp(e, f - mid, dp);

            if (left < right) {
                l = mid + 1;
            } else {
                h = mid - 1;
            }

            int val = Math.max(left, right) + 1;
            ans = Math.min(ans, val);
        }
        dp[e][f] = ans;
        return ans;
    }

    public static int getMinWaysBinarySearchTopDown(int e,int f){

        if(e==1)
            return f;
        if(f==0 || f==1)
            return f;

        int[][] t = new int[e+1][f+1];
        for (int i = 0; i <= e; i++) {
            t[i][0] = 0;
            t[i][1] = 1;
        }

        for (int i = 0; i <= f; i++) {
            t[0][i] = 0;
            t[1][i] = i;
        }

        for (int i = 2; i <= e; i++) {
            for (int j = 2; j <= f; j++) {

                int min = Integer.MAX_VALUE;
                int l = 1,r=j,temp=0;
                while(l<=r){
                    int mid = l+(r-l)/2;
                    int left = t[i-1][mid-1];
                    int right = t[i][j-mid];

                    temp = 1 + Math.max(left,right);
                    if(left<right)
                        l = mid+1;
                    else
                        r = mid-1;

                    min = Math.min(min,temp);
                }
                t[i][j] = min;
            }
        }
        return t[e][f];

    }

}

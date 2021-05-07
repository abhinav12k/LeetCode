package HackWithInfyGuidedPath.KadaneAlgo;

public class maxSumRect {

    public static void main(String[] args) {

        /*Problem Link - https://www.codingninjas.com/codestudio/guided-paths/hack-with-infy-preparation-path/content/125342/offering/1468968*/

    }

    public static int maxSumRectangle(int[][] arr, int n, int m) {
        int maxSum = Integer.MIN_VALUE;
        for (int startCol = 0; startCol < m; startCol++) {
            int[] pre = new int[n];
            for (int endCol = startCol; endCol < n; endCol++) {
                int curr = 0;
                for (int r = 0; r < n; r++) {
                    pre[r] += arr[r][endCol];
                    curr += pre[r];
                    maxSum = Math.max(maxSum, curr);
                    if (curr < 0)
                        curr = 0;
                }
            }
        }
        return maxSum;
    }

}

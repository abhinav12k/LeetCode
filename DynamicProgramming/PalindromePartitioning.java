package DynamicProgramming;

import java.util.Arrays;

public class PalindromePartitioning {

    public static void main(String[] args) {

        String str = "abhinav";
        t = new int[str.length()][str.length()];
        for (int[] row : t)
            Arrays.fill(row, -1);
        System.out.println(getMinPartitions(str, 0, str.length() - 1));
        System.out.println(getMinPartitionOptimized(str, 0, str.length() - 1));
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

    private static int getMinPartitionOptimized(String str,int i,int j){

        if(i>j)
            return 0;

        if(isPalindrome(str,i,j))
            return 0;

        if(t[i][j]!=-1)
            return t[i][j];

        int ans = Integer.MAX_VALUE;
        for(int k=i;k<=j-1;k++){
            int left = 0;
            if(t[i][k]!=-1)
                left = t[i][k];
            else
                left = getMinPartitionOptimized(str,i,k);
            int right = 0;
            if(t[k+1][j]!=-1)
                right =  t[k+1][j];
            else
                right = getMinPartitionOptimized(str,k+1,j);
            ans = Math.min(ans, left+right+1);
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

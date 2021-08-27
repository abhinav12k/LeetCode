package DynamicProgramming;

public class LCS {

    public static void main(String[] args) {

        String X = "abcdgh";
        String Y = "abedfhr";
        System.out.println(longestCommonSubsequence(X,Y,X.length(),Y.length()));

        t = new int[X.length()+1][Y.length()+1];
        System.out.println(lcs_topDown(X,Y,X.length(),Y.length()));
        System.out.println(lcs_bottomUp(X,Y));
    }

    private static int longestCommonSubsequence(String X, String Y, int m, int n) {

        if (m == 0 || n == 0) {
            return 0;
        }

        if (X.charAt(m - 1) == Y.charAt(n - 1)) {
            return 1 + longestCommonSubsequence(X, Y, m - 1, n - 1);
        } else {
            return Math.max(longestCommonSubsequence(X, Y, m - 1, n), longestCommonSubsequence(X, Y, m, n - 1));
        }

    }

    static int[][] t;
    private static int lcs_topDown(String X,String Y,int m,int n){
        if(m==0||n==0){
            return 0;
        }
        if(t[m][n]!=0){
            return t[m][n];
        }
        if(X.charAt(m-1)==Y.charAt(n-1)){
            t[m][n] = 1+lcs_topDown(X,Y,m-1,n-1);
        }else{
            t[m][n] = Math.max(lcs_topDown(X,Y,m-1,n),lcs_topDown(X,Y,m,n-1));
        }
        return t[m][n];
    }

    private static int lcs_bottomUp(String X,String Y){

        int[][] t= new int[X.length()+1][Y.length()+1];
        for(int i=1;i<=X.length();i++){
            for(int j=1;j<=Y.length();j++){
                if(X.charAt(i-1)==Y.charAt(j-1)){
                    t[i][j] = 1+t[i-1][j-1];
                }else{
                    t[i][j] = Math.max(t[i-1][j],t[i][j-1]);
                }
            }
        }
        return t[X.length()][Y.length()];
    }

}

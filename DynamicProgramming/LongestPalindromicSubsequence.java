package DynamicProgramming;

public class LongestPalindromicSubsequence {
    public static void main(String[] args) {
        String X = "agbcba";
        System.out.println(lps(X));
    }

    private static int lps(String X){
        String Y = reverse(X);
        int[][] t = new int[X.length()+1][Y.length()+1];
        for(int i=1;i<=X.length();i++){
            for(int j=1;j<=Y.length();j++){
                if(X.charAt(i-1) == Y.charAt(j-1)){
                    t[i][j] = 1+t[i-1][j-1];
                }else{
                    t[i][j] = Math.max(t[i-1][j],t[i][j-1]);
                }
            }
        }
        return t[X.length()][Y.length()];
    }

    private static String reverse(String X){
        if(X.length()==1){
            return X;
        }
        return reverse(X.substring(1))+ X.charAt(0);
    }

}

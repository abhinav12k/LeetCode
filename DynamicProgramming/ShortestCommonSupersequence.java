package DynamicProgramming;

public class ShortestCommonSupersequence {

    public static void main(String[] args) {
        String X = "geek";
        String Y = "eke";
        System.out.println(SCSS(X,Y));
    }

    private static int SCSS(String X,String Y){

        int m = X.length();
        int n = Y.length();

        int[][] t = new int[m+1][n+1];
        for(int i=1;i<=X.length();i++){
            for(int j=1;j<=Y.length();j++){
                if(X.charAt(i-1)==Y.charAt(j-1)){
                    t[i][j] = 1 + t[i-1][j-1];
                }else{
                    t[i][j] = Math.max(t[i-1][j],t[i][j-1]);
                }
            }
        }

        return X.length() + Y.length() - t[m][n];
    }

}
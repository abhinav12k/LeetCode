package DynamicProgramming;

public class LongestCommonSubstring {

    public static void main(String[] args) {
        String X = "abcde";
        String Y = "abfde";
        System.out.println(LCSubsequence(X,Y));
    }

    private static int LCSubsequence(String X,String Y){
        int[][] t = new int[X.length()+1][Y.length()+1];
        for(int i=1;i<=X.length();i++){
            for(int j=1;j<=Y.length();j++){
                if(X.charAt(i-1)==Y.charAt(j-1)){
                    t[i][j] = 1 + t[i-1][j-1];
                }else{
                    t[i][j] = 0;
                }
            }
        }
        return t[X.length()][Y.length()];
    }

}

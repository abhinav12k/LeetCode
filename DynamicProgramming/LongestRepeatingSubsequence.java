package DynamicProgramming;

public class LongestRepeatingSubsequence {
    public static void main(String[] args) {
        System.out.println(LRSS("AABEBCDD"));
    }

    private static int LRSS(String str){
        int m = str.length();
        int[][] t = new int[m+1][m+1];
        for(int i=1;i<=m;i++){
            for(int j=1;j<=m;j++){
                if(str.charAt(i-1)==str.charAt(j-1) && i != j){
                    t[i][j] = 1 + t[i-1][j-1];
                }else{
                    t[i][j] = Math.max(t[i-1][j],t[i][j-1]);
                }
            }
        }

        return t[m][m];

    }

}

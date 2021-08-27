package DynamicProgramming;

public class MinNofInsertionDeletions {

    public static void main(String[] args) {
        String X = "ap";
        String Y = "pea";
        int[] ans = minDeletionsAndInsertions(X,Y);
        System.out.println("Differences: "+ans[0]+"\nInsertions: "+ans[1]);
    }

    private static int[] minDeletionsAndInsertions(String X,String Y){

        int[][] t = new int[X.length()+1][Y.length()+1];

        for(int i=1;i<=X.length();i++){
            for(int j=1;j<=Y.length();j++){
                if(X.charAt(i-1)==Y.charAt(j-1)){
                    t[i][j] = 1 + t[i-1][j-1];
                }else{
                    t[i][j] = Math.max(t[i-1][j],t[i][j-1]);
                }
            }
        }

        int[] ans = new int[2];
        ans[0] = X.length()-t[X.length()][Y.length()];  //deletions
        ans[1] = Y.length()-t[X.length()][Y.length()];  //insertions

        return ans;
    }

}

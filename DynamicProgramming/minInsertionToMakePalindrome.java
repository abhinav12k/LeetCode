package DynamicProgramming;

public class minInsertionToMakePalindrome {

    public static void main(String[] args) {

        String ques = "aebcbda";
        System.out.println(getMinInsertions(ques));

    }

    private static int getMinInsertions(String ques){
        return ques.length() - LCS(ques,rev(ques));
    }

    private static int LCS(String a,String b){

        int[][] t = new int[a.length()+1][b.length()+1];

        for(int i=1;i<=a.length();i++){
            for(int j=1;j<=b.length();j++){
                if(a.charAt(i-1)==b.charAt(j-1)){
                    t[i][j] = 1 + t[i-1][j-1];
                }else{
                    t[i][j] = Math.max(t[i-1][j],t[i][j-1]);
                }
            }
        }
        return t[a.length()][b.length()];
    }

    private static String rev(String ques){
        StringBuilder sb = new StringBuilder(ques);
        return sb.reverse().toString();
    }

}

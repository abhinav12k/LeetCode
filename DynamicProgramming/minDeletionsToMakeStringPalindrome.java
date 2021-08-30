package DynamicProgramming;

public class minDeletionsToMakeStringPalindrome {

    public static void main(String[] args) {
        String str = "agbcba";
        System.out.println(getMinDel(str));
    }

    private static int getMinDel(String str){

        String r_str = reverse(str);

        int[][] t = new int[str.length()+1][str.length()+1];
        for(int i=1;i<=str.length();i++){
            for(int j=1;j<=r_str.length();j++){
                if(str.charAt(i-1)==r_str.charAt(j-1)){
                    t[i][j] = 1 + t[i-1][j-1];
                }else{
                    t[i][j] = Math.max(t[i-1][j],t[i][j-1]);
                }
            }
        }

        int lcs = t[str.length()][r_str.length()];
        return str.length() - lcs;
    }

    private static String reverse(String str){
        if(str.length()==1){
            return  str;
        }
        return reverse(str.substring(1)) + str.charAt(0);
    }

}

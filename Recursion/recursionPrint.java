package Recursion;

public class recursionPrint {

    public static void main(String[] args) {

//        getSS("abc","");
//        printKPC("2345","");
//        System.out.println(printPermutation("abcd",""));
//        printPermutation2("aabc","");
//        validParenthesis(3,0,0,"");
//        System.out.println("****************");
//        permutationWithNoDuplicates("aabc","");
//        System.out.println("****************");
//        permutationWithNoDuplicates2("aabc","");
//        System.out.println(printBoardPath(0,10,""));
//        mazePath(0,0,3,3,"");
//        System.out.println(lexicoCounting(0,100));
        System.out.println(isPalindrome("mississippi"));
        palindromePartitioning("mississippi","");
        lowerUPPER("ab23z","");
    }

    //subsequence
    private static void getSS(String str,String ans){

        if(str.length()==0){
            System.out.println(ans);
            return;
        }

        getSS(str.substring(1),ans+str.charAt(0));  //yes
        getSS(str.substring(1),ans);    //no
    }

    private static void printKPC(String str,String ans){
        if(str.length()==0){
            System.out.println(ans);
            return;
        }

        char ch = str.charAt(0);
        String pattern = recursionGet.getStrings(ch);

        for(char c: pattern.toCharArray()){
            printKPC(str.substring(1),ans+c);
        }

    }

    private static int printPermutation(String str,String ans){

        if(str.length()==0){
            System.out.println(ans);
            return 1;
        }

        char ch =  str.charAt(0);
        String ros = str.substring(1);

        int ct=0;
        for(int i=0;i<=ans.length();i++) {
            ct+=printPermutation(ros, ans.substring(0,i)+ch+ans.substring(i));
        }
        return ct;
    }

    private static void printPermutation2(String str,String ans){

        if(str.length()==0){
            System.out.println(ans);
            return;
        }

        for(int i=0;i<str.length();i++){

            char ch = str.charAt(i);
            String ros = str.substring(0,i)+str.substring(i+1);
            printPermutation2(ros,ans+ch);

        }

    }

    private static void validParenthesis(int n, int open,int close, String ans){

        if(open == n && close == n){
            System.out.println(ans);
            return;
        }

        if(open > n || close > n || close > open)
            return;

        validParenthesis(n,open,close+1,ans+")");
        validParenthesis(n,open+1,close,ans+"(");
    }

    private static void permutationWithNoDuplicates(String ques,String ans){

        if(ques.length()==0){
            System.out.println(ans);
            return;
        }

        boolean[] visited = new boolean[256];


        for(int i=0;i<ques.length();i++) {

            char ch = ques.charAt(i);
            String ros = ques.substring(0,i)+ques.substring(i+1);

            if(visited[ch])
                continue;

            visited[ch] = true;

            permutationWithNoDuplicates(ros, ans+ch);
        }
    }

    private static void permutationWithNoDuplicates2(String ques,String ans){

        if(ques.length()==0){
            System.out.println(ans);
            return;
        }

        for(int i=0;i<ques.length();i++){

            char ch = ques.charAt(i);
            String ros = ques.substring(0,i)+ques.substring(i+1);

            int ct =0;
            for(int j= i+1;j<ques.length();j++){

                if(ques.charAt(j)==ch)
                    ct++;

            }

            if(ct==0)
                permutationWithNoDuplicates2(ros,ans+ch);
        }

    }

    private static int printBoardPath(int start,int end,String ans){

        if(start==end){
            System.out.println(ans);
            return 1;
        }

        if(start>end)
            return 0;

        int ct=0;

        for(int dice=1;dice<=6;dice++){
            ct+=printBoardPath(start+dice,end,ans+dice);
        }
        return ct;
    }

    private static int mazePath(int cr,int cc,int fr,int fc,String ans){

        if(cr==fr && cc==fc){
            System.out.println(ans);
            return 1;
        }

        if(cr>fr || cc>fc){
            return 0;
        }

        int ct =0;
        //horizontal
        ct+=mazePath(cr,cc+1,fr,fc,"H"+ans);
        ct+=mazePath(cr+1,cc,fr,fc,"V"+ans);

        return ct;
    }

    private static int lexicoCounting(int curr,int end){

        if(curr > end){
            return 0;
        }

        System.out.println(curr);

        int ct = 0;

        int i = 0;
        if(curr==0)
            i=1;

        for(;i<=9;i++)
            ct+=lexicoCounting(curr*10+i,end);

        return ct;
    }

    private static boolean isPalindrome(String str){

        if(str.length()==1 || str.length() == 0){
            return true;
        }

        char ch = str.charAt(0);
        char lst = str.charAt(str.length()-1);

        return ch == lst && isPalindrome(str.substring(1, str.length() - 1));
    }

    private static void palindromePartitioning(String str,String ans){

        if(str.length()==0){
            System.out.println(ans);
            return;
        }

        for(int i=1;i<=str.length();i++){

            String part = str.substring(0,i);
            String roq = str.substring(i);

            if(isPalindrome(part))
                palindromePartitioning(roq,ans+part+" ");

        }

    }

    private static void lowerUPPER(String ques,String ans){

        if(ques.length()==0){
            System.out.println(ans);
            return;
        }

        char ch = ques.charAt(0);
        String ros = ques.substring(1);

        if(Character.isDigit(ch)){
            lowerUPPER(ros,ans+ch);
        }else{
            lowerUPPER(ros,ans+Character.toUpperCase(ch));
            lowerUPPER(ros,ans+Character.toLowerCase(ch));
        }

    }

}

package Recursion;

public class subsets_subsequences {

    public static void main(String[] args) {

        printSubsequences("abc","");

    }

    private static void printSubsequences(String ques,String ans){

        if(ques.length()==0){
            System.out.println(ans);
            return;
        }

        char ch = ques.charAt(0);
        printSubsequences(ques.substring(1),ans+ch);
        printSubsequences(ques.substring(1),ans);

    }

}

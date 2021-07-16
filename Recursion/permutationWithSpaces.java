package Recursion;

public class permutationWithSpaces {

    public static void main(String[] args) {
        printPermutationWithSpaces("ABC");
    }

    private static void printPermutationWithSpaces(String ques){
        solve(ques.substring(1),""+ques.charAt(0));
    }

    private static void solve(String ques,String ans){

        if(ques.length()==0){
            System.out.println(ans);
            return;
        }

        char ch = ques.charAt(0);
        solve(ques.substring(1),ans+" "+ch);
        solve(ques.substring(1),ans+ch);
    }

}

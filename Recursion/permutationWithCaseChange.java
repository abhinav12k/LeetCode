package Recursion;

public class permutationWithCaseChange {

    public static void main(String[] args) {
        printPermutationWithCaseChange("Ab1C","");
    }

    private static void printPermutationWithCaseChange(String ques,String ans){

        if(ques.length()==0) {
            System.out.println(ans);
            return;
        }

        char ch = ques.charAt(0);
        if(!Character.isDigit(ch)) {
            printPermutationWithCaseChange(ques.substring(1), ans + Character.toLowerCase(ch));
            printPermutationWithCaseChange(ques.substring(1), ans + Character.toUpperCase(ch));
        }else
            printPermutationWithCaseChange(ques.substring(1),ans+ch);
    }
}

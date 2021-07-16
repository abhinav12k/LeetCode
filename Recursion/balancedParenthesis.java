package Recursion;

public class balancedParenthesis {
    public static void main(String[] args) {
        printBalancedParenthesis(2,0,0,"");
    }

    private static void printBalancedParenthesis(int n,int open,int close,String ans){

        if(open==n && close == n){
            System.out.println(ans);
            return;
        }

        if(open>n || close> n || open < close)
            return;

        printBalancedParenthesis(n,open+1,close,ans+"(");
        printBalancedParenthesis(n,open,close+1,ans+")");

    }

}

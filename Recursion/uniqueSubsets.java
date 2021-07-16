package Recursion;

import java.util.HashMap;
import java.util.HashSet;

public class uniqueSubsets {

    public static void main(String[] args) {
        printUniqueSubsets("aab","");
    }

    static HashSet<String> set = new HashSet<>();
    private static void printUniqueSubsets(String ques,String ans){

        if(ques.length()==0){
            if(!set.contains(ans))
                System.out.println(ans);
            set.add(ans);
            return;
        }

        char ch = ques.charAt(0);

        printUniqueSubsets(ques.substring(1),ans+ch);
        printUniqueSubsets(ques.substring(1),ans);

    }

}

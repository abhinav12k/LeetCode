package Recursion;

public class recursionPrint {

    public static void main(String[] args) {

//        getSS("abc","");
//        printKPC("2345","");
        System.out.println(printPermutation("abcd",""));
        System.out.println("****************");
        printPermutation2("abcd","");
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

}

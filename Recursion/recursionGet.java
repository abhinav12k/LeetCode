package Recursion;

import java.util.ArrayList;
import java.util.List;

public class recursionGet {

    public static void main(String[] args) {

        System.out.println(getSS("abc"));
        System.out.println(getSSASCII("abc"));
        System.out.println(getKPC("23"));
    }

    private static ArrayList<String> getSS(String str){

        if(str==null || str.length()==0){
            ArrayList<String> br = new ArrayList<>();
            br.add("");
            return br;
        }

        char ch = str.charAt(0);
        String ros = str.substring(1);

        ArrayList<String> rr = getSS(ros);

        ArrayList<String> mr = new ArrayList<>();
        for(String s: rr){
            mr.add(s);  //no
            mr.add(ch+s);   //yes
        }

        return mr;
    }

    private static ArrayList<String> getSSASCII(String str){

        if(str == null || str.length() == 0){
            ArrayList<String> br = new ArrayList<>();
            br.add("");
            return br;
        }

        char ch = str.charAt(0);
        String ros = str.substring(1);

        ArrayList<String> rr = getSSASCII(ros);

        ArrayList<String> mr = new ArrayList<>();
        for(String s: rr){
            mr.add(s);  //no
            mr.add(ch+s);    //yes
            mr.add((int)ch + s);    //ascii
        }

        return mr;
    }

    private static List<String> getKPC(String digits){

        if(digits.length() == 0){
            ArrayList<String> br = new ArrayList<>();
            br.add("");
            return br;
        }

        char ch = digits.charAt(0);
        String ros = digits.substring(1);

        List<String> rr = getKPC(ros);
        ArrayList<String> mr = new ArrayList<>();

        String pattern = getStrings(ch);

        for(char c: pattern.toCharArray()){
            for(String s: rr){
                mr.add(c+s);
            }
        }
        return mr;
    }

    private static String getStrings(char c){

        switch (c){

            case '1': return ".";
            case '2': return "abc";
            case '3': return "def";
            case '4': return "ghi";
            case '5': return "jkl";
            case '6': return "mno";
            case '7': return "pqrs";
            case '8': return "tuv";
            case '9': return "wxyz";

            default: return "";

        }

    }

}

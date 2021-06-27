package Recursion;

import java.util.ArrayList;
import java.util.List;

public class recursionGet {

    public static void main(String[] args) {

        System.out.println(getSS("abc"));
        System.out.println(getSSASCII("abc"));
        System.out.println(getKPC("23"));
        System.out.println(coinToss(3));
        System.out.println(permutation("abc"));
        System.out.println(mazePath(0, 0, 2, 2));
        System.out.println(mazePathDiagonal(0, 0, 2, 2));
        System.out.println(mazePathDiagMM(0, 0, 2, 2));
        System.out.println(getBoardPath(0,10));
    }

    private static ArrayList<String> getSS(String str) {

        if (str == null || str.length() == 0) {
            ArrayList<String> br = new ArrayList<>();
            br.add("");
            return br;
        }

        char ch = str.charAt(0);
        String ros = str.substring(1);

        ArrayList<String> rr = getSS(ros);

        ArrayList<String> mr = new ArrayList<>();
        for (String s : rr) {
            mr.add(s);  //no
            mr.add(ch + s);   //yes
        }

        return mr;
    }

    private static ArrayList<String> getSSASCII(String str) {

        if (str == null || str.length() == 0) {
            ArrayList<String> br = new ArrayList<>();
            br.add("");
            return br;
        }

        char ch = str.charAt(0);
        String ros = str.substring(1);

        ArrayList<String> rr = getSSASCII(ros);

        ArrayList<String> mr = new ArrayList<>();
        for (String s : rr) {
            mr.add(s);  //no
            mr.add(ch + s);    //yes
            mr.add((int) ch + s);    //ascii
        }

        return mr;
    }

    private static List<String> getKPC(String digits) {

        if (digits.length() == 0) {
            ArrayList<String> br = new ArrayList<>();
            br.add("");
            return br;
        }

        char ch = digits.charAt(0);
        String ros = digits.substring(1);

        List<String> rr = getKPC(ros);
        ArrayList<String> mr = new ArrayList<>();

        String pattern = getStrings(ch);

        for (char c : pattern.toCharArray()) {
            for (String s : rr) {
                mr.add(c + s);
            }
        }
        return mr;
    }

    public static String getStrings(char c) {

        switch (c) {

            case '1':
                return ".";
            case '2':
                return "abc";
            case '3':
                return "def";
            case '4':
                return "ghi";
            case '5':
                return "jkl";
            case '6':
                return "mno";
            case '7':
                return "pqrs";
            case '8':
                return "tuv";
            case '9':
                return "wxyz";

            default:
                return "";

        }

    }

    private static ArrayList<String> coinToss(int n) {

        if (n == 0) {
            ArrayList<String> br = new ArrayList<>();
            br.add("");
            return br;
        }

        ArrayList<String> rr = coinToss(n - 1);

        ArrayList<String> mr = new ArrayList<>();

        for (String r : rr) {
            mr.add("H" + r);
            mr.add("T" + r);
        }

        return mr;
    }

    private static ArrayList<String> permutation(String str) {

        if (str.length() == 1) {
            ArrayList<String> br = new ArrayList<>();
            br.add(str);
            return br;
        }

        char ch = str.charAt(0);
        String ros = str.substring(1);

        ArrayList<String> rr = permutation(ros);

        ArrayList<String> mr = new ArrayList<>();

        for (String r : rr) {

            for (int i = 0; i <= r.length(); i++) {

                String res = r.substring(0, i) + ch + r.substring(i);
                mr.add(res);

            }

        }
        return mr;
    }

    private static ArrayList<String> mazePath(int cr, int cc, int fr, int fc) {

        if (cr == fr && cc == fc) {
            ArrayList<String> br = new ArrayList<>();
            br.add("");
            return br;
        }

        if (cr > fr || cc > fc) {
            return new ArrayList<>();
        }

        ArrayList<String> mr = new ArrayList<>();

        ArrayList<String> rrh = mazePath(cr, cc + 1, fr, fc);

        for (String s : rrh)
            mr.add("H" + s);

        ArrayList<String> rrv = mazePath(cr + 1, cc, fr, fc);
        for (String s : rrv)
            mr.add("V" + s);

        return mr;
    }

    private static ArrayList<String> mazePathDiagonal(int cr, int cc, int fr, int fc) {

        if (cr == fr && cc == fc) {
            ArrayList<String> br = new ArrayList<>();
            br.add("");
            return br;
        }

        if (cr > fr || cc > fc) {
            return new ArrayList<>();
        }

        ArrayList<String> mr = new ArrayList<>();

        //moving horizontally
        ArrayList<String> rrh = mazePathDiagonal(cr, cc + 1, fr, fc);

        for (String s : rrh)
            mr.add("H" + s);

        ArrayList<String> rrv = mazePathDiagonal(cr + 1, cc, fr, fc);

        for (String s : rrv)
            mr.add("V" + s);

        ArrayList<String> rrd = mazePathDiagonal(cr + 1, cc + 1, fr, fc);

        for (String s : rrd)
            mr.add("D" + s);

        return mr;
    }

    //Multiple moves
    private static ArrayList<String> mazePathDiagMM(int cr, int cc, int fr, int fc) {

        if (cr == fr && cc == fc) {
            ArrayList<String> br = new ArrayList<>();
            br.add("");
            return br;
        }

        ArrayList<String> mr = new ArrayList<>();

        //horizontal move
        for (int move = 1; move + cc <= fc; move++) {
            ArrayList<String> rrh = mazePathDiagMM(cr, cc + move, fr, fc);
            for (String s : rrh)
                mr.add("H" + move + s);
        }

        //vertical move
        for (int move = 1; move + cr <= fr; move++) {
            ArrayList<String> rrv = mazePathDiagMM(cr + move, cc, fr, fc);
            for (String s : rrv)
                mr.add("V" + move + s);
        }

        //diagonal move
        for (int move = 1; move + cr <= fr && move + cc <= fc; move++) {
            ArrayList<String> rrd = mazePathDiagMM(cr + move, cc + move, fr, fc);
            for (String s : rrd)
                mr.add("D" + move + s);
        }
        return mr;
    }

    private static ArrayList<String> getBoardPath(int start, int end) {

        if (start == end) {
            ArrayList<String> br = new ArrayList<>();
            br.add("");
            return br;
        }

        if (start > end)
            return new ArrayList<>();

        ArrayList<String> mr = new ArrayList<>();

        for (int dice = 1; dice <= 6; dice++) {

            ArrayList<String> rr = getBoardPath(start + dice, end);

            for (String r : rr)
                mr.add(dice + r);

        }
        return mr;

    }


}

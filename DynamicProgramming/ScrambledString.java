package DynamicProgramming;

import java.util.HashMap;

public class ScrambledString {

    public static boolean isScramble(String S1, String S2) {

        if (S1.equals(S2)) {
            return true;
        }

        int n = S1.length();

        if (n <= 1) {
            return false;
        }

        for (int i = 1; i < n; i++) {

            if (isScramble(S1.substring(0, i),
                    S2.substring(0, i)) &&
                    isScramble(S1.substring(i, n),
                            S2.substring(i, n))) {
                return true;
            }

            if (isScramble(S1.substring(n - i, n),
                    S2.substring(0, i)) &&
                    isScramble(S1.substring(0, n - i),
                            S2.substring(i, n))) {
                return true;
            }
        }

        return false;
    }

    static HashMap<String,Boolean> map = new HashMap<>();
    public static boolean isScrambledTopDown(String str,String str2){
        if(str.equals(str2)){
            return true;
        }

        int n = str.length();
        if(n<=1){
            return false;
        }
        String key = str + " " +str2;
        if(map.containsKey(key)){
            return map.get(key);
        }
        for(int i=1;i<=n-1;i++){
            //no swapping
            boolean cond1 = isScrambledTopDown(str.substring(0,i),str2.substring(0,i)) && isScrambledTopDown(str.substring(i,n),str2.substring(i,n));
            if(cond1){
                map.put(key,true);
                return true;
            }

            //swapping
            boolean cond2 = isScrambledTopDown(str.substring(0,i),str2.substring(n-i,n)) && isScrambledTopDown(str.substring(i,n),str2.substring(0,n-i));
            if(cond2){
                map.put(key,true);
                return true;
            }
        }
        map.put(key,false);
        return false;
    }

    public static void main(String[] args) {
        String S1 = "coder";
        String S2 = "ocder";

        if(S1.length() != S2.length())
            System.out.println("No");
        else if (isScramble(S1, S2)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
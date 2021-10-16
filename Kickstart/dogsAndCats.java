package Kickstart;

import java.util.Scanner;

public class dogsAndCats {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int tc = scn.nextInt();
        int ct = 1;
        while(ct!=tc+1){
            scn.nextInt();
            int d_food = scn.nextInt();
            int c_food = scn.nextInt();
            int m_extra = scn.nextInt();

            scn.nextLine();

            String str = scn.nextLine();
            String ans = "YES";
            for(int i=0;i<str.length();i++){
                char ch = str.charAt(i);

                if(ch=='C'){
                    c_food--;
                    if(c_food<0 && i!=str.length()-1 && isDogLeft(str,i)){
                        ans = "NO";
                        break;
                    }
                }else if(ch=='D'){
                    c_food+=m_extra;
                    d_food--;
                    if(d_food<0){
                        ans = "NO";
                        break;
                    }
                }
            }

            System.out.println("Case #"+ct+": "+ans);
            ct++;
        }
    }

    public static boolean isDogLeft(String str,int i){
        for(int k=i+1;k<str.length();k++){
            if(str.charAt(k)=='D')
                return true;
        }
        return false;
    }
}

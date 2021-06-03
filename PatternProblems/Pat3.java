package PatternProblems;

import java.util.Scanner;

public class Pat3 {

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        int tr = scn.nextInt();

        int cr = 0;
        int nst = tr;
        while(cr<tr){

            int spc = 0;
            while(spc<nst){
                System.out.print("* ");
                spc++;
            }

            System.out.println();
            nst--;
            cr++;
        }
    }

}

package PatternProblems;

import java.util.Scanner;

public class Pat6 {

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        int nr =  scn.nextInt();
        int nst = nr;
        int nsp = 0;

        int cr =0;
        while(cr<nr){

            int csp = 0;
            while(csp<nsp){
                System.out.print("  ");
                csp++;
            }

            int cst=0;
            while(cst<nst){
                System.out.print("* ");
                cst++;
            }

            System.out.println();
            cr++;
            nst--;
            nsp+=2;
        }

    }

}

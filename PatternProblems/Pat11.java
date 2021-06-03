package PatternProblems;

import java.util.Scanner;

public class Pat11 {

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        int nr = scn.nextInt();

        int nst=1;
        int nsp = nr-1;

        int cr=0;
        while(cr<nr){

            int csp = 0;
            while(csp<nsp){
                System.out.print("  ");
                csp++;
            }

            int cst = 0;
            while (cst<nst){
                if(cst%2==0)
                    System.out.print("* ");
                else
                    System.out.print("  ");
                cst++;
            }

            System.out.println();
            nsp--;
            nst+=2;
            cr++;
        }
    }

}

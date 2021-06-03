package PatternProblems;

import java.util.Scanner;

public class Pat14 {

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int nr = 2*n-1;

        int cr = 0;
        int nst = 1;
        int nsp = n-1;
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
            if(cr<n-1) {
                nst++;
                nsp--;
            }
            else {
                nst--;
                nsp++;
            }cr++;
        }

    }

}

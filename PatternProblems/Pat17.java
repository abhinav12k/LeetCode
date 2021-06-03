package PatternProblems;

import java.util.Scanner;

public class Pat17 {

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        int nr = scn.nextInt();

        int cr = 0;
        int nst = nr - 1;
        int nsp = 1;
        while (cr < nr) {

            int cst = 0;
            while (cst < nst / 2) {
                System.out.print("* ");
                cst++;
            }

            int csp = 0;
            while (csp < nsp) {
                System.out.print("  ");
                csp++;
            }

            cst = 0;
            while (cst < nst / 2) {
                System.out.print("* ");
                cst++;
            }

            System.out.println();
            if (cr < nr / 2) {
                nst -= 2;
                nsp += 2;
            } else {
                nst += 2;
                nsp -= 2;
            }
            cr++;
        }

    }

}

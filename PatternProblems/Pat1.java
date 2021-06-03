package PatternProblems;

import java.util.Scanner;

public class Pat1 {

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

        int r = scn.nextInt();

        int cr =0;
        while(cr<r){

            int cc=0;
            while(cc<r) {
                System.out.print("* ");
                cc++;
            }
            System.out.println();
            cr++;
        }

    }

}

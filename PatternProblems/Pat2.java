package PatternProblems;

import java.util.Scanner;

public class Pat2 {

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

        int row =0;
        int nr = scn.nextInt();
        int spc=1;

        while(row<nr){

            int cl = 0;
            while(cl<spc){
                System.out.print("* ");
                cl++;
            }
            System.out.println();
            spc++;
            row++;
        }

    }

}

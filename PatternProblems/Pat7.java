package PatternProblems;

import java.util.Scanner;

public class Pat7 {

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

        int nr = scn.nextInt();
        int cr = 0;
        while(cr<nr){

            int cc=0;
            while(cc<nr){
                if(cr==0||cr==nr-1||cc==0||cc==nr-1){
                    System.out.print("* ");
                }else{
                    System.out.print("  ");
                }
                cc++;
            }

            System.out.println();
            cr++;
        }

    }

}

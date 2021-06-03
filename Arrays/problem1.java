package Arrays;

import java.util.Scanner;

public class problem1 {

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        int tc = scn.nextInt();

        int count = 1;
        while(count <=tc){

            int a = scn.nextInt();
            int b = scn.nextInt();

            int k = scn.nextInt();

            int num = b/k - (a-1)/k;
            System.out.println("Case "+count+": "+num);
            count++;
        }

    }

}

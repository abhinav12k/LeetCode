package TwoPointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class validStr {
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        int tc = scn.nextInt();

        while (tc-- != 0) {

            int n = scn.nextInt();
            int c = scn.nextInt();
            String str = scn.next();

            int i =0;
            int j=0;
            int[] pos = new int[2];

            int count =0;
            while(i<str.length()&& j<str.length()){

                if(count==2)
                    break;

                if(str.charAt(i)=='1'){
                    pos[count] = i;
                    count++;
                }

                if(Math.abs(pos[0]-pos[1]-1) <= c){
                    
                }

            }

        }

    }
}

package TwoPointer;

import java.util.Scanner;

public class clgLife {

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        int tc = scn.nextInt();

        while (tc-- != 0) {

            int s = scn.nextInt();

            int[] sTime = new int[s];
            for(int i=0;i<s;i++){
                sTime[i] = scn.nextInt();
            }

            int time = 0;
            for(int i=0;i<s;i++){

                int nEp = scn.nextInt();
                int[] eps = new int[nEp];
                for(int j=0;j<nEp;j++){
                    eps[j] = scn.nextInt();
                }

                time += eps[0];
                for(int k=1;k<nEp;k++){
                    time += eps[k] - sTime[i];
                }

            }
            System.out.println(time);
        }
    }
}

package TwoPointer;

import java.util.Arrays;
import java.util.Scanner;

public class maxValue {

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        int tc = scn.nextInt();

        while (tc-- != 0) {

            int n = scn.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = scn.nextInt();
            }
            Arrays.sort(arr);
            int mx1 = arr[arr.length - 1];
            int mx2 = arr[arr.length - 2];
            int mn1 = arr[0];
            int mn2 = arr[1];
            long val = Integer.MIN_VALUE;

            for(int num :arr){

                if(num == mx1){
                    val = Math.max(val,num*mx2+Math.abs(num-mx2));
                }else{
                    val = Math.max(val,num*mx1 + Math.abs(num-mx1));
                }

                if(num == mn1){
                    val = Math.max(val,num * mn2 + Math.abs(num - mn2));
                }else{
                    val = Math.max(val,num*mn1+Math.abs(num-mn1));
                }
            }

            System.out.println(val);
        }

    }

}

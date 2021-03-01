package TwoPointer;

import java.util.Arrays;
import java.util.Scanner;

public class maxValue {

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        int tc = scn.nextInt();

        while (tc-- != 0) {

            int n = scn.nextInt();
            int[] arr= new int[n];
            for(int i=0;i<n;i++){
                arr[i] = scn.nextInt();
            }
//            Arrays.sort(arr);

            System.out.println(arr[arr.length-1] * arr[arr.length-2]
                    + Math.abs(arr[arr.length-1] - arr[arr.length-2]));
            int i=0;
            int j=arr.length-1;
            long val = Integer.MIN_VALUE;
            while (i<j){

                long currVal = (long) arr[i] * arr[j] + Math.abs(arr[i]-arr[j]);
//                if(val < currVal){
//                    i++;
//                }else{
//                    j--;
//                }
                val = Math.max(val,currVal);

                if(arr[i] < arr[j])
                    i++;
                else
                    j--;

            }
            System.out.println(val);
        }

    }

}

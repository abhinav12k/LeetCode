package Arrays.Easy;

import java.util.Scanner;

public class countGoodTriplets {

    public static void main(String[] args) {


        Scanner scn = new Scanner(System.in);
        int size = scn.nextInt();
        int[] arr = new int[size];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }

        int a = scn.nextInt();
        int b = scn.nextInt();
        int c = scn.nextInt();

        System.out.println(countGoodTriplets(arr, a, b, c));

    }

    public static int countGoodTriplets(int[] arr, int a, int b, int c) {
        int count = 0;

        for (int i = 0; i < arr.length; i++) {

            for (int j = i + 1; j < arr.length; j++) {

                int diff1 = Math.abs(arr[i] - arr[j]);

                if(diff1 <= a) {

                    for (int k = j + 1; k < arr.length; k++) {

                        int diff2 = Math.abs(arr[j] - arr[k]);
                        int diff3 = Math.abs(arr[k] - arr[i]);

                        if (diff2 <= b && diff3 <= c)
                            count++;


                    }
                }
            }

        }
        return count;
    }
}

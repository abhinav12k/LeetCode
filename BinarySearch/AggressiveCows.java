package BinarySearch;

import java.util.Arrays;
import java.util.Scanner;

public class AggressiveCows {

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        int tc = scn.nextInt();

        while (tc-- != 0) {

            int n = scn.nextInt();
            int cows = scn.nextInt();

            int[] locations = new int[n];
            for (int i = 0; i < n; i++) {
                locations[i] = scn.nextInt();
            }

            System.out.println(getLargestMinDistance(locations,cows,n));
        }

    }

    private static int getLargestMinDistance(int[] locations, int cows, int n){

        Arrays.sort(locations);
        int l=1;
        int r=locations[locations.length-1]-1;

        while(l<=r){

            int dist = (r-l)/2+l;

            if(isItPossibleToPlaceCows(locations,dist,cows)){
                l = dist+1;
            }else{
                r = dist-1;
            }

        }
        return r;
    }

    private static boolean isItPossibleToPlaceCows(int[] locations,int dist,int cows){

        int ct = 1;
        int coordinate = locations[0];
        for(int c=1;c<locations.length;c++){

            if(locations[c]-coordinate>=dist) {
                ct++;
                coordinate = locations[c];
            }
            if(ct==cows)
                return true;

        }
        return false;
    }

}

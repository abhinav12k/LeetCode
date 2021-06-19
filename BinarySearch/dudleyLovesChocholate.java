package BinarySearch;

import java.util.Scanner;

public class dudleyLovesChocholate {
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();

        int[] arr = new int[n];
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
            max = Math.max(max, arr[i]);
            sum += arr[i];
        }

        int l = sum / k;
        int h = max;
        int d = 0;

        while(l<h){
            int mid=l+(h-l)/2;

            if(mid>=max) d=n;
            else d=DaysToEat(arr,mid);

            if(d<=k) h=mid;
            else l=mid+1;
        }

        System.out.println(l);
    }

    private static int DaysToEat(int[] arr,int caneat){
        int days=0,n=arr.length;

        for(int i=0;i<n;i++){
            days= (int) (days+Math.ceil((double)arr[i]/caneat));
        }

        return days;
    }

}
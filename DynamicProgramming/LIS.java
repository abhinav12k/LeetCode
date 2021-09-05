package DynamicProgramming;

import java.util.Arrays;

public class LIS {
    public static void main(String[] args) {
        int[] arr = {10,22,9,33,21,50,41,60,80};

        //TC - exponential
        int max = Integer.MIN_VALUE;
        for(int i=1;i<arr.length;i++){
            max = Math.max(max,getLongestIncreasingSubsequence(arr,i,arr[i-1])+1);
        }
        System.out.println(max);

        //TC - O(n^2)
        System.out.println(getLongestISS(arr));

        //TC - O(nlogn)

    }

    private static int getLongestIncreasingSubsequence(int[] arr,int start,int prev){

        if(start>arr.length)
            return 0;

        int ans = 0;
        for(int i=start;i<arr.length;i++){

            if(arr[i]>prev){
                ans = Math.max(ans,getLongestIncreasingSubsequence(arr,i+1,arr[i]) + 1);
            }
            ans = Math.max(ans,getLongestIncreasingSubsequence(arr,i+1,prev));

        }
        return ans;
    }

    private static int getLongestISS(int[] arr){
        int[] t = new int[arr.length];
        Arrays.fill(t, 1);

        for(int i=1;i<arr.length;i++){
            for(int j=0;j<i;j++){
                if(arr[j]<arr[i]){
                    t[i] = Math.max(t[i],1 + t[j]);
                }
            }
        }
        int max =0;
        for(int a: t){
            max =Math.max(max,a);
        }
        return max;
    }



}

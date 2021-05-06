package KadaneAlgo;

public class FlipBits {

    public static void main(String[] args) {

        /**
         * You are given an array of integers ARR[] of size N consisting of zeros and ones.
         * You have to select a subset and flip bits of that subset. You have to return the count of maximum
         * one’s that you can obtain by flipping chosen sub-array at most once.
         * A flip operation is one in which you turn 1 into 0 and 0 into 1.
         * For example: If you are given an array {1,1,0,0,1} then you will
         * have to return the count of maximum one’s you can obtain by flipping
         * anyone chosen sub-array at most once, so here you will clearly choose sub-array
         * from the index 2 to 3 and then flip it's bits. So, the final array comes out to be {1,1,1,1,1}
         * which contains five ones and so you will return 5.
         *
         * Sample Input 1 :
         *
         * 3
         * 5
         * 1 0 0 1 0
         * 4
         * 1 1 1 0
         * 5
         * 0 0 1 0 0
         *
         * Sample Output 1 :
         *
         * 4
         * 4
         * 4
         **/

        System.out.println(flipBits(new int[]{1,0,0,1,0},5));

    }

    public static int flipBits(int[] arr, int n) {

        int nOnes = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 1) {
                nOnes++;
                arr[i] = -1;  //changing 1s to -1 so that we can apply kadane's algo
            } else {
                arr[i] = 1;   //changing 0s to 1s

            }

        }

        int curr=0;
        int maxSum =0;
        for (int i = 0; i < n; i++) {
            curr+=arr[i];
            maxSum=Math.max(curr,maxSum);
            if(curr<0)
                curr=0;
        }
        return Math.max(maxSum,0)+nOnes;
    }
}

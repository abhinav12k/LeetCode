package KadaneAlgo;

public class kadaneAlgo {

    public static void main(String[] args) {

        /**
         * Given an array we need to find a subarray with maximum sum
         * */

        int[] arr = new int[]{1, 2, 7, -4, 3, 2, -10, 9, 1};
        System.out.println(getMaxSum(arr));

    }

    private static int getMaxSum(int[] arr) {
        int curr = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            curr += arr[i];
            maxSum = Math.max(maxSum, curr);
            if (curr < 0)
                curr = 0;
        }
        return Math.max(maxSum, 0);
    }

}
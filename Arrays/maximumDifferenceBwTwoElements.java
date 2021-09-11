package Arrays;

public class maximumDifferenceBwTwoElements {
    public static void main(String[] args) {
        int[] arr = {2, 3, 10, 6, 4, 8, 1};
        System.out.println(getMaxDiff(arr));
    }

    private static int getMaxDiff(int[] arr){

        int min = arr[0];
        int max_diff = Integer.MIN_VALUE;
        for(int i=1;i<arr.length;i++){
            max_diff = Math.max(max_diff,arr[i]-min);
            min = Math.min(min,arr[i]);
        }
        return max_diff;
    }

}

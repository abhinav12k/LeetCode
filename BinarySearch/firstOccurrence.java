package BinarySearch;

public class firstOccurrence {

    public static void main(String[] args) {
        int[] arr = {1,2,2,3,4,4,5,5,6};
        System.out.println(getFirstOccurrence(arr,4));
    }

    private static int getFirstOccurrence(int[] arr, int target) {
        int l = 0;
        int h = arr.length - 1;
        int ans = -1;
        while (l <= h) {
            int mid = (h - l) / 2 + l;
            if (arr[mid] == target) {
                ans = mid;
                h = mid - 1;
            } else if (arr[mid] > target) {
                h = mid - 1;
            } else
                l = mid + 1;
        }
        return ans;
    }
}

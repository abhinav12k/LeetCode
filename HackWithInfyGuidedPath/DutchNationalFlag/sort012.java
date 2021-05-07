package HackWithInfyGuidedPath.DutchNationalFlag;

public class sort012 {

    public static void main(String[] args) {

        int[] arr = new int[]{1, 0, 2, 1, 2, 0, 0, 1, 1, 0, 2, 2};
//        sort012usingCounter(arr);
        sort012DutchFlag(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static void sort012usingCounter(int[] arr) {

        int c0 = 0;
        int c1 = 0;
        int c2 = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0)
                c0++;
            else if (arr[i] == 1)
                c1++;
            else
                c2++;
        }
        for (int i = 0; i < arr.length; i++) {

            if (c0 > 0) {
                arr[i] = 0;
                c0--;
            } else if (c1 > 0) {
                arr[i] = 1;
                c1--;
            } else {
                arr[i] = 2;
                c2--;
            }

        }
    }

    public static void sort012DutchFlag(int[] arr) {

        int lo = 0;
        int mid = 0;
        int hi = arr.length - 1;

        while (mid <= hi) {

            if (arr[mid] == 0) {
                swap(arr, mid, lo);
                mid++;
                lo++;
            } else if (arr[mid] == 1) {
                mid++;
            } else if (arr[mid] == 2) {
                swap(arr, mid, hi);
                hi--;
            }

        }

    }

    private static void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

}

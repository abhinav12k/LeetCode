package Sorting;

public class QuickSort {

    public static void main(String[] args) {

        int[] arr = new int[]{1, 5, 0, -5, 3, 4, 11, 65};
        quickSort(arr, 0, arr.length-1);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    private static void quickSort(int[] arr, int lo, int hi) {

        if (lo >= hi)
            return;

        int pi = partition(arr, lo, hi);
        quickSort(arr, lo, pi - 1);
        quickSort(arr, pi + 1, hi);
    }

    //function to return the correct index of pivot element
    private static int partition(int[] arr, int lo, int hi) {

        int pivot = arr[(lo+hi)/2];
        int curr = lo;
        int start = lo - 1;
        while (curr < hi) {

            if (arr[curr] < pivot) {
                start++;
                swap(arr, start, curr);
            }

            curr++;
        }
        //swapping the pivot to its correct position
        swap(arr,start+1,(lo+hi)/2);
        return start+1;
    }

    private static void swap(int[] arr, int lo, int hi) {
        int temp = arr[lo];
        arr[lo] = arr[hi];
        arr[hi] = temp;
    }
}

package Recursion;

public class Sorting {

    public static void main(String[] args) {
        int[] arr = { 50, 40, 300, 8, 9, 6 };
//        arr = mergeSort(arr,0,arr.length-1);
        quickSort(arr,0,arr.length-1);
        for(int a: arr){
            System.out.println(a);
        }
    }

    private static int[] mergeSort(int[] arr, int lo, int hi) {

        if (lo == hi) {
            int[] br = new int[1];
            br[0] = arr[lo];
            return br;
        }

        int mid = (lo + hi) / 2;
        int[] lh = mergeSort(arr, lo, mid);
        int[] rh = mergeSort(arr, mid + 1, hi);

        return mergedArray(lh, rh);
    }

    private static int[] mergedArray(int[] lh, int[] rh) {

        int[] res = new int[lh.length + rh.length];

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < lh.length && j < rh.length) {
            if(lh[i] < rh[j]){
                res[k] = lh[i];
                i++;
                k++;
            }else{
                res[k] = rh[j];
                j++;
                k++;
            }
        }

        while(i<lh.length){
            res[k] = lh[i];
            i++;
            k++;
        }

        while(j<rh.length){
            res[k] = rh[j];
            j++;
            k++;
        }

        return res;
    }

    private static void quickSort(int[] arr,int lo,int hi){

        if(lo >= hi){
            return;
        }

        int mid = (lo+hi)/2;
        int pivot = arr[mid];

        int left = lo;
        int right = hi;

        while (left<=right){

            while (arr[left]<pivot){
                left++;
            }

            while (arr[right] >  pivot)
                right--;

            if(left<=right){
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }

        quickSort(arr,lo,right);
        quickSort(arr,left,hi);
    }

}

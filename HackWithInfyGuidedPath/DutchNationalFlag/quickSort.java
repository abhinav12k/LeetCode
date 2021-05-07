package HackWithInfyGuidedPath.DutchNationalFlag;

public class quickSort {

    private static int i,j;

    public static void main(String[] args) {

        int[] arr = new int[]{5, 2, 7, 3, 5};

        sortWithDutch(arr,0,arr.length-1);
        for(int a:arr)
            System.out.print(a+" ");
    }

    private static void sortWithDutch(int[] arr,int lo,int hi){

        if(lo>=hi)
            return;

        partition(arr,lo,hi);
        System.out.println(i+" : "+j);
        sortWithDutch(arr,lo,i);
        sortWithDutch(arr,j,hi);
    }

    private static void partition(int[] arr,int lo,int hi){

        if(hi-lo<=1){
            if (arr[hi] < arr[lo])
                swap(arr,hi, lo);
            i = lo;
            j = hi;
            return;
        }

        int mid = lo;
        int pivot = arr[hi];

        while(mid<=hi){

            if(arr[mid] < pivot){
                swap(arr,lo,mid);
                lo++;
                mid++;
            }else if(arr[mid] > pivot){
                swap(arr,hi,mid);
                hi--;
            }else{
                mid++;
            }

        }

        i = lo-1;
        j = mid;
    }

    private static void swap(int[] arr,int lo,int hi){
        int temp = arr[lo];
        arr[lo] = arr[hi];
        arr[hi] = temp;
    }
}

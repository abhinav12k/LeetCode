package BinarySearch;

public class negativeElements {

    public static void main(String[] args) {
        int[] arr = {-101, -99, -54, -21,-3,-2,-1, 6, 12, 19, 20, 74, 92};
        System.out.println(getNegativeCount(arr));
    }

    private static int getNegativeCount(int[] arr){

        //Similar to finding index of first positive integer
        int l= 0;
        int r=arr.length-1;
        int ans=-1;
        while(l<=r){
            int mid = (r-l)/2+l;
            if(arr[mid]>=0){
                ans=mid;
                r=mid-1;
            }else {
                l = mid+1;
            }
        }
        return ans;
    }
}

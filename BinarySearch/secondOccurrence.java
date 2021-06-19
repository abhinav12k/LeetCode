package BinarySearch;

public class secondOccurrence {
    public static void main(String[] args) {
        int[] arr = {1,2,2,2,2,3,4,6,6};
        System.out.println(getLastOccurrence(arr,2));
    }

    private static int getLastOccurrence(int[] arr,int target){
        int l = 0;
        int r =arr.length-1;
        int ans=-1;
        while(l<=r){
            int mid = (r-l)/2+l;
            if(arr[mid]==target){
                ans = mid;
                l = mid+1;
            }else if(arr[mid]> target){
                r = mid-1;
            }else
                l = mid+1;
        }
        return ans;
    }
}

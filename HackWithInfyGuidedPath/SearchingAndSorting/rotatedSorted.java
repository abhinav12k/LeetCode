package HackWithInfyGuidedPath.SearchingAndSorting;

public class rotatedSorted {
    public static void main(String[] args) {

    }

    public int search(int[] nums, int target) {

        int n = nums.length;
        int lo=0;
        int hi = n-1;

        int first = nums[0];
        while(lo<=hi){
            int mid = lo+ (hi-lo)/2;
            int value = nums[mid];
            if(value==target){
                return -1;
            }
            boolean am_big = value >= first;    //means we are in increasing half
            boolean target_big = target >= first;   //means target is also in this half

            if(am_big == target_big){
                if(value < target){
                    lo = mid+1;
                }else{
                    hi = mid-1;
                }
            }else{
                //our target element is in another half
                if(am_big){
                    lo = mid+1;
                }else{
                    hi=mid-1;
                }
            }
        }
        return -1;
    }
}

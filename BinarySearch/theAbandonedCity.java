package BinarySearch;

public class theAbandonedCity {

    public static void main(String[] args) {

        int[] arr = {1,2,3,4,5};
        int minCoins = 7;
        int minSteps = getMinSteps(arr,minCoins);
        System.out.println(minSteps);
    }

    private static int getMinSteps(int[] arr,int k){

        int n = arr.length;
        int[] pre = new int[n];
        pre[0] = arr[0];
        for(int i=1;i<n;i++)
            pre[i] = pre[i-1] + arr[i];

        int ans = Integer.MAX_VALUE;
        for(int i=1;i<=n;i++){
            int l = i;
            int r = n;
            int mid = 0;

            while(l<r){
                mid = (r+l)/2;

                if(pre[mid] - pre[i-1] >= k){
                    ans = Math.min(ans,mid-i+1);
                    r = mid-1;
                }else{
                    l = mid+1;
                }

            }
        }
        return ans;
    }

}

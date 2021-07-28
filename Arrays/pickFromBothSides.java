package Arrays;

public class pickFromBothSides {
    public static void main(String[] args) {
        int[] arr =  { 1, 2};
        System.out.println(new Solution().solve2(arr,1));
    }

    public static class Solution {

        public int solve2(int[] arr,int n){
            int[] prefix = new int[arr.length];
            prefix[0] = arr[0];
            for(int i=1;i<arr.length;i++){
                prefix[i]=prefix[i-1]+arr[i];
            }

            int[] suffix = new int[arr.length];
            suffix[arr.length-1]=arr[arr.length-1];
            for(int i=arr.length-2;i>=0;i--){
                suffix[i]=suffix[i+1]+arr[i];
            }

            int maxSum = Math.max(prefix[n-1],suffix[arr.length-n]);

            for(int i=0;i<arr.length && n-1-i>0;i++){
                int start = i;
                int end = arr.length-(n-1-start);

                int sum = prefix[start]+suffix[end];
                maxSum = Math.max(maxSum,sum);

            }
            return maxSum;
        }
    }
}

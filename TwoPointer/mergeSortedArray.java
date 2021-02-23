package TwoPointer;

public class mergeSortedArray {

    public static void main(String[] args) {

        int[] nums1 = {1,2,3,0,0,0};
        int m = 3;
        int[] nums2 = {2,5,6};
        int n = 3;

        new Solution().merge2(nums1,m,nums2,n);
        for(int n1:nums1)
            System.out.print(n1+" ");
    }

    static class Solution {
        //Approach 1
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int[] temp = new int[m];
            for(int i=0;i<m;i++){
                temp[i] = nums1[i];
            }

            int i =0;
            int j=0;
            int k = 0;
            while(i < m && j< n){
                if(temp[i] < nums2 [j]){
                    nums1[k] = temp[i];
                    i++;
                }else {
                    nums1[k] = nums2[j];
                    j++;
                }
                k++;
            }

            if(i==m){
                while(j!=n){
                    nums1[k] = nums2[j];
                    j++;
                    k++;
                }
            }
            if(j==n) {
                while (i != m) {
                    nums1[k] = temp[i];
                    i++;
                    k++;
                }
            }
        }

        //Approach 2
        public void merge2(int[] nums1,int m,int[] nums2,int n){

            int end1 = m-1, end2 = n -1, finalEnd = m + n - 1;
            while(end1 >= 0 && end2 >= 0){
                nums1[finalEnd--] = nums1[end1] > nums2[end2] ? nums1[end1--] : nums2[end2--];
            }

            while(end2 >= 0){
                nums1[finalEnd--] = nums2[end2--];
            }
        }
    }
}

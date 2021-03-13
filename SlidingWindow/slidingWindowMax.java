package SlidingWindow;

import java.util.Deque;
import java.util.LinkedList;

public class slidingWindowMax {
    public static void main(String[] args) {

//        Deque<Integer> dq = new LinkedList<>();
//        for(int i=0;i<10;i++){
//            dq.add(i);
//        }
//
//        System.out.println(dq.peekFirst());
//        System.out.println(dq.peekLast());
//        for(int n: dq){
//            System.out.print(n+" : ");
//        }

        int[] nums = {1,-1};
        int k = 1;
        int[] ans = new Solution().maxSlidingWindow(nums,k);
        for(int n: ans)
            System.out.println(n);
    }

    static class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {

            if(nums.length==1 && k==1){
                return nums;
            }

            int n = nums.length;
            int[] ans = new int[n - k + 1];

            int r = 0, l = 0;
            Deque<Integer> dq = new LinkedList<>();
            while(r<=n-1){

                while(!dq.isEmpty() && dq.peekLast() < nums[r])
                    dq.removeLast();
                dq.addLast(nums[r]);

                if((r+1-l)%k==0){
                    ans[l] = dq.peekFirst();

                    if(!dq.isEmpty() && dq.peekFirst() == nums[l])
                        dq.removeFirst();
                    l++;


                }

                r++;
            }
            return ans;

            // Brute force
//            int max = Integer.MAX_VALUE;
//            for (int i = 0; i < nums.length - k; i++) {
//                r=i;
//                while (r < i + k) {
//                    max = Math.max(max,nums[r]);
//                    r++;
//                }
//                ans[i]=max;
//            }
//            return ans;
        }
    }

}

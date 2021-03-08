package SlidingWindow;

import java.util.Deque;
import java.util.LinkedList;

public class longestContSubArray {

    public static void main(String[] args) {

    }

    class Solution {
        public int longestSubarray(int[] nums, int limit) {
            //TRIED APPROACH - FAILED
            int n = nums.length;
            if (n == 1) {
                return n;
            }
            int left = 0, right = left + 1;
            int count = 1;
            int min = nums[left];
            int max = nums[left];
            int ans = 1;
            while (right < n) {

                min = Math.min(min, nums[right]);
                max = Math.max(max, nums[right]);

                while (left < right && Math.abs(max - min) > limit) {
                    left++;
                    count--;
                    min = nums[left];
                    max = Math.max(nums[left], nums[right]);
                }

                count++;
                right++;
                ans = Math.max(ans, count);
            }

            return ans;
        }

        public int longestSubArray(int[] arr, int lt) {

            Deque<Integer> maxq = new LinkedList<>();
            Deque<Integer> minq = new LinkedList<>();

            int start = 0, end;
            for (end = 0; end < arr.length; end++) {

                while(!maxq.isEmpty() && maxq.peekLast() < arr[end]){
                    maxq.pollLast();
                }
                while(!minq.isEmpty() && minq.peekLast() > arr[end])
                    minq.pollLast();
                maxq.add(arr[end]);
                minq.add(arr[end]);
                if(maxq.peek() - minq.peek() > lt){
                    if(maxq.peek() == arr[start])
                        maxq.poll();
                    if(minq.peek() == arr[start])
                        minq.poll();
                    start++;
                }
            }
            return end - start + 1;
        }

    }

}

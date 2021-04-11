import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class smallerNumberAfterSelf {

    public static void main(String[] args) {


    }

    class Solution {
        //O(N^2) solution
        public List<Integer> countSmaller(int[] nums) {

            List<Integer> res = new ArrayList();
            for (int i = 0; i < nums.length; i++) {
                int count = 0;
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] < nums[i])
                        count++;
                }
                res.add(count);
            }
            return res;
        }

        //O(nlogn) solution -> Merge Sort
        public List<Integer> countSmallerUsingMergeSort(int[] nums) {

            Pair[] pairs = new Pair[nums.length];
            for (int i = 0; i < nums.length; i++) {
                pairs[i] = new Pair(nums[i], i);
            }

            int[] result = new int[pairs.length];
            mergeSortAndCount(pairs, 0, pairs.length - 1, result);
            List<Integer> ans = new ArrayList<>();
            for (int res : result)
                ans.add(res);
            return ans;
        }

        private void mergeSortAndCount(Pair[] pairs, int start, int end, int[] res) {

            if (start >= end)
                return;

            int mid = (start + end) / 2;
            mergeSortAndCount(pairs, start, mid, res);
            mergeSortAndCount(pairs, mid + 1, end, res);

            //merging sorted arrays
            int leftPos = start;
            int rightPos = mid + 1;

            LinkedList<Pair> merged = new LinkedList<>();
            int nElementsRightArraySmallerThanLeftArray = 0;
            while (leftPos <= mid && rightPos <= end) {

                if (pairs[leftPos].val > pairs[rightPos].val) {
                    nElementsRightArraySmallerThanLeftArray++;
                    merged.add(pairs[rightPos]);
                    rightPos++;
                } else {

                    res[pairs[leftPos].idx] += nElementsRightArraySmallerThanLeftArray;
                    merged.add(pairs[leftPos]);
                    leftPos++;
                }

            }

            while (leftPos <= mid) {
                res[pairs[leftPos].idx] += nElementsRightArraySmallerThanLeftArray;
                merged.add(pairs[leftPos]);
                leftPos++;
            }

            while (rightPos <= end) {
                merged.add(pairs[rightPos]);
                rightPos++;
            }
            int pos = start;
            for (Pair m : merged) {
                pairs[pos] = m;
                ++pos;
            }
        }

        private class Pair {
            int val;
            int idx;

            private Pair(int val, int idx) {
                this.val = val;
                this.idx = idx;

            }
        }
    }

}

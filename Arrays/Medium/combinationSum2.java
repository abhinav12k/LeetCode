package Arrays.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class combinationSum2 {

    public static void main(String[] args) {

        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        System.out.println(new Solution().combinationSum2(candidates, target));

    }

    static class Solution {
        List<List<Integer>> result = new ArrayList<>();

        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            Arrays.sort(candidates);
            getCombinations(candidates, target, 0, 0, new ArrayList<Integer>());
            return result;
        }

        private void getCombinations(int[] candidates, int target, int sum, int startIdx, List<Integer> subCombination) {

            if (sum == target) {
                List<Integer> validAns = new ArrayList<>(subCombination);
                result.add(validAns);
                return;
            }

            if (sum > target) {
                return;
            }

            for (int i = startIdx; i < candidates.length; i++) {

                if(i >  startIdx && candidates[i] == candidates[i-1]){
                    continue;
                }

                sum += candidates[i];

                if(sum>target){
                    break;
                }

                subCombination.add(candidates[i]);
                getCombinations(candidates, target, sum, i + 1, subCombination);
                sum -= candidates[i];
                subCombination.remove(subCombination.size() - 1);
            }

        }

    }
}

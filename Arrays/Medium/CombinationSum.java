package Arrays.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

    public static void main(String[] args) {

        int[] candidates = {2, 3, 5};
        int target = 8;

        System.out.println(new Solution().combinationSum(candidates, target));

    }

    static class Solution {
        List<List<Integer>> result = new ArrayList<>();
        public List<List<Integer>> combinationSum(int[] candidates,int target){
            List<Integer> subAns = new ArrayList<>();
            getSubLists(candidates,target,subAns,0,0);
            return result;
        }

        private void getSubLists(int[] candidates,int target,List<Integer> subAns,int sum,int startIdx){

            if(sum == target){
                List<Integer> validAns = new ArrayList<>(subAns);
                result.add(validAns);
                return;
            }

            if(sum > target){
                return;
            }

            for(int i=startIdx;i<candidates.length;i++){
                sum = sum + candidates[i];
                subAns.add(candidates[i]);
                getSubLists(candidates,target,subAns,sum,i);
                sum = sum - candidates[i];
                subAns.remove(subAns.size() - 1);
            }

        }

    }

}

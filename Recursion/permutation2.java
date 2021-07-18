package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class permutation2 {

    public static void main(String[] args) {

        permuteUnique(new int[]{1,1,2});

    }

    public static List<List<Integer>> permuteUnique(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList();
        helper(ans,new ArrayList(),nums,new boolean[nums.length]);
        return ans;
    }

    private static void helper(List<List<Integer>> ans,List<Integer> subAns,int[] nums, boolean[] visited){

        if(subAns.size()==nums.length){
            ans.add(new ArrayList<Integer>(subAns));
            return;
        }

        for(int i=0;i<nums.length;i++){
            if(visited[i] || i > 0 && nums[i] == nums[i-1] && !visited[i - 1])
                continue;
            visited[i] = true;
            subAns.add(nums[i]);
            helper(ans,subAns,nums,visited);
            visited[i] = false;
            subAns.remove(subAns.size()-1);
        }

    }

}

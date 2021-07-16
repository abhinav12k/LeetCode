package Recursion;

import java.util.ArrayList;
import java.util.List;

public class subsets {

    public static void main(String[] args) {

        System.out.println(subsets(new int[]{1,2,3}));

    }

    public static List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();
//        helper(ans,new ArrayList<Integer>(),nums,0);
        helper2(ans,new ArrayList<>(),nums,0);
        return ans;
    }

    private static void helper(List<List<Integer>> ans,List<Integer> subAns, int[] nums, int idx){

        if(nums.length == idx){
            ans.add(subAns);
            return;
        }

        int first = nums[idx];
        List<Integer> ss = new ArrayList<>(subAns);
        helper(ans,subAns,nums,idx+1);
        ss.add(first);
        helper(ans,ss,nums,idx+1);
    }

    private static void helper2(List<List<Integer>> ans,List<Integer> subAns,int[] nums,int start){

        ans.add(new ArrayList<>(subAns));
        for(int i=start;i<nums.length;i++) {
            subAns.add(nums[i]);
            helper2(ans,subAns,nums,i+1);
            subAns.remove(subAns.size()-1);
        }
    }

}

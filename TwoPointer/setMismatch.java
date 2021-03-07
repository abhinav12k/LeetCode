package TwoPointer;

import java.util.HashMap;

public class setMismatch {

    public static void main(String[] args) {

        int[] ans = new Solution().findErrorNums(new int[]{1,2,2,4});
        for(int n:ans)
            System.out.println(n);
    }

    static class Solution {
        public int[] findErrorNums(int[] nums) {
            int[] ans = new int[2];
            HashMap<Integer,Boolean> map = new HashMap<>();
            for(int n:nums){
                if(map.containsKey(n))
                    ans[0] = n;
                map.put(n,true);
            }
            for(int i=1;i<=nums.length;i++){
                if(!map.containsKey(i))
                    ans[1] = i;
            }
            return ans;
        }
    }

}

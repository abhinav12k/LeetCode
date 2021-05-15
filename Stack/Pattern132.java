package Stack;

public class Pattern132 {

    public static void main(String[] args) {

    }

    public static boolean find132patternNaive(int[] nums) {

        for(int i=0;i<nums.length;i++){
            for(int j = i+1;j<nums.length;j++){
                for(int k = j+1;k<nums.length;k++){
                    if(nums[i] < nums[k] && nums[k] < nums[j])
                        return true;
                }
            }
        }
        return false;
    }

    public static boolean find132PatternOptmized(int[] nums){

        //Fixing j
        int min = Integer.MAX_VALUE;
        for(int j=0;j<nums.length;j++){
            min = Math.min(min,nums[j]);

            if(nums[j]==min)
                continue;
            for(int k = nums.length-1;k>j;k--){
                if(min < nums[k] && nums[k] < nums[j])
                    return true;
            }
        }
        return false;
    }

}

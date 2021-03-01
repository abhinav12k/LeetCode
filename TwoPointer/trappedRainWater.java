package TwoPointer;

public class trappedRainWater {
    class Solution {
        public int trap(int[] height) {

            int water = 0;
            int left_max=0,right_max = 0;
            int left=0,right=height.length-1;
            while(left<right){

                if(height[left]>left_max)
                    left_max = height[left];
                if(height[right]>right_max)
                    right_max = height[right];

                if(left_max<right_max){
                    water+=left_max-height[left];
                    left++;
                }else{
                    water+=right_max-height[right];
                    right--;
                }

            }
            return water;
        }
    }
}

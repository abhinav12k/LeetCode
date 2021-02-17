package Arrays.Medium;

public class containerWithMostWater {

    public static void main(String[] args) {

        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(new Solution().maxArea(height));

    }

    static class Solution {
        public int maxArea(int[] height) {

            int maxWater = 0;
            int i=0;
            int j = height.length-1;
            while(i<j){

                maxWater = Math.max(maxWater,Math.min(height[i],height[j]) * (j - i));

                if(height[i] > height[j]){
                    j--;
                }else{
                    i++;
                }

            }
            return maxWater;
        }
    }

}



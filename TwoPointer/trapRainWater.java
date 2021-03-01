package TwoPointer;

public class trapRainWater {

    public static void main(String[] args) {
        int[] height = {4,2,3};
        System.out.println(new Solution().trap(height));

     }

    static class Solution {
        public int trap(int[] height) {
            int water = 0;
            int idx1 = -1, idx2 = -1;
            int b1 = 0, b2 = 0;

            for (int i = 0; i < height.length; ) {
                if (height[i] > 0) {
                    idx1 = i;
                    b1 = height[i];
                }
                boolean fl = false;
                for (int j = i + 1; j < height.length && b1 != 0; j++) {

                    if (height[j] >= b1) {
                        //b2
                        idx2 = j;
                        b2 = height[j];
                        fl = true;
                        break;
                    }
                }

                int minH = Math.min(b1, b2);
                for (int k = idx1 + 1; k < idx2; k++) {
                    water += Math.abs(height[k] - minH);
                }

                if (!fl)
                    i++;
                else
                    i = idx2;
            }
            return water;
        }
    }
}

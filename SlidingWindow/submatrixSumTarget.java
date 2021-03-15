package SlidingWindow;

import java.util.HashMap;

public class submatrixSumTarget {

    public static void main(String[] args) {

    }

    public int numSubmatrixSumTarget(int[][] A, int target) {

        for (int i = 0; i < A.length; i++) {
            for (int j = 1; j < A[0].length; j++) {
                A[i][j] += A[i][j - 1];
            }
        }

        int ans = 0;
        int rows = A.length;
        int cols = A[0].length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int startCol = 0; startCol < cols; startCol++) {

            for (int currCol = startCol; currCol < cols; currCol++) {
                map.clear();
                map.put(0, 1);

                int sum = 0;
                for (int row = 0; row < rows; row++) {
                    sum += A[row][currCol] - (startCol > 0 ? A[row][startCol - 1] : 0);
                    ans += map.getOrDefault(sum - target, 0);
                    map.put(sum, map.getOrDefault(sum, 0) + 1);
                }

            }

        }
        return ans;

    }

}

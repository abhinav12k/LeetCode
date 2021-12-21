package Graph.MultisourceBFS;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class NearestDistanceWhiteCell {

    //0 -> black
    //1 -> white

    private static int MinDistToWhiteCell(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        Queue<int[]> q = new LinkedList<>();
        int[][] dist = new int[n][m];

        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    //Inserting those values with which we can traverse further
                    q.offer(new int[]{i, j});
                    dist[i][j] = 0;
                } else {
                    dist[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        while (!q.isEmpty()) {

            int[] pt = q.poll();
            int x = pt[0];
            int y = pt[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m && dist[nx][ny] == Integer.MAX_VALUE) {
                    q.add(new int[]{nx, ny});
                    dist[nx][ny] = 1 + dist[x][y];
                }
            }

        }

        int maxDist = 0;
        for (int[] d : dist) {
            for (int j : d) {
                maxDist = Math.max(maxDist, j);
            }
        }
        return maxDist;
    }

    public static void main(String[] args) {

        int[][] grid = {{0, 0, 0, 0, 0, 0},
                {0, 1, 1, 0, 1, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0},
                {0, 0, 1, 0, 0, 0},
                {1, 0, 0, 0, 0, 1}};

        System.out.println(MinDistToWhiteCell(grid));
    }

}

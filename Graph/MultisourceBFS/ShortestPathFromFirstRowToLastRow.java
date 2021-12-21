package Graph.MultisourceBFS;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathFromFirstRowToLastRow {

    /**
     * You need to find the path from the first row to the last row. You can only traverse the cells which have 1 value
     **/

    private static int getShortestPath(int[][] grid){
        int n = grid.length;
        int m = grid[0].length;

        int[][] dist = new int[n][m];
        Queue<int[]> q = new LinkedList<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1 && i==0){
                    q.add(new int[]{i,j});
                    dist[i][j] = 0;
                }else{
                    dist[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};

        while(!q.isEmpty()){

            int[] pt = q.poll();
            int x = pt[0];
            int y = pt[1];

            for(int i=0;i<4;i++){
                int nx = x+dx[i];
                int ny = y+dy[i];

                if(nx>=0 && nx<n && ny>=0 && ny<m && dist[nx][ny]==Integer.MAX_VALUE && grid[nx][ny]==1){
                    dist[nx][ny] = 1 + dist[x][y];
                    q.add(new int[]{nx,ny});
                }
            }

        }

        int minDist = (int)1e5;
        for(int i=0;i<dist[0].length;i++){
            minDist = Math.min(minDist,dist[n-1][i]);
        }
        return minDist;
    }

    public static void main(String[] args) {

        int[][] grid = {{0,1,1,0,1,1,0},
                {1,1,0,0,0,0,1},
                {0,1,1,1,0,0,0},
                {0,0,1,1,0,1,1},
                {0,1,1,0,0,0,0},
                {0,0,1,1,0,0,1},
                {1,0,0,1,0,1,0},
                {1,0,0,1,0,1,0},
                {0,0,1,1,1,0,0},
                {1,0,1,0,1,1,0},
                {0,1,0,0,1,1,0},
                {1,0,1,1,0,1,0}};

        System.out.println(getShortestPath(grid));

    }

}

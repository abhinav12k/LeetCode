package Graph;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class ShortestPathInAGrid {

    static class Node {
        int x, y, dist;

        Node(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    static int shortestPath(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        int[][] dist = new int[n][m];
        for (int i = 0; i < n; i++)
            Arrays.fill(dist[i], Integer.MAX_VALUE);

        dist[0][0] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.dist));
        pq.add(new Node(0, 0, grid[0][0]));

        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        while (!pq.isEmpty()) {
            Node temp = pq.poll();

            int x = temp.x;
            int y = temp.y;

            int wt = temp.dist;

            for (int k = 0; k < 4; k++) {
                int xx = x + dx[k];
                int yy = y + dy[k];

                if (xx >= 0 && xx < n && yy >= 0 && yy < m) {
                    if (grid[xx][yy] + wt < dist[xx][yy]) {

                        Node oldNode = new Node(xx, yy, dist[xx][yy]);
                        pq.remove(oldNode);

                        dist[xx][yy] = grid[xx][yy] + wt;
                        pq.offer(new Node(xx, yy, dist[xx][yy]));
                    }
                }

            }

        }

        return dist[n-1][m-1];
    }

    public static void main(String[] args) {

        int[][] grid = {{31,100,65,12,18},
                {10,13,47,157,6},
                {100,113,174,11,33},
                {88,124,41,20,140},
                {99,32,111,41,20}};

        System.out.println(shortestPath(grid));

    }

}

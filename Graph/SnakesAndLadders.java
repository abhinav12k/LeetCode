package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SnakesAndLadders {

    static class Graph {

        int vertices;
        List<List<Integer>> nbrs;

        Graph(int vertices) {
            this.vertices = vertices;
            nbrs = new ArrayList<>(vertices);
            for (int i = 0; i < vertices; i++) {
                nbrs.add(i, new ArrayList<>());
            }
        }

        void addEdge(int a, int b, boolean undir) {
            nbrs.get(a).add(b);
            if (undir) {
                nbrs.get(b).add(a);
            }
        }

        int minCostBfs(int source, int dest) {

            Queue<Integer> queue = new LinkedList<>();
            queue.add(source);
            int[] dist = new int[vertices];
            dist[source] = 0;
            boolean[] visited = new boolean[vertices];
            visited[source] = true;

            while (!queue.isEmpty()) {
                int temp = queue.poll();

                for (int nbr : nbrs.get(temp)) {
                    if (!visited[nbr]) {
                        visited[nbr] = true;
                        dist[nbr] = dist[temp] + 1;
                        queue.offer(nbr);
                    }
                }

            }

            return dist[dest];
        }

    }

    public static void main(String[] args) {

        int n = 30;
        int[][] snakes = {{26,0},{20,8},{16,3},{18,6}};
        int[][] ladders = {{2,21},{4,7},{10,25},{19,28}};

        System.out.println(minDiceThrows(n,snakes,ladders));
    }

    private static int minDiceThrows(int n, int[][] snakes, int[][] ladders) {

        int[] board = new int[n + 1];

        for (int[] snake : snakes) {
            int s = snake[0];
            int e = snake[1];
            board[s] = e - s;
        }

        for (int[] ladder : ladders) {
            int s = ladder[0];
            int e = ladder[1];
            board[s] = e - s;
        }

        Graph g = new Graph(n + 1);
        for (int i = 1; i < n; i++) {
            for (int dice = 1; dice <= 6 && dice+i<=n; dice++) {
                int loc = i+dice;
                loc += board[loc];
                if(loc<=n)
                    g.addEdge(i,loc,true);
            }
        }

        return g.minCostBfs(1,n);
    }
}

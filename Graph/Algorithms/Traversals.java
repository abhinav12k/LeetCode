package Graph.Algorithms;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Traversals {

    static class Graph {
        int v;
        ArrayList<ArrayList<Integer>> graph;

        public Graph(int vertices) {
            this.v = vertices;
            graph = new ArrayList<>(v);
            for (int i = 0; i < v; i++)
                graph.add(new ArrayList<>());
        }

        public void addEdge(int u, int v) {
            //undirected graph
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        public int bfs(int src, int dest) {

            Queue<Integer> queue = new LinkedList<>();
            boolean[] visited = new boolean[v];

            queue.add(src);
            visited[src] = true;

            int[] parent = new int[v];
            int[] dist = new int[v];

            parent[src] = src;
            dist[src] = 0;

            while (!queue.isEmpty()) {
                int val = queue.poll();
                for (int nbr : graph.get(val)) {
                    if (!visited[nbr]) {
                        queue.offer(nbr);
                        visited[nbr] = true;
                        parent[nbr] = val;
                        dist[nbr] = dist[val] + 1;
                    }
                }
            }

            //Printing the path
            int cur = dest;
            System.out.print("End " + cur + " <- ");
            while (parent[cur] != src) {
                System.out.print(parent[cur] + " <- ");
                cur = parent[cur];
            }
            System.out.println(src + " Start");

            return dist[dest];
        }

        void dfs(int source) {
            boolean[] visited = new boolean[v];
            dfsHelper(source, visited);
        }

        private void dfsHelper(int source, boolean[] visited) {

            visited[source] = true;
            System.out.print(source + " ");

            for (int nbr : graph.get(source)) {
                if (!visited[nbr])
                    dfsHelper(nbr, visited);
            }

        }

    }


    public static void main(String[] args) {
        Graph g = new Graph(7);
        g.addEdge(1, 2);
        g.addEdge(1, 0);
        g.addEdge(2, 3);
        g.addEdge(0, 4);
        g.addEdge(4, 5);
        g.addEdge(3, 5);
        g.addEdge(5, 6);

        System.out.println(g.bfs(1, 4));
        g.dfs(0);

    }

}

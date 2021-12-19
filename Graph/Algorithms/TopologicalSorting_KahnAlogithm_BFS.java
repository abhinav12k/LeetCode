package Graph.Algorithms;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TopologicalSorting_KahnAlogithm_BFS {

    static class Graph {

        //Directed graph
        int vertices;
        ArrayList<ArrayList<Integer>> graph;

        Graph(int vertices) {
            this.vertices = vertices;
            graph = new ArrayList<>(vertices);
            for (int i = 0; i < vertices; i++)
                graph.add(new ArrayList<>());
        }

        void addEdge(int u, int v) {
            graph.get(u).add(v);
        }

        void topologicalOrder() {

            //calculating the indegree of the graph
            int[] indegree = new int[vertices];
            for (int i = 0; i < vertices; i++) {
                for (int nbr : graph.get(i)) {
                    indegree[nbr]++;
                }
            }

            //bfs
            Queue<Integer> q = new LinkedList<>();

            //adding all nodes with 0 indegree
            for (int i=0;i<indegree.length;i++) {
                if (indegree[i] == 0)
                    q.add(i);
            }

            //performing bfs
            while (!q.isEmpty()) {
                int node = q.poll();
                System.out.print(node+" ");
                for (int nbr : graph.get(node)) {
                    indegree[nbr]--;
                    if (indegree[nbr] == 0)
                        q.offer(nbr);
                }
            }

        }

    }

    public static void main(String[] args) {

        Graph g = new Graph(6);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(3, 5);
        g.addEdge(1, 2);
        g.addEdge(2, 4);
        g.addEdge(4, 5);

        g.topologicalOrder();

    }

}

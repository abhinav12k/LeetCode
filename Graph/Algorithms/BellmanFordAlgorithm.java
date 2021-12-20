package Graph.Algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BellmanFordAlgorithm {

    static class Graph {
        int vertices;
        ArrayList<Edge> edgeList;

        Graph(int vertices) {
            this.vertices = vertices;
            edgeList = new ArrayList<>();
        }

        void addEdge(int u, int v, int dist) {
            edgeList.add(new Edge(u, v, dist));
        }

        void bellmanFord(int src) {

            int[] dist = new int[vertices + 1];
            Arrays.fill(dist, Integer.MAX_VALUE);

            dist[src] = 0;

            for (int i = 0; i < vertices - 1; i++) {

                for (Edge e : edgeList) {

                    int u = e.u;
                    int v = e.v;
                    int wt = e.wt;

                    if (dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]) {
                        dist[v] = dist[u] + wt;
                    }

                }
            }

            //detecting negative wt cycle
            for (Edge e : edgeList) {
                int u = e.u;
                int v = e.v;
                int wt = e.wt;
                if (dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]) {
                    System.out.println("Found a Negative weight cycle Shortest path cannot be determined");
                    System.exit(0);
                }
            }

            for (int i = 1; i < dist.length; i++)
                System.out.println(i + " : " + dist[i]);
            
        }


        static class Edge {
            int u, v, wt;

            Edge(int from, int to, int wt) {
                this.u = from;
                this.v = to;
                this.wt = wt;
            }
        }
    }

    public static void main(String[] args) {

        Graph g = new Graph(3);
        g.addEdge(1, 2, 2);
        g.addEdge(2, 3, -1);
        g.addEdge(1, 3, 3);

        g.bellmanFord(1);

    }

}

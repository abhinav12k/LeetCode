package Graph.Algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Dijkstra {

    static class Graph{
        int vertices;
        ArrayList<ArrayList<Edge>> edgeList;

        Graph(int vertices){
            this.vertices = vertices;
            edgeList = new ArrayList<>();
            for(int i=0;i<vertices;i++)
                edgeList.add(new ArrayList<>());
        }

        static class Edge{
            int to;
            int wt;
            Edge(int to,int wt){
                this.to = to;
                this.wt = wt;
            }
        }

        void addEdge(int u,int v,int dist){
            edgeList.get(u).add(new Edge(v,dist));
            edgeList.get(v).add(new Edge(u,dist));
        }

        void shortestPath(int src){
            int[] dist = new int[vertices];

            Arrays.fill(dist,Integer.MAX_VALUE);
            dist[src] = 0;

            PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.wt));

            pq.offer(new Edge(src,0));

            while(!pq.isEmpty()){

                Edge e = pq.poll();

                for(Edge nbr: edgeList.get(e.to)){
                    if(nbr.wt != Integer.MAX_VALUE && nbr.wt+dist[e.to] < dist[nbr.to]){
                        dist[nbr.to] = dist[e.to] + nbr.wt;
                        pq.add(new Edge(nbr.to,dist[nbr.to]));
                    }
                }

            }

            int idx=0;
            for(int d: dist){
                System.out.println(idx++ +" : "+d+" ");
            }

        }
    }

    public static void main(String[] args) {

        Graph g = new Graph(6);
        g.addEdge(4,3,9);
        g.addEdge(4,0,4);
        g.addEdge(3,0,1);
        g.addEdge(3,2,5);
        g.addEdge(3,1,3);
        g.addEdge(0,1,2);
        g.addEdge(2,1,3);
        g.addEdge(2,5,8);
        g.addEdge(1,5,7);

        g.shortestPath(4);
    }

}

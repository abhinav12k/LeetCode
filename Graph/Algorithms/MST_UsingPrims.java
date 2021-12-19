package Graph.Algorithms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Prims algo works on undirected weighted graph
 * */

public class MST_UsingPrims {

    static class Graph{

        int vertices;
        //adjacency list
        ArrayList<ArrayList<Edge>> graph;

        Graph(int vertices){
            this.vertices = vertices+1;
            graph = new ArrayList<>(this.vertices);
            for(int i=0;i<this.vertices;i++){
                graph.add(new ArrayList<>());
            }
        }

        static class Edge{
            int dest,dist;
            Edge(int dest,int dist){
                this.dest = dest;
                this.dist = dist;
            }
        }

        void addEdge(int src,int dest,int dist){
            graph.get(src).add(new Edge(dest,dist));
            graph.get(dest).add(new Edge(src,dist));
        }

        int primsMST(){

            //Initialize a min heap
            PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.dist));

            boolean[] visited = new boolean[vertices];
            int ans = 0;

            ArrayList<Integer> ordering = new ArrayList<>();

            pq.offer(new Edge(1,0));

            while (!pq.isEmpty()){

                Edge e = pq.poll();

                int start = e.dest;
                int currWt = e.dist;

                if(visited[start]){
                    continue;
                }

                ordering.add(start);

                ans+=currWt;
                visited[start] = true;

                for(Edge nbr: graph.get(start)){
                    if(!visited[nbr.dest]) {
                        pq.offer(nbr);
                    }
                }

            }

            for(int order: ordering){
                System.out.print(order+" -> ");
            }
            System.out.println();
            return ans;
        }
    }

    public static void main(String[] args) {

        Graph g = new Graph(10);
        g.addEdge(1,2,10);
        g.addEdge(1,3,12);
        g.addEdge(2,3,9);
        g.addEdge(2,4,8);
        g.addEdge(3,5,3);
        g.addEdge(5,4,7);
        g.addEdge(5,6,3);
        g.addEdge(3,6,1);
        g.addEdge(4,6,10);
        g.addEdge(4,7,8);
        g.addEdge(4,8,5);
        g.addEdge(6,8,6);
        g.addEdge(7,8,9);
        g.addEdge(7,9,2);
        g.addEdge(8,9,11);

        System.out.println(g.primsMST());
    }

}

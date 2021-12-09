package Graph;

import java.util.ArrayList;
import java.util.Collections;

public class DSU_WithOptimizations {

    static class Graph{
        int vertices;
        ArrayList<Edge> edges;

        Graph(int vertices){
            this.vertices = vertices;
            edges = new ArrayList<>(vertices);
            Collections.fill(edges,new Edge(0,0));
        }

        void addEdge(int x,int y){
            edges.add(new Edge(x,y));
        }

        int findSet(int x,int[] parent){
            if(parent[x]==-1)
                return x;
            return parent[x] = findSet(parent[x],parent);
        }

        void unionSet(int x,int y,int[] parent,int[] rank){
            int s1 = findSet(x,parent);
            int s2 = findSet(y,parent);

            if(s1!=s2){
                if(rank[s1]<rank[s2]){
                    parent[s1] = s2;
                    rank[s2] += rank[s1];
                }else{
                    parent[s2] = s1;
                    rank[s1] += rank[s2];
                }
            }
        }

        boolean containsCycle(){
            int[] parent = new int[vertices];
            int[] rank = new int[vertices];
            for(int i=0;i<vertices;i++){
                parent[i] = -1;
                rank[i] = 1;
            }

            for(Edge e: edges){
                int s1 = findSet(e.src,parent);
                int s2 = findSet(e.dest,parent);

                if(s1!=s2){
                    unionSet(s1,s2,parent,rank);
                }else{
                    System.out.println("Found Cycle");
                    return true;
                }
            }
            return false;
        }

        static class Edge{
            int src,dest;
            Edge(int src,int dest){
                this.src = src;
                this.dest = dest;
            }
        }
    }

    public static void main(String[] args) {

        Graph g = new Graph(4);
        g.addEdge(0,1);
        g.addEdge(1,2);
        g.addEdge(2,3);
        g.addEdge(3,0);
        System.out.println(g.containsCycle());
    }
}

package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class DSU {

    static class Graph{

        int v;
        ArrayList<Edge> edges;

        Graph(int vertices){
            this.v = vertices;
            edges = new ArrayList<>();

            Collections.fill(edges,new Edge(0,0));
        }

        void addEdge(int u,int v){
            edges.add(new Edge(u,v));
        }

        int findSet(int i,int[] parent){
            if(parent[i]==-1)
                return i;
            return findSet(parent[i],parent);
        }

        void unionSet(int x,int y,int[] parent){
            int set1 = findSet(x,parent);
            int set2 = findSet(y,parent);
            if(set1!=set2)
                parent[set1] = set2;
        }

        boolean containsCycle(){
            int[] parent = new int[v];
            Arrays.fill(parent,-1);

            for(Edge e: edges){
                int s1 = findSet(e.src,parent);
                int s2 = findSet(e.dest,parent);

                if(s1!=s2){
                    unionSet(s1,s2,parent);
                }else{
                    System.out.println("Contains Cycle");
                    return true;
                }
            }
            return false;
        }

    }

    static class Edge{
        int src,dest;
        Edge(int source,int destination){
            this.src = source;
            this.dest = destination;
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

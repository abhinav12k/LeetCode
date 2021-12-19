package Graph.Algorithms;

import java.util.ArrayList;

public class CycleDetectionUsingDSU {

    /**
     * DSU Can only be used on undirected graphs
     **/

    static class Graph {

        static class Edge {
            int u, v;

            Edge(int u, int v) {
                this.u = u;
                this.v = v;
            }
        }

        int vertices;
        //edge list
        ArrayList<Edge> edgeList;

        Graph(int vertices) {
            this.vertices = vertices;
            edgeList = new ArrayList<>();
        }

        void addEdge(int u, int v) {
            Edge edge = new Edge(u,v);
            edgeList.add(edge);
        }

        boolean detectCycle(){

            int[] parent = new int[vertices];
            int[] rank = new int[vertices];

            for(int i=0;i<vertices;i++){
                parent[i] = -1;
                rank[i] = 1;
            }

            for(Edge e: edgeList){

                int u = e.u;
                int v = e.v;

                int set1 = findSet(u,parent);
                int set2 = findSet(v,parent);

                if(set1!=set2){
                    unionSet(set1,set2,parent,rank);
                }else{
                    System.out.println("Having same parents '"+set1+"' ---> Contains cycle");
                    return true;
                }

            }
            return false;
        }

        private int findSet(int src,int[] parent){
            if(parent[src]==-1)
                return src;
            return parent[src] = findSet(parent[src],parent);
        }

        private void unionSet(int s1,int s2,int[] parent,int[] rank){
            int set1 = findSet(s1,parent);
            int set2 = findSet(s2,parent);

            if(set1!=set2) {
                if (rank[set1] < rank[set2]) {
                    parent[set1] = set2;
                    rank[set2] += rank[set1];
                } else {
                    parent[set2] = set1;
                    rank[set1] += rank[set2];
                }
            }
        }

    }

    public static void main(String[] args) {
        Graph g = new Graph(7);
        g.addEdge(0,1);
        g.addEdge(1,2);
        g.addEdge(3,2);
        g.addEdge(2,6);
        g.addEdge(5,6);
        g.addEdge(2,5);

        System.out.println(g.detectCycle());
    }

}

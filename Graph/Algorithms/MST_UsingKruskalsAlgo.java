package Graph.Algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MST_UsingKruskalsAlgo {

    static class Graph{
        int vertices;
        ArrayList<Edge> edgeList;

        Graph(int vertices){
            this.vertices = vertices;
            edgeList = new ArrayList<>();
        }

        void addEdge(int u,int v,int dist){
            edgeList.add(new Edge(u,v,dist));
        }

        static class Edge{
            int src,dest,wt;
            Edge(int src,int dest,int wt){
                this.src = src;
                this.dest = dest;
                this.wt = wt;
            }

            @Override
            public String toString() {
                return "Edge{" +
                        "src=" + src +
                        ", dest=" + dest +
                        ", wt=" + wt +
                        '}';
            }
        }

        int kruskalMST(){

            edgeList.sort(Comparator.comparingInt(a -> a.wt));

            int[] parent = new int[vertices+1];
            int[] rank = new int[vertices+1];

            for(int i=1;i<vertices;i++){
                parent[i] = -1;
                rank[i] = 1;
            }

            ArrayList<Edge> mst = new ArrayList<>();

            int ans = 0;
            for(Edge edge: edgeList){

                int from = edge.src;
                int to = edge.dest;

                int set1 = findSet(from,parent);
                int set2 = findSet(to,parent);

                if(set1!=set2){
                    ans+=edge.wt;
                    mst.add(edge);
                    unionSet(set1,set2,parent,rank);
                }

            }

            System.out.println(mst);
            return ans;
        }

        private int findSet(int x,int[] parent){
            if(parent[x]==-1)
                return x;
            return parent[x] = findSet(parent[x],parent);
        }

        private void unionSet(int x,int y,int[] parent,int[] rank){
            int set1 = findSet(x,parent);
            int set2 = findSet(y,parent);
            if(set1!=set2){
                if(rank[set1]<rank[set2]){
                    parent[set1] = set2;
                    rank[set2] += rank[set1];
                }else{
                    parent[set2] = set1;
                    rank[set1] += rank[set2];
                }
            }
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

        System.out.println(g.kruskalMST());
    }

}

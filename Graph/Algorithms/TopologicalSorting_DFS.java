package Graph.Algorithms;

import java.util.ArrayList;

public class TopologicalSorting_DFS {
    static class Graph{
        int vertices;
        ArrayList<ArrayList<Integer>> graph;

        Graph(int vertices){
            this.vertices = vertices;
            graph = new ArrayList<>(vertices);
            for(int i=0;i<vertices;i++)
                graph.add(new ArrayList<>());
        }

        void addEdge(int u,int v){
            graph.get(u).add(v);
        }

        void topologicalOrder(){
            int[] visited = new int[vertices];

            ArrayList<Integer> ordering = new ArrayList<>();

            for(int i=0;i<vertices;i++){
                if(visited[i]==0){
                    dfsHelper(i,visited,ordering);
                }
            }

            for(int order: ordering)
                System.out.print(order+" ");
        }

        private void dfsHelper(int src,int[] visited,ArrayList<Integer> ordering){
            visited[src] = 1;
            for(int nbr: graph.get(src)){
                if(visited[nbr]==0){
                    dfsHelper(nbr,visited,ordering);
                }
            }
            ordering.add(0,src);
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

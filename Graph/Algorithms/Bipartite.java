package Graph.Algorithms;

import java.util.ArrayList;

public class Bipartite {

    static class Graph{
        int vertices;
        ArrayList<ArrayList<Integer>> graph;

        Graph(int v){
            this.vertices = v;
            graph= new ArrayList<>(v);
            for(int i=0;i<v;i++)
                graph.add(new ArrayList<>());
        }

        void addEdge(int u,int v){
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        boolean checkBipartite(){

            int[] visited = new int[vertices];
            // 0 -> not visited
            // 1 -> visited and colored with 1
            // 2 -> visited and colored with 2

            int color = 1;
            boolean ans = dfsHelper(0,visited,-1,color);

            //printing colors of graph
            for(int i=0;i<vertices;i++){
                System.out.println(i + " ->" + visited[i]);
            }

            return ans;
        }

        private boolean dfsHelper(int src,int[] visited,int parent,int color){
            visited[src] = color;

            for(int nbr: graph.get(src)){
                if(visited[nbr]==0){
                    boolean subProb = dfsHelper(nbr,visited,src,3-color);
                    if(!subProb)
                        return false;
                } else if (nbr != parent && visited[nbr] == color) {
                    return false;
                }
            }
            return true;
        }

    }

    public static void main(String[] args) {

        Graph g = new Graph(6);
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(1,3);
        g.addEdge(2,3);
        g.addEdge(3,4);
        g.addEdge(3,5);
        g.addEdge(4,5);

        System.out.println(g.checkBipartite());

    }

}

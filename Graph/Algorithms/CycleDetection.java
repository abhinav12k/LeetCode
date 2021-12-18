package Graph.Algorithms;

import java.util.ArrayList;

public class CycleDetection {

    static class Graph{

        int vertices;
        ArrayList<ArrayList<Integer>> graph;
        boolean undir = true;

        Graph(int vertices,boolean undir){
            this.undir = undir;
            this.vertices = vertices;
            graph = new ArrayList<>();
            for(int i=0;i<vertices;i++)
                graph.add(new ArrayList<>());
        }

        void addEdge(int u,int v){
            graph.get(u).add(v);
            if(undir)
                graph.get(v).add(u);
        }

        boolean detectCycle(){
            boolean[] visited = new boolean[vertices];
            if(undir) return dfsUndirected(0,visited,-1);
            else{
                boolean[] stack = new boolean[vertices];
                for(int i=0;i<vertices;i++){
                    if(!visited[i]) {
                        if(dfsDirected(i,visited,stack))
                            return true;
                    }
                }
                return false;
            }
        }

        private boolean dfsDirected(int src,boolean[] visited,boolean[] stack){
            visited[src] = true;
            stack[src] = true;
            for(int nbr: graph.get(src)){
                if(!visited[nbr]){
                    boolean hasCycle = dfsDirected(nbr,visited,stack);
                    if(hasCycle)
                        return true;
                }else if(stack[nbr]){
                    return true;
                }
            }
            stack[src] = false;
            return false;
        }

        private boolean dfsUndirected(int src, boolean[] visited, int parent){

            visited[src] = true;

            for(int nbr: graph.get(src)){
                if(!visited[nbr]) {
                    boolean hasCycle = dfsUndirected(nbr, visited, src);
                    if(hasCycle)
                        return true;
                }else if(src!=parent){
                    return true;
                }
            }
            return false;
        }

    }

    public static void main(String[] args) {

        Graph g = new Graph(6,true);
        //Undirected graph
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(1,3);
        g.addEdge(2,4);
        g.addEdge(3,4);
        g.addEdge(4,5);
        g.addEdge(3,5);

        //Directed graph
        Graph g2 = new Graph(6,false);
        g2.addEdge(1,2);
        g2.addEdge(2,3);
        g2.addEdge(3,0);
        g2.addEdge(0,1);
        g2.addEdge(0,4);
        g2.addEdge(5,4);
        g2.addEdge(0,5);

        System.out.println(g.detectCycle());
        System.out.println(g2.detectCycle());
    }

}

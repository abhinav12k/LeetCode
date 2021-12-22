package Graph.Backedge;

import java.util.ArrayList;

public class PrintCycle {

    static class Graph {
        int vertices;
        ArrayList<ArrayList<Integer>> adjacencyList;

        Graph(int vertices) {
            this.vertices = vertices;
            adjacencyList = new ArrayList<>(vertices);
            for (int v = 0; v < vertices; v++)
                adjacencyList.add(new ArrayList<>());
        }

        void addEdge(int u, int v) {
            adjacencyList.get(u).add(v);
            adjacencyList.get(v).add(u);
        }

        void printCycle(){

            int[] vis = new int[vertices];
            int[] par = new int[vertices];

            for(int i=0;i<vertices;i++)
                dfs(i,-1,vis, par);

        }

        private void dfs(int cur,int par,int[] visited,int[] parent){
            visited[cur] = 1;
            parent[cur] = par;
            for(int nbr: adjacencyList.get(cur)){
                if(visited[nbr]==0){
                    dfs(nbr,cur,visited,parent);
                }else if(nbr!=par && visited[nbr]==1){
                    //Found a backedge
                    int temp = cur;
                    while(temp!= nbr){
                        System.out.print(temp+" ");
                        temp = parent[temp];
                    }
                    System.out.println(temp+" ");
                    System.exit(0);
                }
            }
            visited[cur] = 2;
        }
    }

    public static void main(String[] args) {

        Graph g = new Graph(6);
        g.addEdge(0,1);
        g.addEdge(1,2);
        g.addEdge(2,5);
        g.addEdge(5,3);
        g.addEdge(2,3);
        g.addEdge(3,5);
        g.addEdge(0,5);

        g.printCycle();

    }

}

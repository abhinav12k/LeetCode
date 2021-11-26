package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TopologicalSort {

    static class Graph {
        int vertices;
        ArrayList<ArrayList<Integer>> nbrs;

        Graph(int v) {
            this.vertices = v;
            nbrs = new ArrayList<>(v);
            for (int i = 0; i < v; i++)
                nbrs.add(new ArrayList());
        }

        void addEdge(int x, int y) {
            nbrs.get(x).add(y);
        }

        void topologicalSortUsingBFS() {
            int[] indegree = new int[vertices];

            //preparing indegree array
            for (int i = 0; i < vertices; i++) {
                for (int nbr : nbrs.get(i)) {
                    indegree[nbr]++;
                }
            }

            //bfs
            Queue<Integer> q = new LinkedList<>();
            for (int i = 0; i < indegree.length; i++)
                if (indegree[i] == 0)
                    q.offer(i);

                //start popping
            while(!q.isEmpty()){
                int node = q.poll();
                System.out.print(node+", ");

                for(int nbr: nbrs.get(node)){
                    indegree[nbr]--;
                    if(indegree[nbr]==0)
                        q.offer(nbr);
                }
            }
        }

        void topologicalSortUsingDFS(){
            boolean[] visited = new boolean[vertices];
            ArrayList<Integer> ordering = new ArrayList<>(vertices);

            for(int i=0;i<vertices;i++) {
                if(!visited[i])
                    dfsHelper(i, visited, ordering);
            }

            //print the ordering
            for(int node: ordering){
                System.out.print(node+", ");
            }
        }

        void dfsHelper(int node,boolean[] visited,ArrayList<Integer> ordering){
            visited[node] = true;

            for(int nbr: nbrs.get(node)){
                if(!visited[nbr]){
                    dfsHelper(nbr,visited,ordering);
                }
            }
            ordering.add(0,node);
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

        g.topologicalSortUsingBFS();
        System.out.println();
        g.topologicalSortUsingDFS();
    }

}

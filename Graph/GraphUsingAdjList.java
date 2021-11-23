package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GraphUsingAdjList {

    int vertices;
    private List<List<Integer>> nbrs;

    public GraphUsingAdjList(int vertices) {
        this.vertices = vertices;
        nbrs = new ArrayList<>(vertices);
        for (int i = 0; i < vertices; i++) {
            nbrs.add(i, new ArrayList<>());
        }
    }

    public void addEdge(int i, int j, boolean undir) {
        nbrs.get(i).add(j);
        if (undir) {
            nbrs.get(j).add(i);
        }
    }

    public void printAdjList() {
        for (int i = 0; i < vertices; i++) {
            System.out.print(i + "-->");
            System.out.println(nbrs.get(i));
        }
    }

    public void bfs(int source,int dest) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(source);

        boolean[] visited = new boolean[vertices];
        int[] parent = new int[vertices];
        int[] dist = new int[vertices];

        visited[source] = true;
        parent[source] = source;
        dist[source] = 0;

        while (!queue.isEmpty()) {
            int item = queue.poll();
            System.out.print(item + " ->");

            for (int nbr : nbrs.get(item)) {
                if (!visited[nbr]) {
                    queue.offer(nbr);
                    parent[nbr] = item;
                    dist[nbr] = dist[item] + 1;
                    visited[nbr] = true;
                }
            }
        }

        System.out.println();
        System.out.println("----Parents----");
        for (int nbr = 0; nbr < vertices; nbr++) {
            System.out.println(nbr + "->" + parent[nbr]);
        }

        System.out.println("----Min Distance ----");
        for (int nbr = 0; nbr < vertices; nbr++) {
            System.out.println(nbr + "->" + dist[nbr]);
        }

        System.out.println("----Path-----");
        if(dest!=-1){

            int temp = dest;
            while(temp != source){
                System.out.print(temp + " <- ");
                temp = parent[temp];
            }
            System.out.println(source);
        }

    }

    void dfs(int source){
        boolean[] visited = new boolean[vertices];
        dfsHelper(source,visited);
    }

    private void dfsHelper(int source,boolean[] visited){
        visited[source] = true;
        System.out.print(source+", ");

        for(int nbr: nbrs.get(source)){
            if(!visited[nbr])
                dfsHelper(nbr,visited);
        }
    }

    boolean containsCycle(){

        boolean[] visited = new boolean[vertices];
        return dfs(1,visited,-1);
    }

    boolean dfs(int source,boolean[] visited,int parent){
        visited[source] = true;
        for(int nbr: nbrs.get(source)){
            if(!visited[nbr]){
                visited[nbr] = true;
                boolean isCycleDetected = dfs(nbr,visited,source);
                if(isCycleDetected){
                    return true;
                }
            }else if(nbr!=parent){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        GraphUsingAdjList g = new GraphUsingAdjList(6);
        g.addEdge(0, 1, true);
        g.addEdge(0, 4, true);
        g.addEdge(2, 1, true);
        g.addEdge(3, 4, true);
        g.addEdge(4, 5, true);
        g.addEdge(2, 3, true);
        g.addEdge(3, 5, true);

        g.printAdjList();

        g.bfs(1,5);
        g.dfs(1);

        System.out.println();
        System.out.println(g.containsCycle());
    }

}

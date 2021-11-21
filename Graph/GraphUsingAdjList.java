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

    public void bfs(int source){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(source);

        boolean[] visited = new boolean[vertices];
        visited[source] = true;

        while(!queue.isEmpty()){
            int item = queue.poll();
            System.out.print(item +" ->");

            for(int nbr: nbrs.get(item)){
                if(!visited[nbr]) {
                    queue.offer(nbr);
                    visited[nbr] = true;
                }
            }
        }
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

        g.bfs(0);
    }

}

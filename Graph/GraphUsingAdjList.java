package Graph;

import java.util.ArrayList;
import java.util.List;

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
    }

}

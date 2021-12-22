package Graph;

import java.util.ArrayList;

public class ArticulationPtAndBridges {

    static class Graph {
        private int vertices;
        private final ArrayList<ArrayList<Integer>> adjacencyList;

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

        static int time = 1;

        void printArticulationPointsAndBridges() {

            boolean[] vis = new boolean[vertices];  //to keep track of visited
            int[] dis = new int[vertices];  //to keep track of discovered time
            int[] low = new int[vertices];  //to keep track of lowest time

            ArrayList<int[]> bridges = new ArrayList<>();
            ArrayList<Integer> articulationPts = new ArrayList<>();

            dfs(0, -1, vis, dis, low, bridges, articulationPts);

            System.out.println("*******Bridges*********");
            for (int[] bridge : bridges) {
                System.out.println(bridge[0] + " - " + bridge[1]);
            }

            System.out.println("*******Articulation Points*********");
            for (int pt : articulationPts) {
                System.out.print(pt + ", ");
            }
        }

        private void dfs(int curr, int parent, boolean[] visited, int[] dis, int[] low, ArrayList<int[]> bridges, ArrayList<Integer> articulationPts) {
            visited[curr] = true;
            dis[curr] = low[curr] = time++;

            int child = 0;
            for (int nbr : adjacencyList.get(curr)) {
                if (!visited[nbr]) {
                    dfs(nbr, curr, visited, dis, low, bridges, articulationPts);
                    child++;

                    //we know low and dis of nbr
                    low[curr] = Math.min(low[curr], low[nbr]);

                    //check for bridges
                    if (low[nbr] > dis[curr]) {
                        bridges.add(new int[]{curr, nbr});
                    }

                    //check of articulation pt
                    if (parent != 0 && low[nbr] >= dis[curr]) {
                        articulationPts.add(curr);
                    }

                } else if (nbr != parent) {
                    //backedge
                    low[curr] = Math.min(low[curr], dis[nbr]);
                }
            }

            //root is articulation pt or not
            if (parent == 0 && child > 1) {
                articulationPts.add(curr);
            }
        }
    }

    public static void main(String[] args) {

        Graph g = new Graph(10);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(1, 8);
        g.addEdge(2, 7);
        g.addEdge(1, 3);
        g.addEdge(3, 4);
        g.addEdge(4, 5);
        g.addEdge(5, 6);
        g.addEdge(6, 3);
        g.addEdge(5, 9);

        g.printArticulationPointsAndBridges();
    }

}

package Graph;

import java.util.*;

public class NetworkingTheIset {

    static class Graph {
        ArrayList<ArrayList<Integer>> adjacencyList;

        Graph(int n) {
            adjacencyList = new ArrayList<>(n);
            for (int i = 0; i <= n; i++) {
                adjacencyList.add(new ArrayList<>());
            }
        }

        void addEdge(int u, int v) {
            adjacencyList.get(u).add(v);
            adjacencyList.get(v).add(u);
        }

        void printList() {
            for (ArrayList<Integer> l : adjacencyList) {
                System.out.println(l);
            }
        }
    }

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();

        Graph g = new Graph(n);
        for (int i = 0; i < m; i++) {
            int u = scn.nextInt();
            int v = scn.nextInt();

            g.addEdge(u, v);
        }

//        g.printList();

        int[] minDiaTree = new int[n + 1];
        int root = 0;
        int minDiameter = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            //assume ith node to be root and run bfs to calculate distances from root node then again run bfs from the
            //farthest node to calculate the diameter i.e the maximal distance between two nodes
            //Do the above procedure assuming each node to be the root of the tree and store the min answer as the final answer

            int[] dist = new int[n + 1];
            int[] parent = new int[n + 1];
            PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.comparingInt(a -> dist[a]));
            boolean[] visited = new boolean[n + 1];
            q.offer(i);
            visited[i] = true;
            parent[i] = i;

            int maxDist = 0;
            int maxDistNode = 0;

            while (!q.isEmpty()) {
                int temp = q.poll();
                for (int nbr : g.adjacencyList.get(temp)) {
                    if (!visited[nbr]) {
                        parent[nbr] = temp;
                        dist[nbr] = dist[temp] + 1;
                        if (maxDist < dist[nbr]) {
                            maxDist = dist[nbr];
                            maxDistNode = nbr;
                        }
                        q.offer(nbr);
                        visited[nbr] = true;
                    }
                }
            }

//            System.out.println("MaxDistance: "+maxDist);

            //searching again to find the largest distance
            Arrays.fill(visited, false);
            Arrays.fill(dist, 0);
            q.offer(maxDistNode);
            visited[maxDistNode] = true;
            parent[maxDistNode] = maxDistNode;

            int diameter = 0;

            while (!q.isEmpty()) {
                int temp = q.poll();
                for (int nbr : g.adjacencyList.get(temp)) {
                    if (!visited[nbr]) {
                        parent[nbr] = temp;
                        dist[nbr] = dist[temp] + 1;
                        diameter = Math.max(diameter, dist[nbr]);
                        q.offer(nbr);
                        visited[nbr] = true;
                    }
                }
            }

//            System.out.println("Dia:"+diameter);
            if (minDiameter >= diameter &&  minDiameter > maxDist) {
//                System.out.println("Diameter: "+diameter + " MinDia:"+minDiameter);
                root = i;
                minDiameter = diameter;
                System.arraycopy(parent, 1, minDiaTree, 1, n);
            }
        }

        for (int i = 1; i <= n; i++) {
            if (root == i)
                continue;
            if (i < minDiaTree[i])
                System.out.println(i + " " + minDiaTree[i]);
            else
                System.out.println(minDiaTree[i] + " " + i);
        }
    }

}

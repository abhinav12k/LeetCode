package Graph.Algorithms;

import java.util.Arrays;

public class FloydWarshallAlgorithm {

    //works with adjacency matrix
    private static int[][] floydWarshall(int[][] graph){

        int v = graph.length;
        int[][] dist = new int[v][v];

        for(int i=0;i<v;i++){
            for(int j=0;j<v;j++){
                dist[i][j] = graph[i][j];
            }
        }
        for(int k=0;k<v;k++){
            for(int i=0;i<v;i++){
                for(int j=0;j<v;j++){
                    if(dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE && dist[i][j] >  dist[i][k]+dist[k][j]) {
                        dist[i][j] = dist[i][k]+dist[k][j];
                    }
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) {

        //graph
        int[][] graph = {{0, Integer.MAX_VALUE, -2, Integer.MAX_VALUE},
                {4, 0, 3, Integer.MAX_VALUE},
                {Integer.MAX_VALUE,Integer.MAX_VALUE,0,2},
                {Integer.MAX_VALUE,-1,Integer.MAX_VALUE,0}};

        int[][] res = floydWarshall(graph);
        for(int i=0;i<res.length;i++){
            for(int j=0;j<res[0].length;j++){
                System.out.print(res[i][j]+"\t");
            }
            System.out.println();
        }
    }

}

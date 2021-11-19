package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GraphUsingNodeClass {

    static class Graph{

        HashMap<String,Node> map = new HashMap<>();

        private class Node{
            private String name;
            private List<String> nbrs;

            Node(String name){
                this.name = name;
                nbrs = new ArrayList<>();
            }
        }

        Graph(ArrayList<String> cities){
            for(String city: cities){
                map.put(city,new Node(city));
            }
        }

        private void addEdge(String x,String y,boolean undir){
            map.get(x).nbrs.add(y);
            if(undir){
                map.get(y).nbrs.add(x);
            }
        }

        private void printAdjList(){
            for(String city: map.keySet()){
                System.out.println(city+" -> "+map.get(city).nbrs);
            }
        }
    }

    public static void main(String[] args) {

        ArrayList<String> cities = new ArrayList(Arrays.asList("Delhi", "London","Paris","New York"));
        Graph g = new Graph(cities);

        g.addEdge("Delhi","London",false);
        g.addEdge("New York","London",false);
        g.addEdge("Delhi","Paris",false);
        g.addEdge("Paris","New York",false);

        g.printAdjList();
    }

}

package Recursion;

public class queenPermutation {
    static int count = 0;
    public static void main(String[] args) {
        int boxes = 4;
        int tq = 2;
        printQueenPermutation(boxes,new boolean[boxes],0,tq,"");
    }

    private static void printQueenPermutation(int boxes,boolean[] visited,int qpsf,int tq,String ans){

        if(qpsf == tq){
            count++;
            System.out.println(count +". "+ ans);
            return;
        }

        for(int i=0;i<boxes;i++){
            if(!visited[i]){
                visited[i] = true;
                printQueenPermutation(boxes,visited,qpsf+1,tq,ans+"q"+qpsf+"b"+i);
                visited[i]=false;
            }
        }

    }
}

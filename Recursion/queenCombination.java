package Recursion;

public class queenCombination {

    static int count = 0;

    public static void main(String[] args) {

//        printQueenCombination(5, 0, 2, "", -1);
        printQueenCombinationBoxRespect(5,0,2,"",0);
    }

    private static void printQueenCombination(int boxes, int qpsf, int tq, String ans, int lastBoxUsed) {

        if (qpsf == tq) {
            count++;
            System.out.println(count + ". " + ans);
            return;
        }

        for (int i = lastBoxUsed + 1; i < boxes; i++) {
            printQueenCombination(boxes, qpsf + 1, tq, ans + "q" + qpsf + "b" + i, i);
        }

    }

    private static void printQueenCombinationBoxRespect(int boxes,int qpsf,int tq,String ans,int idx){

        if(qpsf == tq){
            count++;
            System.out.println(count+". "+ans);
            return;
        }

        if(idx == boxes){
            return;
        }

        //Two choices - either sit / not sit
        //yes
        printQueenCombinationBoxRespect(boxes,qpsf+1,tq,ans+"b"+idx,idx+1);

        //no
        printQueenCombinationBoxRespect(boxes,qpsf,tq,ans,idx+1);
    }

}

package Recursion;

import java.util.ArrayList;

public class josephusProblem {
    public static void main(String[] args) {

        int n = 40;
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=1;i<=40;i++)
            list.add(i);
        int k = 7;
        k--;
        getTheLuckyGuy(list,k,0);
    }

    private static void getTheLuckyGuy(ArrayList<Integer> list,int k,int idx){

        if(list.size()==1){
            System.out.println(list.get(0));
            return;
        }

        idx = ( idx + k ) % list.size();
        list.remove(idx);

        getTheLuckyGuy(list,k,idx);
    }
}

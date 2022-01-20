package Practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class WarShips {

    public static void main(String[] args) {

        System.out.println(process(3,4));
    }

    public static int process(int l,int m){

        if(l==1)
            return 1;

        int ships = 1;
        Queue<Integer> q = new LinkedList<>();
        q.offer(2);
        while(!q.isEmpty() && l!=0){

            int v = q.poll();
            int sonl = (v*v+1)%m;
            if(l!=1)
                ships+=sonl;
            for(int i=0;i<sonl;i++){
                q.offer(i);
            }
            l--;
        }

        return (ships)%m;
    }

}

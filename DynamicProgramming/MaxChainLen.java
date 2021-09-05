package DynamicProgramming;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class MaxChainLen {
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        int size = scn.nextInt();
        Pair[] p_arr = new Pair[size];
        for(int i=0;i<size;i++){
            Pair p = new Pair();
            p.x = scn.nextInt();
            p.y = scn.nextInt();
            p_arr[i] = p;
        }
        System.out.println(getMaxChainLength(p_arr));
    }

    private static int getMaxChainLength(Pair[] p) {

        Arrays.sort(p, Comparator.comparingInt(a -> a.x));

        int[] t = new int[p.length];
        for(int i=0;i<p.length;i++)
            t[i] = 1;

        for(int i=1;i<p.length;i++){
            for(int j=0;j<i;j++){
                if(p[j].y < p[i].x && t[j]+1>t[i])
                    t[i] = 1+t[j];
            }
        }

        int max=0;
        for(int a: t){
            max = Math.max(max,a);
        }
        return max;
    }

    private static class Pair {
        int x, y;

        Pair() {
            this.x = 0;
            this.y = 0;
        }
    }


}

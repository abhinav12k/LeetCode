package Heap;

import java.util.PriorityQueue;

public class maxAvgPassRatio {


    public static void main(String[] args) {

    }

    private static double maxAvgRatio(int[][] classes,int extraStudents){

        PriorityQueue<double[]> maxHeap = new PriorityQueue<double[]>((o1,o2)-> (int) (o2[0]-o1[0]));

        for(int[] c : classes){
            maxHeap.offer(new double[]{profit(c[0],c[1]),c[0],c[1]});
        }

        while(extraStudents!=0){
            double[] c = maxHeap.poll();
            double a = c[1], b = c[2];
            maxHeap.offer(new double[]{profit(a,b),a,b});
            extraStudents--;
        }

        double avg = 0;
        while(!maxHeap.isEmpty()){
            double[] c = maxHeap.poll();
            avg+= c[1]/c[2];
        }
        return avg/classes.length;
    }

    //for calculating change in pass ratio
    private static double profit(double a,double b){
        return (a+1)/(b+1)-a/b;
    }

}

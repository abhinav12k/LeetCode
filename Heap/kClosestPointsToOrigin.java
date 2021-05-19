package Heap;

import java.util.PriorityQueue;

public class kClosestPointsToOrigin {

    public static void main(String[] args) {

        int[][] arr = {{1,3},{-2,2},{5,8},{0,1}};
        int[][] ans = kClosestPoints(arr,2);
        for(int[] i:ans){
            System.out.println(i[0] + " , "+i[1]);
        }

    }

    private static int[][] kClosestPoints(int[][] arr,int k){

        PriorityQueue<Pair> maxHeap = new PriorityQueue<Pair>((o1, o2) -> o2.diff - o1.diff);

        for(int i=0;i<arr.length;i++){

            maxHeap.offer(new Pair(arr[i][0]*arr[i][0]+arr[i][1]*arr[i][1],arr[i][0],arr[i][1]));
            if(maxHeap.size() > k)
                maxHeap.poll();
            System.out.println(maxHeap);
        }
        int[][] ans = new int[k][2];
        int i=0;
        while(!maxHeap.isEmpty()){
            Pair cord = maxHeap.poll();
            ans[i][0] = cord.x;
            ans[i][1] = cord.y;
            i++;
        }
        return ans;
    }

    private static class Pair{
        int diff;
        int x;
        int y;
        private Pair(int diff,int x,int y){
            this.diff = diff;
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "diff=" + diff +
                    ", x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

}

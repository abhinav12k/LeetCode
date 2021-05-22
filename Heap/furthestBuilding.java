package Heap;

import java.util.PriorityQueue;

public class furthestBuilding {

    public static void main(String[] args) {

    }

    private static int farthestBuildingViaLaddersAndBricks(int[] heights, int bricks, int ladders) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int i = 0; i < heights.length - 1; i++) {

            int d = heights[i + 1] - heights[i];
            if (d > 0) {
                minHeap.offer(d);
            }

            if (minHeap.size() > ladders) {
                //pick the smallest height and now use bricks to reach there
                bricks -= minHeap.poll();
            }

            if (bricks < 0)
                return i;
        }
        return heights.length - 1;
    }

}

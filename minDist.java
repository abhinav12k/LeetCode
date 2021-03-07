public class minDist {

    public static void main(String[] args) {

        int x= 3,y=4;
        int[][] points = {{1,2},{3,1},{2,4},{2,3},{4,4}};
        System.out.println(new Solution().nearestValidPoint(x,y,points));

    }

    static class Solution {
        public int nearestValidPoint(int x, int y, int[][] points) {
            int minIdx = Integer.MAX_VALUE;
            int minDist = Integer.MAX_VALUE;
            for(int i=0;i<points.length;i++){
                for(int j=0;j<points[i].length;j++){
                    if(x==points[i][0] || y == points[i][1]){
                        int currDist = Math.abs(x-points[i][0]) + Math.abs(y - points[i][1]);
                        if(minDist > currDist){
                            minDist = currDist;
                            minIdx = i;
                        }else if(minDist == currDist && minIdx > i){
                            minIdx = i;
                        }
                    }
                }
            }
            if(minIdx==Integer.MAX_VALUE){
                return -1;
            }
            return minIdx;
        }
    }

}

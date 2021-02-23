package Arrays;

import java.util.ArrayList;

public class mapOfHightestPeak {

    public static void main(String[] args) {

        int[][] isWater = {{0,0,1},{1,0,0},{0,0,0}};
        int[][] ans = new Solution().highestPeak(isWater);
        for(int i=0;i<ans.length;i++){
            for(int j=0;j<ans[0].length;j++){
                System.out.print(ans[i][j]+" ");
            }
            System.out.println();
        }
    }
    static class Solution {
        public int[][] highestPeak(int[][] isWater) {

            ArrayList<Pair> waterPts = new ArrayList<>();

            for(int i=0;i< isWater.length;i++){
                for(int j =0;j<isWater[0].length;j++){
                    if(isWater[i][j]==1){
                        //Water
                        Pair p = new Pair(i,j);
                        waterPts.add(p);
                        isWater[i][j]=0;
                    }
                }
            }

           for(Pair s:waterPts){
               int x = s.x;
               int y = s.y;
               if(x-1>=0 && !isWaterCell(waterPts,x-1,y))
                isWater[x-1][y] = 1;
               if(y-1>=0 && !isWaterCell(waterPts,x,y-1))
                   isWater[x][y-1] = 1;
               if(x+1<isWater.length && !isWaterCell(waterPts,x+1,y))
                   isWater[x+1][y] = 1;
               if(y+1<isWater[0].length && !isWaterCell(waterPts,x,y+1))
                   isWater[x][y+1] = 1;

           }

           for(int i=0;i< isWater.length;i++){
               for(int j=0;j<isWater[0].length;j++){
                   if(isWater[i][j]==0 && !isWaterCell(waterPts,i,j)){
                       int north = -1;
                       int south = -1;
                       int east = -1;
                       int west = -1;
                       int min = 0;
                       if(i-1>=0){
                           west = isWater[i-1][j];
                           min = west;
                       }
//                       if(i+1<isWater.length) {
//                           south = isWater[i + 1][j];
//                           min = Math.min(min,south);
//                       }
                       if(j-1>=0) {
                           north = isWater[i][j - 1];
                           min = Math.min(north,min);
                       }
//                       if(j+1<isWater[0].length) {
//                           east = isWater[i][j + 1];
//                           min = Math.min(east,min);
//                       }

                       isWater[i][j] = min + 1;
                   }
               }
           }
           return isWater;
        }

        private boolean isWaterCell(ArrayList<Pair> waterPts,int i,int j){
            for(Pair s:waterPts){
                if(s.x == i && s.y == j)
                    return true;
            }
            return false;
        }

        private class Pair{
            int x;
            int y;
            private Pair(){}
            private Pair(int x,int y){
                this.x = x;
                this.y = y;
            }
        }

    }
}

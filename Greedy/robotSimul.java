package Greedy;

import java.util.HashSet;
import java.util.Set;

public class robotSimul {

    public static void main(String[] args) {

    }

    class Solution {
        public int robotSim(int[] commands, int[][] obstacles) {

            int[] dx = new int[]{0,1,0,-1};
            int[] dy = new int[]{1,0,-1,0};
            int x = 0,y=0,di=0;

            Set<Long> obstaclesSet = new HashSet();
            for(int[] obstacle: obstacles){
                long ox = obstacle[0] + 30000;
                long oy = obstacle[1] + 30000;
                obstaclesSet.add((ox << 16) + oy);
            }

            int ans = 0;
            for(int cmd: commands){

                if(cmd == -1){  //right move
                    di = (di + 1) % 4;
                }else if(cmd == -2){    //left move
                    di = (di + 3) % 4;
                }else{

                    for(int k = 0;k<cmd;k++){
                        int nx = x + dx[di];
                        int ny = y + dy[di];
                        long code = (((long)nx * 30000) << 16) + (long) ny + 30000;
                        if(!obstaclesSet.contains(code)){
                            x = nx;
                            y = ny;
                            ans = Math.max(ans,x*x+y*y);
                        }
                    }


                }

            }
            return ans;
        }


    }

}

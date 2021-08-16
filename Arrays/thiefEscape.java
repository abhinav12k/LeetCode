package Arrays;

public class thiefEscape {

    //Link - https://www.geeksforgeeks.org/number-of-jumps-for-a-thief-to-cross-walls/
    public static void main(String[] args) {

        int[] heights = {11,10,10,9};
        int x = 10;
        int y = 1;

        System.out.println(jumpcount(x,y,heights));
    }

    private static int jumpcount(int x,int y,int[] heights){

        int jumps =0;

        for(int h: heights){

            if(h <= x){
                jumps++;
                continue;
            }

            while(h > x){
                jumps++;
                h = h - (x-y);
            }
            jumps++;
        }
        return jumps;
    }

}

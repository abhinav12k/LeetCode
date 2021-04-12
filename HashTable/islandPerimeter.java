package HashTable;

public class islandPerimeter {

    public static void main(String[] args) {

    }

    class Solution {

        public int islandPerimeterEfficient(int[][] grid){

            int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
            int count = 0;
            for(int r=0;r<grid.length;r++){
                for(int c=0;c<grid[0].length;c++){

                    for(int[] d: dir){

                        int x = r+d[0], y = c+d[1];
                        if(x<0||y<0||x==grid.length||y==grid[0].length)
                            count++;

                    }

                }
            }

            return count;
        }

        public int islandPerimeter(int[][] grid) {
            int perimeter = 0;
            for (int r = 0; r < grid.length; r++) {

                for (int c = 0; c < grid[0].length; c++) {

                    if (grid[r][c] == 1) {
                        perimeter += getPerimeter(grid, r, c);
                    }
                }

            }
            return perimeter;
        }

        private int getPerimeter(int[][] grid, int r, int c) {
            int per = 4;
            if (r > 0 && grid[r - 1][c] == 1) {
                per--;
            }
            if (c > 0 && grid[r][c - 1] == 1)
                per--;

            if (c < grid[0].length - 1 && grid[r][c + 1] == 1)
                per--;

            if (r < grid.length - 1 && grid[r + 1][c] == 1)
                per--;
            return per;

        }
    }
}
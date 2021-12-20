package Graph;

public class ColorIsland {

    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static boolean[][] visited;

    private static void colorIslands(int[][] grid){

        int n = grid.length;
        int m = grid[0].length;

        visited = new boolean[n][m];

        int totalCt=0;
        int[] colorCt= new int[1<<n];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1 && !visited[i][j]){
                    totalCt++;
                    floodFill(grid,i,j,totalCt,colorCt);
                }
            }
        }

        for(int i=1;i<=totalCt;i++){
            System.out.println("Color "+i+" -> "+colorCt[i]);
        }

    }

    private static void floodFill(int[][] grid,int x,int y,int color,int[] colorCt){
        visited[x][y] = true;
        grid[x][y] = color;
        colorCt[color]++;
        for(int i=0;i<4;i++){
            int nx = x+dx[i];
            int ny = y+dy[i];

            if(nx>=0 && nx<grid.length && ny>=0 && ny<grid[0].length && grid[nx][ny]==1 && !visited[nx][ny]){
                floodFill(grid,nx,ny,color,colorCt);
            }
        }
    }

    public static void main(String[] args) {

        int[][] grid = {{0,0,0,1,1},
                {0,1,0,0,0},
                {1,1,0,1,0},
                {1,0,1,1,1},
                {0,0,1,1,0},
                {0,0,0,0,0}};

        colorIslands(grid);

    }

}

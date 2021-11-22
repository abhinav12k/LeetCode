package Graph;

public class LargestIsland {

    private static int dfs(int[][] matrix,boolean[][] visited, int i,int j,int m,int n){

        visited[i][j] = true;

        int ct=1;

        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,1,-1};

        for(int k=0;k<4;k++){
            int nx = i+dx[k];
            int ny = j+dy[k];

            if(nx>=0 && nx<m && ny>=0 && ny<n && !visited[nx][ny] && matrix[nx][ny]==1){
                int childArea = dfs(matrix,visited,nx,ny,m,n);
                ct+=childArea;
            }
        }
        return ct;
    }

    private static int largestIsland(int[][] matrix){
        int m = matrix.length;
        int n = matrix[0].length;

        boolean[][] visited = new boolean[m][n];

        int area = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!visited[i][j] && matrix[i][j]==1)
                    area = Math.max(area,dfs(matrix,visited,i,j,m,n));
            }
        }
        return area;
    }

    public static void main(String[] args) {

        int[][] matrix = {{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0}, {
                0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0}, {
                0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0}, {
                0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};


        System.out.println(largestIsland(matrix));
    }
}

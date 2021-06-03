package Arrays;

import java.util.Scanner;

public class problem2 {

    static boolean[][] visited;
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        int tc = scn.nextInt();
        int count = 1;
        while(count<=tc){

            int n = scn.nextInt();
            int m = scn.nextInt();

            char[][] grid = new char[n][m];
            for(int i=0;i<grid.length;i++){
                String str = scn.next();
                for(int j=0;j<grid[0].length;j++){
                    grid[i][j] = str.charAt(j);
                }
            }

            String w = scn.next();


            int ct=0;
            for(int i=0;i<grid.length;i++){

                visited = new boolean[grid.length][grid[0].length];
                for(int j=0;j<grid[0].length;j++){
                    if((w.charAt(0) == grid[i][j]) && search(grid, w, i, j, 0)){
                        ct += 1;
                    }
                }
            }

            System.out.println("Case "+count+": "+ct);
            count++;
        }
    }
    private static boolean search(char[][]board, String word, int i, int j, int index){
        if(index == word.length()){
            return true;
        }

        if(i >= board.length || i < 0 || j >= board[i].length || j < 0 || board[i][j] != word.charAt(index) || visited[i][j]){
            return false;
        }

        visited[i][j] = true;
        if(search(board, word, i-1, j, index+1) ||
                search(board, word, i+1, j, index+1) ||
                search(board, word, i, j-1, index+1) ||
                search(board, word, i, j+1, index+1) ||
                search(board,word,i+1,j+1,index+1) ||
                search(board,word,i-1,j-1,index+1)){
            return true;
        }

        visited[i][j] = false;
        return false;
    }

}


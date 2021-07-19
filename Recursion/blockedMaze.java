package Recursion;

public class blockedMaze {
    public static void main(String[] args) {

        int[][] maze = {{0, 1, 0, 0}, {0, 0, 0, 0}, {0, 1, 0, 0}, {0, 0, 1, 0}};
        blockedMaze(maze, 0, 0, "", new boolean[maze.length][maze[0].length]);
    }

    private static void blockedMaze(int[][] maze, int row, int col, String ans, boolean[][] visited) {

        if (row == maze.length-1 && col == maze[0].length-1) {
            System.out.println(ans);
            return;
        }

        if (row < 0 || row >= maze.length || col < 0 || col >= maze[0].length || visited[row][col] || maze[row][col] == 1) {
            return;
        }

        visited[row][col] = true;

        //down
        blockedMaze(maze, row + 1, col, ans + "D", visited);

        //up
        blockedMaze(maze, row - 1, col, ans + "U", visited);

        //left
        blockedMaze(maze, row, col - 1, ans + "L", visited);

        //right
        blockedMaze(maze, row, col + 1, ans + "R", visited);

        visited[row][col] = false;

    }
}

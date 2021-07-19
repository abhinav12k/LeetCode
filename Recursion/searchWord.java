package Recursion;

public class searchWord {

    public static void main(String[] args) {
        char[][] arr = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'F' } };

        String word = "SEE";

        boolean ans = false;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == word.charAt(0)) {
                    ans = ans || searchWord(arr, i, j, word, 0, new boolean[arr.length][arr[0].length]);

                }
            }
        }

        System.out.println(ans);
    }

    public static boolean searchWord(char[][] arr, int row, int col, String word, int idx, boolean[][] visited) {

        if (idx == word.length()) {
            return true;
        }

        if (row < 0 || row >= arr.length || col < 0 || col >= arr[0].length || visited[row][col]) {
            return false;
        }

        if (arr[row][col] != word.charAt(idx))
            return false;

        visited[row][col] = true;

        boolean d = searchWord(arr, row + 1, col, word, idx + 1, visited);
        boolean t = searchWord(arr, row - 1, col, word, idx + 1, visited);
        boolean r = searchWord(arr, row, col + 1, word, idx + 1, visited);
        boolean l = searchWord(arr, row, col - 1, word, idx + 1, visited);

        visited[row][col] = false;

        return d || t || r || l;
    }

}

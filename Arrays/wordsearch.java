package Arrays;
import java.util.Scanner;
class wordsearch{
    static String getReverseString(String ques){
        StringBuilder str = new StringBuilder();
        for (int i = ques.length()-1; i >= 0; i--) {
            str.append(ques.charAt(i));
        }
        return str.toString();
    }
    static int getWordFound(String word, String W){
        StringBuilder check;
        int ic = 0;
        for (int i = 0; i <= word.length()-W.length(); i++) {
            check = new StringBuilder();
            for (int j = i; j < i+W.length(); j++) {
                check.append(word.charAt(j));
            }
            if (check.toString().equals(W)) {
                ic++;
            }
        }
        return ic;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[] count = new int[T];
        int i, j, k, l;

        StringBuilder cols;

        words[] grid = new words[T];

        for (i = 0; i < T; i++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            grid[i] = new words();
            grid[i].word = new String[N];
            for (j = 0; j < N; j++) {
                grid[i].word[j]=sc.next();
            }
            String W = sc.next();
            for (j = 0; j < N; j++) {
                cols = new StringBuilder(grid[i].word[j]);
                count[i] += getWordFound(cols.toString(), W);
                cols = new StringBuilder(getReverseString(cols.toString()));
                count[i] += getWordFound(cols.toString(), W);

                cols = new StringBuilder();
                k = j;
                while (k < N && k-j < M) {
                    cols.append(grid[i].word[k].charAt(k - j));
                    k++;
                }
                count[i] += getWordFound(cols.toString(), W);
                cols = new StringBuilder(getReverseString(cols.toString()));
                count[i] += getWordFound(cols.toString(), W);

                cols = new StringBuilder();
                k = j;
                l = 0;
                while (k >= 0 && l < M) {
                    cols.append(grid[i].word[k].charAt(l));
                    k--;
                    l++;
                }
                count[i] += getWordFound(cols.toString(), W);
                cols = new StringBuilder(getReverseString(cols.toString()));
                count[i] += getWordFound(cols.toString(), W);
            }

            for (j = 0; j < M; j++) {
                cols = new StringBuilder();
                for (k = 0; k < N; k++) {
                    cols.append(grid[i].word[k].charAt(j));
                }
                count[i] += getWordFound(cols.toString(), W);
                cols = new StringBuilder(getReverseString(cols.toString()));
                count[i] += getWordFound(cols.toString(), W);
            }

            for (j = 1; j < M; j++) {
                cols = new StringBuilder();
                k = j;
                while (k-j < N && k < M) {
                    cols.append(grid[i].word[k - j].charAt(k));
                    k++;
                }
                count[i] += getWordFound(cols.toString(), W);
                cols = new StringBuilder(getReverseString(cols.toString()));
                count[i] += getWordFound(cols.toString(), W);

                cols = new StringBuilder();
                l = j;
                k = N-1;
                while (k >= 0 && l < M) {
                    cols.append(grid[i].word[k].charAt(l));
                    k--;
                    l++;
                }
                count[i] += getWordFound(cols.toString(), W);
                cols = new StringBuilder(getReverseString(cols.toString()));
                count[i] += getWordFound(cols.toString(), W);
            }
        }
        for (i = 0; i < T; i++) {
            System.out.println("Case "+(i+1)+": "+count[i]);
        }
    }
}
class words{
    String[] word;
}

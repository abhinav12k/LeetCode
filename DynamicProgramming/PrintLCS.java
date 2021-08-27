package DynamicProgramming;

public class PrintLCS {
    public static void main(String[] args) {
        String X = "acbcf";
        String Y = "abcdaf";
        System.out.println(printLCS(X,Y));
    }

    private static String printLCS(String X, String Y) {
        int[][] t = new int[X.length() + 1][Y.length() + 1];
        for (int i = 1; i <= X.length(); i++) {
            for (int j = 1; j <= Y.length(); j++) {
                if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                    t[i][j] = 1 + t[i - 1][j - 1];
                } else {
                    t[i][j] = Math.max(t[i - 1][j], t[i][j - 1]);
                }
            }
        }

        int m = X.length();
        int n = Y.length();
        StringBuilder sb = new StringBuilder();
        while (m > 0 && n > 0) {

            if (X.charAt(m - 1) == Y.charAt(n - 1)) {
                sb.append(X.charAt(m - 1));
                m--;
                n--;
            } else {
                if (t[m - 1][n] > t[m][n - 1]) {
                    m--;
                } else if (t[m][n - 1] > t[m - 1][n]) {
                    n--;
                }
            }

        }
        return sb.reverse().toString();
    }
}

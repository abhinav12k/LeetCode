package Recursion;

public class kthSymbolInGrammar {

    public static void main(String[] args) {
        System.out.println(getKthSymbol(4,6));
    }

    private static int getKthSymbol(int n, int k) {

        if (n == 1 && k == 1)
            return 0;

        int mid = (int) Math.pow(2, n - 1)/2;
        if (k > mid) {
            int ans = getKthSymbol(n - 1, k - mid);
            if(ans == 0)
                return 1;
            else
                return 0;
        } else
            return getKthSymbol(n - 1, k);

    }

}

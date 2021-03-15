import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class collegeLife4 {

    public static void main(String[] args) {
        FastReader scn = new FastReader();
        int tc = scn.nextInt();
        while (tc-- != 0) {

            int N = scn.nextInt();
            int E = scn.nextInt();
            int H = scn.nextInt();

            int A = scn.nextInt();
            int B = scn.nextInt();
            int C = scn.nextInt();

            long minPrice = Long.MAX_VALUE;
            //interating over chocolate cakes
            for (int cake = 0; cake <= N; cake++) {
                int e = E - cake;
                int h = H - cake;

                //cannot make cake
                if (e < 0 || h < 0) {
                    continue;
                }

                int omelette = e/2 , shake = h/3;

                if(omelette + shake + cake < N)
                    continue;

                int leftOrders = N - cake;
                if(A <= B){
                    //omelette is cheaper
                    long currCost = (long) cake * C;
                    int min = Math.min(omelette, leftOrders);
                    currCost += min * A;
                    leftOrders -= min;
                    currCost += Math.min(leftOrders,shake) * B;

                    minPrice = Math.min(minPrice,currCost);
                }else{
                    // shake is cheaper
                    long currCost = (long) cake * C;
                    int min = Math.min(leftOrders, shake);
                    currCost += min * B;
                    leftOrders -= min;
                    currCost += Math.min(leftOrders,omelette) * A;

                    minPrice = Math.min(minPrice,currCost);
                }
            }
            if(minPrice == Long.MAX_VALUE){
                System.out.println(-1);
            }else{
                System.out.println(minPrice);
            }
        }

    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(
                    new InputStreamReader(System.in)
            );
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}

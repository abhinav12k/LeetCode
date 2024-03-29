import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class firstXOR {
    public static void main(String[] args) {

        FastReader scn = new FastReader();
        int tc = scn.nextInt();
        while(tc--!=0){

            int c = scn.nextInt();
            long a = 0, b = 0;
            int j = 0;
            Deque<Long> dq = new LinkedList<>();
            while (c != 0) {
                long val = 1L << j;

                if((c & 1) == 1){
                    dq.add(val);
                }else{
                    a |= val;
                    b |= val;
                }
                c >>= 1;
                j++;

            }
            if(!dq.isEmpty())
                a|=dq.removeLast();
            while (!dq.isEmpty())
                b|=dq.removeLast();
            System.out.println(a*b);
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

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class firstXOR {
    public static void main(String[] args) {

        FastReader scn = new FastReader();
        int tc = scn.nextInt();
        while(tc--!=0){

            int c= scn.nextInt();
//            int d = 1;
//            while(Math.pow(2,d) <= c){
//                d++;
//            }
            int d = (int)Math.ceil(Math.log(c) / Math.log(2));
            int bound = (int)Math.pow(2,d);
            long a = bound/2 - 1,b=a;
            long maxProd = 0;
            while(a<bound){

                while(b<bound){

                    if((a ^ b) == c){
                        maxProd = Math.max(maxProd,a*b);
                    }
                    b++;
                }
                a++;
            }
            System.out.println(maxProd);
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

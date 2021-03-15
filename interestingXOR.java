import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class interestingXOR {

    public static void main(String[] args) {

        FastReader scn = new FastReader();
        int tc = scn.nextInt();
        while (tc-- != 0) {

            int c = scn.nextInt();
            long a=0,b=0;
            boolean fl = false;

            for(int i=35;i>=0;i--){

                long val = 1L << i;
                if((c & val) > 0){
                    if(!fl){
                        a|=val;
                        fl = true;
                    }else{
                        b|=val;
                    }
                }else{
                    if(val<=c) {
                        a |= val;
                        b |= val;
                    }
                }
//                System.out.println("*********");
//                System.out.println(val+"\n"+a+"\n"+b);
            }
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

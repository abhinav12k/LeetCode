import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class interestingXOR {

    public static void main(String[] args) {

        FastReader scn = new FastReader();
        int tc = scn.nextInt();
        while (tc-- != 0) {

            int c = scn.nextInt();
            int bn = 0;
            int multi = 1;
            int size = 0;
            while (c != 0) {

                int rem = c % 2;
                bn = bn + rem * multi;
                multi *= 10;
                c = c / 2;
                size++;
            }
//            System.out.println(size);
            int lt = size;
            int a = 0;
            int b = 0;
            multi = 1;
            while (lt > 1) {

                int rem = bn % 10;
                if (rem == 1) {
                    a = a + 0 * multi;
                } else {
                    a = a + 1 * multi;
                }
                b = b + 1 * multi;
                multi *= 10;
                bn = bn/10;
                lt--;
            }
            a = a + multi*1;
//            System.out.println("a: "+a);
//            System.out.println("b: "+b);

            //convert to decimal
            int aDecimal = 0;
            int bDecimal = 0;
            multi = 1;
            while(a!=0){

                int rem = a%10;
                int rem1 = b%10;
                bDecimal = bDecimal + rem1 * multi;
                aDecimal = aDecimal + rem * multi;
                multi*=2;
                b=b/10;
                a=a/10;
            }
            System.out.println(aDecimal*bDecimal);
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

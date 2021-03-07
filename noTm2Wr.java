import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class noTm2Wr {

    public static void main(String[] args) {

        FastReader scn = new FastReader();

            int nTz = scn.nextInt();
            int reqTm = scn.nextInt();
            int rmTm = scn.nextInt();

            int[] tzones = new int[nTz];
            for(int i=0;i<tzones.length;i++){
                tzones[i] = scn.nextInt();
            }

            Arrays.sort(tzones);
            boolean fl = false;
            for(int i =tzones.length-1;i>=0;i--) {
                if (rmTm+tzones[i] >= reqTm) {
                    System.out.println("Yes");
                    fl = true;
                    break;
                }
            }
            if(!fl)
                System.out.println("No");


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

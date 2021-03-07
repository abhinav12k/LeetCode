import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class chefGrp {

    public static void main(String[] args) {

        FastReader scn = new FastReader();
        int tc = scn.nextInt();
        while (tc-- != 0) {

            String s = scn.next();

            int grp = 0;
            for (int i = 0; i < s.length(); i++) {
                while (i < s.length() - 1 && s.charAt(i + 1) == s.charAt(i))
                    i++;
                if(i==s.length()){
                    //all same
                    if(s.charAt(i)=='0')
                        break;
                    else if(s.charAt(i)=='1')
                        grp++;
                }
                if(s.charAt(i)=='1')
                    grp++;
            }
            System.out.println(grp);
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
